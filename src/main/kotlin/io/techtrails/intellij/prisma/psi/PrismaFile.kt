package io.techtrails.intellij.prisma.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import io.techtrails.intellij.prisma.PrismaFileType
import io.techtrails.intellij.prisma.PrismaLanguage

class PrismaFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, PrismaLanguage) {
    override fun getFileType() = PrismaFileType
    override fun toString() = "Prisma schema"
}