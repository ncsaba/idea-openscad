# Contributing

## Issues and new feature requests

For bugs and new features, create an issue.

Simple examples to reproduce the issue or the expected behavior will be a great help.

## Pull requests

All PR are welcomed !
If they are linked to an issue please refer to it.

## Test development version

We have implemented GitHub actions so that the plugin gets automatically packaged by GitHub.

To test a specific version, go in the *Actions* tab. Click on the execution related to the branch or the sha-1 you want to test,
download the zip file and unzip it to get the plugin zip distribution archive inside main zip file.

In IntelliJ, go in *File* -> *Settings...* -> *Plugins* -> ![configuration icon](https://raw.githubusercontent.com/JetBrains/intellij-community/master/platform/icons/src/general/gearPlain.svg?sanitize=true) -> *Install Plugin from Disk...* and select the distribution zip file you have unzipped.

Restart IntelliJ to test development version.

Not that you can also get a distribution zip files from forks to test PRs.
