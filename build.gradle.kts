plugins {
    kotlin("jvm") version "2.3.0"
    id("com.gradleup.shadow") version "9.3.1"
}

group = "me.xeroup"
version = "1.0"

repositories {
    mavenCentral()
}

tasks {
    build {
        dependsOn(shadowJar)
    }

    shadowJar {
        archiveClassifier.set("")
        archiveVersion.set(version.toString())

        manifest {
            attributes(Pair("Main-Class", "me.xeroup.otlang.MainKt"))
        }
    }
}

kotlin {
    jvmToolchain(21)
}