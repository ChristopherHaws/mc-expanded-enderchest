# Contributing

## Adding a feature
1. Assign yourself to an issue
2. Create a branch based on:
   - `main` if the changes can be supported in the current version
   - `mc/*` if the changes do not apply to the current version (pick the latest version the issue applies to)
3. Update the changelog and readme files
4. Create a pull request into the `main` or `mc/*` branch
5. Include the following text in the pull request summary (not title):
   - Features: `Closes #{issue number}`
   - Bugs: `Fixes #{issue number}`

## New Minecraft version
1. Make a new branch based on `main` and make the following changes:
   - Update the Minecraft version and dependency versions in the `gradle.properties` and `fabric.mod.json` files
   - Update the supported versions of Minecraft in `./github/workflows/release.yml`
   - Update the changelog and readme files
2. Create a pull request into `main`

### Breaking changes (usually minor Minecraft versions)
If the new version of Minecraft contains breaking changes, then create a new `mc/*` branch based on the current version of `main` before merging the new version into `main`

## Releasing to GitHub, Modrinth, and CurseForge
1. Tag the commit in the `main` or `mc/*` branch using the format `v1.0.0+1.19.3`
2. Create a new branch based on `main` and make the following changes:
   - Update the mod version in `gradle.properties` and `fabric.mod.json` files
   - Update the changelog and readme files
3. Create a pull request into `main`

## Back-porting to an `mc/*` branch
1. Cherry-pick the commits from `main` into the `mc/*` branch
2. Make the following changes in a new commit (do not amend the cherry-pick commits):
   - Make sure all the versions are correct when cherry-picking the "update version" commit
   - Update the changelog and readme files
   - Fix any errors in code caused by downgrading versions
3. Manually test the mod in `client` and `server` modes
4. [Release to GitHub, Modrinth, and CurseForge](#releasing-to-github-modrinth-and-curseforge)

## Updating gradle
https://docs.gradle.org/current/userguide/gradle_wrapper.html#sec:upgrading_wrapper
