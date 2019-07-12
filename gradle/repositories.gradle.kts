repositories {

  // prefer artifacts from local cache
  mavenLocal()

  // if not found, search on jcenter
  jcenter()

  maven("https://jitpack.io")
}
