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

sourceSets["main"].java.srcDir("src/main/gen")

tasks.withType<JavaCompile> {
    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
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
      <b>Upcoming</b>
      <ul>
        <li>Prisma-specific Color Scheme for a more controlled syntax highlighting</li>
      </ul>
        
      <b>v0.0.1</b>
      <ul>
        <li>Recognition of `.prisma` files</li>
        <li>Very basic syntax highlighting (using default Color Scheme)</li>
      </ul>
      """)
}