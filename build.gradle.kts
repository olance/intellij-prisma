plugins {
    id("org.jetbrains.intellij") version "0.7.2"
    kotlin("jvm") version "1.4.32"
}

group = "io.techtrails.intellij"

val pluginVersion: String by project
version = pluginVersion

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    val ideaVersion: String by project
    version = ideaVersion
    pluginName = rootProject.name

    updateSinceUntilBuild = false
}

sourceSets["main"].java.srcDir("src/main/gen")

tasks.withType<JavaCompile> {
    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
}

tasks {
    patchPluginXml {
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    publishPlugin {
        val intellijPublishToken: String by project
        token(intellijPublishToken)
    }
}
