import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
}

allprojects {
    group = "me.d151l.javalin.annotations"
    version = "1.0.0-SNAPSHOT"
}

subprojects {
    apply {
        plugin("java")
        plugin("kotlin")
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        compileOnly("io.javalin:javalin:5.2.0")
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}