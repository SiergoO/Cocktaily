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

rootProject.name = "Cocktaily"
include(":app")
include(":common")
include(":data")
include(":domain")
include(":presentation:cocktailList")
include(":presentation:cocktailDetails")
