plugins {
    kotlin("jvm")
    `maven-publish`
}

dependencies {
    api("io.arrow-kt:arrow-core:0.8.2")
    implementation(kotlin("stdlib-jdk8"))

    // Use the Kotlin test librar, Use the Kotlin JUnit integration.
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}


val sourcesJar by tasks.registering(Jar::class) {
    classifier = "sources"
    from(sourceSets.main.get().allSource)
}

publishing {
    repositories {
        maven(uri("${rootProject.buildDir}/repo"))
    }
    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
            artifact(sourcesJar.get())
        }
    }
}
