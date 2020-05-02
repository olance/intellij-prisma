package io.techtrails.intellij.prisma

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader

val PrismaIcon = IconLoader.getIcon("/io/techtrails/intellij/prisma/prisma.png")

object PrismaFileType : LanguageFileType(PrismaLanguage) {
    override fun getIcon() = PrismaIcon
    override fun getName() = "Prisma"
    override fun getDescription() = "Prisma schema file"
    override fun getDefaultExtension() = "prisma"
}
