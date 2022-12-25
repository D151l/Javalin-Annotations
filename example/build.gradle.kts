plugins {
    id ("com.github.johnrengelman.shadow") version "7.0.0"
    id ("application")
}

repositories {
}

dependencies {
    implementation(project(":core"))
    implementation("org.slf4j:slf4j-simple:2.0.3")
}

application {
    mainClass.set("me.d151l.javalin.annotations.example.main.MainKt")
}