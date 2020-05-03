package io.techtrails.intellij.prisma.psi

import com.intellij.psi.tree.IElementType
import io.techtrails.intellij.prisma.PrismaLanguage

open class PrismaElementType(debugName: String) : IElementType(debugName, PrismaLanguage) {
}