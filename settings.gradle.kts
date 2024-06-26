pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MDP"

include(":app")
include(":core")
include(":uikit")
include(":assignment2")
include(":assignment3")
include(":assignment4")
include(":assignment5")
include(":assignment6")
include(":assignment7")
include(":extra")
