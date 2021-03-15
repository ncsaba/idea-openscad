# OpenSCAD Intellij plugin ChangeLog

## [Unreleased]
### Changed
- "Generate" ... actions have been transformed into an "Export as ..." action that allow for target file path and type selection.

### Fix
- Issue-59 NullPointerException In Intellij
- Issue-62 Doesn't open app correctly if file path includes spaces

## 2.0.1
### Changed
- Update GitHub actions and changelog format

### Fix
- Fix [Issue-56](https://github.com/ncsaba/idea-openscad/issues/56)

## 2.0.0
### Added
- Add code formatter
- Add settings for OpenSCAD libraries and executable
- Add import reference
- Add editor context menu open OpenSCAD and generate actions
- Add completion for variables, modules and functions

### Changed
- Update compatibility version from 192.2549 to no limit

### Fix
- Fix deprecated calls

## 1.3.0
### Added
- Added structure view
- Partial code navigation (modules/functions/variables without considering context)
- Documentation popups

### Changed
- Change version number to 1.3.0

### Fix
- Fix known grammar parsing issues

## 1.2.0
### Fix
- Fixed change-log from the default text

## 1.1.0
### Changed
- Updated plugin name to conform to standards for uploading to the jetbrains plugin repository.

## 1.0.0
### Added
- Syntax highlighting
- Code folding
