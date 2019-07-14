plugins {
    base
    idea

    id("com.github.breadmoirai.github-release") version Versions.plugin.githubRelease

    kotlin("jvm") version Versions.kotlin apply false
}

allprojects {
    group = "com.github.jangalinski"
    version = "0.1.0-SNAPSHOT"

    apply {
        from("${rootProject.rootDir}/gradle/repositories.gradle.kts")
    }
}

dependencies {
    subprojects.forEach {
        archives(it)
    }
}



githubRelease {
    setToken(properties["github.token"] as String)
    setOverwrite(true)
    setPrerelease((project.version as String).endsWith("-SNAPSHOT"))
    releaseAssets(File("${rootProject.buildDir}/core-${project.version}.zip"))
}



idea {
    module {
        excludeDirs = mutableSetOf(File("gradle"))
    }
}