package io.techtrails.intellij.prisma

import com.intellij.psi.stubs.PsiFileStub
import com.intellij.psi.tree.IStubFileElementType
import io.techtrails.intellij.prisma.psi.PrismaFile

class PrismaStubFileElementType : IStubFileElementType<PsiFileStub<PrismaFile>>(PrismaLanguage) {
}