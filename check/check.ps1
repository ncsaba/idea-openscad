# android studio
# https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/clion/clion/2020.2.4/clion-2020.2.4.zip
# https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/goland/goland/2020.2.3/goland-2020.2.3.zip
# https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/idea/ideaIC/202.7660.26/ideaIC-202.7660.26.zip
# https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/idea/ideaIU/202.7660.26/ideaIU-202.7660.26.zip
# https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/pycharm/pycharmPC/2020.2.3/pycharmPC-2020.2.3.zip
# https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/pycharm/pycharmPY/2020.2.3/pycharmPY-2020.2.3.zip
# https://download.jetbrains.com/webstorm/WebStorm-2020.2.3.tar.gz

$VERIFIER_VERSION = "1.250"
$VERIFIER_URL = "https://bintray.com/jetbrains/intellij-plugin-service/download_file?file_path=org%2Fjetbrains%2Fintellij%2Fplugins%2Fverifier-cli%2F$VERIFIER_VERSION%2Fverifier-cli-$VERIFIER_VERSION-all.jar"

$PRODUCT_MAP = @{
    clion = "https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/clion/clion"
    goland = "https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/goland/goland"
    ideaIC = "https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/idea/ideaIC"
    ideaIU = "https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/idea/ideaIU"
    pycharmPC = "https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/pycharm/pycharmPC"
    pycharmPY = "https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/pycharm/pycharmPY"
}

function Test-Version
{
    param (
        [string] $Version,
        [string[]] $Products = ("clion", "goland", "ideaIC", "ideaIU", "pycharmPC", "pycharmPY")
    )

    # CD to current script path
    Split-Path -parent $PSCommandPath | Set-Location

    # Download verifier if needed
    $VerifierJar = "verifier-cli-$VERIFIER_VERSION-all.jar"
    if (-not(Test-Path -Path ./$VerifierJar))
    {
        Invoke-WebRequest -Uri $VERIFIER_URL -OutFile ./$VerifierJar
    }

    # Download product if needed
    foreach ($Product in $Products)
    {
        # Get binary
        if (Test-Path -Path ../IDE/$Product-$Version)
        {
            Write-Host "Binary ../IDE/$Product-$Version already available, skipping download"
        }
        else
        {
            # Download
            if (Test-Path -Path ../IDE/$Product-$Version.zip)
            {
                Write-Host "Archive $Product-$Version.zip already available, skipping download"
            }
            else
            {
                $rootURI = $PRODUCT_MAP[$Product]
                Write-Host "Downloading $rootURI/$Version/$Product-$Version.zip"
                try
                {
                    Invoke-WebRequest -Uri "$rootURI/$Version/$Product-$Version.zip" -OutFile "../IDE/$Product-$Version.zip"
                }
                catch
                {
                    Write-Warning "An error occurred while downloading $rootURI/$Version/$Product-$Version.zip, skipping this version"
                    continue
                }
            }

            # Unzip
            try
            {
                Write-Host "Unzipping ../IDE/$Product-$Version.zip"
                Expand-Archive -Path "../IDE/$Product-$Version.zip" -DestinationPath "../IDE/$Product-$Version"
            }
            catch
            {
                Write-Error "An error occurred while unzipping ../IDE/$Product-$Version.zip"
                continue
            }
        }

        # Test
        Write-Host "Testing $Product-$Version"
        java -jar ./$VerifierJar check-plugin ../build/distributions/idea-openscad "../IDE/$Product-$Version" -r "$Env:USERPROFILE\.jdks\jbrsdk-11_0_8-windows-x64"

        # Move result
        Write-Host "Moving $Product-$Version results"
        try
        {
            $ReportFolder = Get-ChildItem -Path verification-*/* -Directory
            Write-Host "Found report in $ReportFolder"
            if (Test-Path -Path "./$( $ReportFolder.Name )")
            {
                Write-Host "Removing old report $( $ReportFolder.Name )"
                Remove-Item -Recurse "./$( $ReportFolder.Name )"
            }

            Move-Item -Path $ReportFolder -Destination "./$( $ReportFolder.Name )"
            Get-ChildItem -Path verification-* | Remove-Item -Recurse
        }
        catch
        {
            Write-Error "An error occurred while moving $Product-$Version report"
            continue
        }
    }
}

Test-Version -Version "202.7660.26"