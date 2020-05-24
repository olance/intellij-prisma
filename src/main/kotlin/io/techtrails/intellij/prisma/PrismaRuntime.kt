package io.techtrails.intellij.prisma

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.project.Project
import java.io.File
import java.io.IOException
import java.lang.RuntimeException


object PrismaRuntime {
    const val DL_PRISMA_FMT_BIN_PATH_KEY = "io.techtrails.intellij.prisma.fmtBinPath"

    /**
     * Find the path for prisma-fmt using the following list of precedence:
     * 1. Has a path been provided via the PRISMA_FMT_BINARY env variable?
     * 2. Is there a <project-path>/node_modules/@prisma/sdk/prisma-fmt-<platform> binary?
     * 3. Do we have a downloaded version available?
     *
     * TODO: allow user to provide path in plugin settings
     *
     * @return String? Path to the prisma-fmt binary, or null if nothing could be found
     */
    fun getPrismaFmtBinPath(project: Project): String? {
        // 1. Has a path been provided via the PRISMA_FMT_BINARY env variable?
        val pathFromEnv = getPrismaFmtBinPathFromEnv()
        pathFromEnv?.let { return it }

        // 2. Is there a <project-path>/node_modules/@prisma/sdk/prisma-fmt-<platform> binary?
        val pathFromSdk = getPrismaFmtBinPathFromSdk(project)
        pathFromSdk?.let { return it }

        // 3. Do we have a downloaded version available?
        val pathFromDownloadedBin = getDownloadedPrismaFmtBinPath(project)
        pathFromDownloadedBin?.let { return it }

        return null
    }

    private fun getPrismaFmtBinPathFromEnv(): String? {
        var pathFromEnv: String? = null
        try {
            pathFromEnv = System.getenv("PRISMA_FMT_BINARY")
        } catch (e: SecurityException) {
            return null
        }

        if (pathFromEnv != null && File(pathFromEnv).exists()) {
            return pathFromEnv
        }

        return null
    }

    private fun getPrismaFmtBinPathFromSdk(project: Project): String? {
        val platform = PrismaPlatform.platform

        val sdkBinFile = File(project.basePath, "node_modules/@prisma/sdk/prisma-fmt-${platform}")
        if (sdkBinFile.exists()) {
            return sdkBinFile.toString()
        }

        return null
    }

    private fun getDownloadedPrismaFmtBinPath(project: Project): String? {
        val path = PropertiesComponent.getInstance(project).getValue(DL_PRISMA_FMT_BIN_PATH_KEY)
        if (path != null && File(path).exists()) {
            return path
        }

        return null
    }

    fun getDownloadUrl(project: Project): String {
        val platform = PrismaPlatform.platform
        val version = getVersion(project)
        val extension = if (platform == "windows") ".exe.gz" else ".gz"

        return "https://binaries.prisma.sh/master/${version}/${platform}/prisma-fmt${extension}"
    }

    private fun getVersion(project: Project): String {
        val basePath = project.basePath ?: return "latest"

        val packageFile = File(basePath, "node_modules/@prisma/sdk/package.json")
        var jsonText: String? = null
        try {
            jsonText = packageFile.readText()
        } catch (e: IOException) {
            return "latest"
        }

        val pkg = Gson().fromJson(jsonText, JsonObject::class.java)
        try {
            return pkg.getAsJsonObject("prisma").getAsJsonPrimitive("version").asString
        } catch (e: RuntimeException) {
            return "latest"
        }
    }

    fun downloadPrismaFmt(project: Project): String {

    }
}
