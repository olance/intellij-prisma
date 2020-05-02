plugins {
    id("org.jetbrains.intellij") version "0.4.18"
    kotlin("jvm") version "1.3.72"
}

group = "io.techtrails.intellij"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version = "2020.1.1"
    pluginName = rootProject.name
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
tasks.getByName<org.jetbrains.intellij.tasks.PatchPluginXmlTask>("patchPluginXml") {
    changeNotes("""
      Add change notes here.<br>
      <em>most HTML tags may be used</em>""")
}