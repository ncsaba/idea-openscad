# android studio
# https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/clion/clion/2020.2.4/clion-2020.2.4.zip
# https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/goland/goland/2020.2.3/goland-2020.2.3.zip
# https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/idea/ideaIC/202.7660.26/ideaIC-202.7660.26.zip
# https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/idea/ideaIU/202.7660.26/ideaIU-202.7660.26.zip
# https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/pycharm/pycharmPC/2020.2.3/pycharmPC-2020.2.3.zip
# https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/pycharm/pycharmPY/2020.2.3/pycharmPY-2020.2.3.zip
# https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/rider/riderRD/2020.1/riderRD-2020.1.zip
# https://download.jetbrains.com/webstorm/WebStorm-2020.2.3.tar.gz
# https://download.jetbrains.com/webide/PhpStorm-182.3458.35.tar.gz

$VERIFIER_VERSION = "1.254"
$VERIFIER_URL = "https://bintray.com/jetbrains/intellij-plugin-service/download_file?file_path=org%2Fjetbrains%2Fintellij%2Fplugins%2Fverifier-cli%2F$VERIFIER_VERSION%2Fverifier-cli-$VERIFIER_VERSION-all.jar"

function Test-Version
{
    param (
        [string] $Version,
        [string[]] $Products = ("clion", "goland", "ideaIC", "ideaIU", "pycharmPC", "pycharmPY", "riderRD", "webide", "webstorm")
    )

    # CD to current script path
    Split-Path -parent $PSCommandPath | Set-Location

    # Download verifier if needed
    $VerifierJar = "verifier-cli-$VERIFIER_VERSION-all.jar"
    if (-not(Test-Path -Path ./$VerifierJar))
    {
        Invoke-WebRequest -Uri $VERIFIER_URL -OutFile ./$VerifierJar
    }

    # Check and extract plugin distribution
    if (Test-Path -Path ../build/distributions/idea-openscad)
    {
        Write-Host "Distribution found in ../build/distributions/idea-openscad"
    }
    else
    {
        if (Test-Path -Path ../build/distributions/idea-openscad-*.zip)
        {
            Write-Host "Extracting distribution"
            Expand-Archive -Path ../build/distributions/idea-openscad-*.zip -Destination ../build/distributions/tmp
            Move-Item -Path ../build/distributions/tmp/idea-openscad -Destination ../build/distributions/idea-openscad
            Remove-Item -Recurse ../build/distributions/tmp
        }
        else
        {
            Write-Error "Can not find distribution, execute gradle buildPlugin and retry"
            exit 1
        }
    }

    # Download product if needed
    foreach ($Product in $Products)
    {
        # Download IDE
        Get-IDE -Version $Version -Product $Product

        # Test
        Write-Host "Testing $Product-$Version"
        java -jar ./$VerifierJar check-plugin ../build/distributions/idea-openscad "../IDE/$Product-$Version" -r "$Env:USERPROFILE\.jdks\jbrsdk-11_0_8-windows-x64"

        # Move result
        Write-Host "Moving $Product-$Version results"
        try
        {
            $ReportFolder = Get-ChildItem -Path verification-*/* -Directory
            if ($ReportFolder)
            {
                Write-Host "Found report in $ReportFolder"
                if (Test-Path -Path "./$( $ReportFolder.Name )")
                {
                    Write-Host "Removing old report $( $ReportFolder.Name )"
                    Remove-Item -Recurse "./$( $ReportFolder.Name )"
                }

                Move-Item -Path $ReportFolder -Destination "./$( $ReportFolder.Name )"
                Get-ChildItem -Path verification-* | Remove-Item -Recurse
            }
            else
            {
                Write-Warning "No report found for $Product-$Version, an error must have occured previsouly"
            }
        }
        catch
        {
            Write-Error "An error occurred while moving $Product-$Version report"
            continue
        }
    }
}

function Get-IDE
{
    param (
        [string] $Version,
        [string] $Product
    )

    # Look for binary folder
    if (-Not(Test-Path -Path ../IDE/$Product-$Version))
    {
        # Look for archive
        if (-Not(Test-Path -Path ../IDE/$Product-$Version.* -PathType Leaf))
        {
            Write-Host "Downloading $Product $Version archive ..."
            $downloadURL = "https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij"
            switch ($Product)
            {
                "clion" {
                    $downloadURL = $downloadURL + "/clion/$Product/$Version/$Product-$Version.zip"
                }
                "goland" {
                    $downloadURL = $downloadURL + "/goland/$Product/$Version/$Product-$Version.zip"
                }
                "ideaIC" {
                    $downloadURL = $downloadURL + "/idea/$Product/$Version/$Product-$Version.zip"
                }
                "ideaIU" {
                    $downloadURL = $downloadURL + "/idea/$Product/$Version/$Product-$Version.zip"
                }
                "pycharmPC" {
                    $downloadURL = $downloadURL + "/pycharm/$Product/$Version/$Product-$Version.zip"
                }
                "pycharmPY" {
                    $downloadURL = $downloadURL + "/pycharm/$Product/$Version/$Product-$Version.zip"
                }
                "riderRD" {
                    $downloadURL = $downloadURL + "/rider/$Product/$Version/$Product-$Version.zip"
                }
                "webide" {
                    $downloadURL = "https://download.jetbrains.com/webide/PhpStorm-$Version.tar.gz"
                }
                "webstorm" {
                    $downloadURL = "https://download.jetbrains.com/webstorm/WebStorm-$Version.tar.gz"
                }
                Default {
                    Write-Error "Unknown product $Product, skipping it"
                    continue
                }
            }
            try
            {
                if ( $downloadURL.endswith(".zip"))
                {
                    Invoke-WebRequest -Uri "$downloadURL" -OutFile "../IDE/$Product-$Version.zip"
                }
                else
                {
                    Invoke-WebRequest -Uri "$downloadURL" -OutFile "../IDE/$Product-$Version.tar.gz"
                }
            }
            catch
            {
                Write-Warning "An error occurred while downloading $downloadURL"
                exit 1
            }
        }

        # Extract IDE
        $archive = Get-ChildItem -Path ../IDE/$Product-$Version.* -File | Select-Object -First 1
        Write-Host "Extracting $archive"

        try
        {
            if ( $archive.fullname.endswith(".zip"))
            {
                Expand-Archive -Path "../IDE/$Product-$Version.zip" -DestinationPath "../IDE/$Product-$Version"
            }
            else
            {
                New-Item -Path "../IDE/tmp" -ItemType Directory
                tar -xzf $archive -C "../IDE/tmp"
                Get-ChildItem -Path ../IDE/tmp -Directory | Select-Object -First 1 | Move-Item -Destination "../IDE/$Product-$Version"
                Remove-Item -Path ../IDE/tmp -Recurse
            }
        }
        catch
        {
            Write-Error "An error occurred while extracting $archive"
            continue
        }
    }

    Write-Host "Binary ../IDE/$Product-$Version is available"
}

Test-Version -Version "2020.1"