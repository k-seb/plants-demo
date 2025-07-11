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

rootProject.name = "PlantsOrganizer"
include(":app")
include(":core")
include(":core:ui")
include(":data")
include(":domain")
include(":feature:plants")
include(":feature:plantdetails")