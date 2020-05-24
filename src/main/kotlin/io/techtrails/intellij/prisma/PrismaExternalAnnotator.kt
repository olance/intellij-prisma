package io.techtrails.intellij.prisma

import com.intellij.lang.annotation.ExternalAnnotator
import com.intellij.psi.PsiFile
import java.lang.RuntimeException

class PrismaExternalAnnotator : ExternalAnnotator<PsiFile, String>() {
    override fun collectInformation(file: PsiFile) = file

    override fun doAnnotate(collectedInfo: PsiFile): String? {
        // Check whether we have a prisma-fmt binary available
        var prismaFmtPath = PrismaRuntime.getPrismaFmtBinPath(collectedInfo.project)
        if (prismaFmtPath == null) {
            // Not available? Download it.
            try {
                // TODO: https://intellij-support.jetbrains.com/hc/en-us/community/posts/206791945-IDE-Notifications ?
                prismaFmtPath = PrismaRuntime.downloadPrismaFmt(collectedInfo.project)
            } catch (e: RuntimeException) {
                return null
            }
        }

    }
}