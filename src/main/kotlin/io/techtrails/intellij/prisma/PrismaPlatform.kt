package io.techtrails.intellij.prisma

import com.intellij.openapi.util.SystemInfo
import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit

class Platform(val platform: String, val distro: String? = null, val libssl: String? = null)

/**
 * Implements @prisma/get-platform:
 * https://github.com/prisma/prisma/blob/master/src/packages/get-platform/src/getPlatform.ts
 */
object PrismaPlatform {
    fun runCommand(command: String, workingDir: File?): String? {
        return try {
            val parts = command.split("\\s".toRegex())
            val proc = ProcessBuilder(*parts.toTypedArray())
                .directory(workingDir)
                .redirectOutput(ProcessBuilder.Redirect.PIPE)
                .redirectError(ProcessBuilder.Redirect.PIPE)
                .start()

            proc.waitFor(10, TimeUnit.SECONDS)
            proc.inputStream.bufferedReader().readText()
        } catch(e: IOException) {
            e.printStackTrace()
            null
        }
    }

    fun getOs(): Platform {
        if (SystemInfo.isMac) {
            return Platform("darwin")
        }

        if (SystemInfo.isWindows) {
            return Platform("windows")
        }

        if (SystemInfo.isFreeBSD) {
            return Platform("freebsd")
        }

        if (SystemInfo.OS_NAME.toLowerCase() in arrayOf("openbsd", "netbsd")) {
            return Platform(SystemInfo.OS_NAME.toLowerCase())
        }

        return Platform("linux", getOpenSSLVersion(), getDistro())
    }

    fun getOpenSSLVersion(): String? {
        val versionString = runCommand("openssl version -v", null)
        if (versionString != null) {
            val regex = "^OpenSSL\\s(\\d+\\.\\d+)\\.\\d+".toRegex()
            if (versionString.contains(regex)) {
                val match = regex.find(versionString)
                return match!!.groupValues[1] + ".x"
            }
        }

        val lsResults = runCommand("ls -l /lib64 | grep ssl; ls -l /usr/lib64 | grep ssl;", null)
        if (lsResults != null) {
            val regex = "libssl\\.so\\.(\\d+\\.\\d+)\\.\\d+".toRegex()
            if (lsResults.contains(regex)) {
                val match = regex.find(lsResults)
                return match!!.groupValues[1] + ".x"
            }
        }

        return null
    }

    fun parseDistro(input: String): String? {
        val idRegex = "^ID=\"?([^\"\\n]*)\"?\$".toRegex(setOf(RegexOption.IGNORE_CASE, RegexOption.MULTILINE))
        val idLikeRegex = "^ID_LIKE=\"?([^\"\\n]*)\"?\$".toRegex(setOf(RegexOption.IGNORE_CASE, RegexOption.MULTILINE))

        val idMatch = idRegex.find(input)
        val id = if (idMatch != null) idMatch.groupValues[1].toLowerCase() else ""

        val idLikeMatch = idLikeRegex.find(input)
        val idLike = if (idLikeMatch != null) idLikeMatch.groupValues[1].toLowerCase() else ""

        if (id == "raspbian") {
            return "arm"
        }

        if (
            idLike.contains("centos") ||
            idLike.contains("fedora") ||
            idLike.contains("rhel") ||
            id == "fedora"
        ) {
            return "rhel"
        }

        if (
            idLike.contains("debian") ||
            idLike.contains("ubuntu") ||
            id == "debian"
        ) {
            return "debian"
        }

        return null
    }

    fun getDistro(): String? {
        // https://github.com/retrohacker/getos/blob/master/os.json
        val osReleaseFile = File("/etc/os-release")
        val alpineReleaseFile = File("/etc/alpine-release")

        return when {
            alpineReleaseFile.exists() -> {
                "musl"
            }
            osReleaseFile.exists() -> {
                parseDistro(osReleaseFile.readText())
            }
            else -> {
                null
            }
        }
    }

    /**
     * Platform identifier for the current OS
     * @return String the Prisma-compatible platform identifier for the current system
     */
    val platform: String by lazy {
        val osInfo = getOs()

        if (osInfo.platform in arrayOf("darwin", "windows", "freebsd", "openbsd", "netbsd")) {
            return@lazy osInfo.platform
        }

        if (osInfo.platform == "linux" && osInfo.distro == "musl") {
            return@lazy "linux-musl"
        }

        // when the platform is linux
        if (osInfo.platform == "linux" && osInfo.distro != null && osInfo.libssl != null) {
            return@lazy "${osInfo.distro}-openssl-${osInfo.libssl}"
        }

        // if just OpenSSL is known, fallback to debian with a specific libssl version
        if (osInfo.libssl != null) {
            return@lazy "debian-openssl-${osInfo.libssl}"
        }

        // if just the distro is known, fallback to latest OpenSSL 1.1
        if (osInfo.distro != null) {
            return@lazy "${osInfo.distro}-openssl-1.1.x"
        }

        // use the debian build with OpenSSL 1.1 as a last resort
        "debian-openssl-1.1.x"
    }
}