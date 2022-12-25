plugins {
    id ("com.github.johnrengelman.shadow") version "7.0.0"
    id ("application")
}

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("io.javalin:javalin:5.2.0")
    implementation("com.github.D151l:Javalin-Annotations:868f9de2e3")
    implementation("org.slf4j:slf4j-simple:2.0.3")
}

application {
    mainClass.set("me.d151l.javalin.annotations.example.main.MainKt")
}