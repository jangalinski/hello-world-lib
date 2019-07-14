plugins {
    kotlin("jvm")
    maven
}

dependencies {
    api("io.arrow-kt:arrow-core:0.8.2")
    implementation(kotlin("stdlib-jdk8"))

    // Use the Kotlin test librar, Use the Kotlin JUnit integration.
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}
//
//
//val sourcesJar by tasks.registering(Jar::class) {
//    classifier = "sources"
//    from(sourceSets.main.get().allSource)
//}
//
//publishing {
//    repositories {
//        maven(uri("${rootProject.buildDir}/repo"))
//    }
//    publications {
//        register("mavenJava", MavenPublication::class) {
//            from(components["java"])
//            artifact(sourcesJar.get())
//        }
//    }
//}
//
//tasks.register<Zip>("zipArchive") {
//    val (suf,dom,name) = "${project.group}".split(".")
//    val path = "${project.group}".replace(".","/")
//    from("${rootProject.buildDir}/repo/$path/${project.name}/${project.version}")
//    archiveFileName.set("${project.name}-${project.version}.zip")
//    destinationDirectory.set(File("${rootProject.buildDir}"))
// //   destinationDirectory = "${rootProject.buildDir}"
//}
//
//
////
////task myZip(type: Zip) {
////    from 'Reports/'
////    include '*'
////    include '*/*' //to include contents of a folder present inside Reports directory
////    archiveName 'Reports.zip'
////    destinationDir(file('/dir1/dir2/dir3/'))
////}