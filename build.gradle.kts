import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("xyz.jpenilla.run-paper") version "2.2.0"
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
}

group = "de.asula"
version = 1.0
description = "Template Plugin for Paper Servers"

repositories {
    maven(uri("https://repo.papermc.io/repository/maven-public/"))
    mavenCentral()
}

dependencies {
    // lombok
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    // paper api
    compileOnly("io.papermc.paper:paper-api:1.20.2-R0.1-SNAPSHOT")

    // jetbrains annotations
    implementation("org.jetbrains:annotations:24.0.1")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

tasks {
    runServer {
        minecraftVersion("1.20.2")
    }
}

bukkit { // example plugin.yml generator
    name = rootProject.name // defined in settings.gradle.kts
    version = project.version.toString() // defined in line 11 of the template
    description = project.description // defined in line 12 of the template
    website = "https://asula.de"
    author = "malte"

    main = "de.asula.papertemplate.PaperTemplate"
    apiVersion = "1.20"

//    depend = listOf("SomeRequiredDependencies")       // like this add dependencies
//    softDepend = listOf("SomeOptionalDependencies")   // like this add optional dependencies

    commands {
        register("template") {
            aliases = listOf("tmpl")
            permission = "template.template"
            description = "Template Command"
            usage = "/<command>"
        }
    }

    permissions {
        register("template.template") {
            description = "Template Permission"
            default = BukkitPluginDescription.Permission.Default.OP
        }
    }
}