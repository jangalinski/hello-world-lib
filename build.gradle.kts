plugins {
    base
    idea

    id("com.github.breadmoirai.github-release") version Versions.plugin.githubRelease

    kotlin("jvm") version Versions.kotlin apply false
    
    maven
}

allprojects {
    group = "com.github.jangalinski"
    version = "0.1.2-SNAPSHOT"

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
    val snapshot = (project.version as String).endsWith("-SNAPSHOT")
    setToken(properties["github.token"] as String)
    setOverwrite(snapshot)
    setPrerelease(snapshot)
    //releaseAssets(File("${rootProject.buildDir}/core-${project.version}.zip"))
}



idea {
    module {
        excludeDirs = mutableSetOf(File("gradle"))
    }
}