plugins {
    id("org.jetbrains.intellij") version "0.4.18"
    kotlin("jvm") version "1.3.72"
}

group = "io.techtrails.intellij"
version = "1.0.0"

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
}

sourceSets["main"].java.srcDir("src/main/gen")

tasks.withType<JavaCompile> {
    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
}

tasks {
    patchPluginXml {
        val pluginSinceBuild: String by project
        val pluginUntilBuild: String by project

        sinceBuild(pluginSinceBuild)
        untilBuild(pluginUntilBuild)
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
