package io.techtrails.intellij.prisma.psi

import com.intellij.psi.tree.IElementType
import io.techtrails.intellij.prisma.PrismaLanguage

open class PrismaTokenType(debugName: String) : IElementType(debugName, PrismaLanguage) {
    override fun toString(): String {
        return "PrismaTokenType." + super.toString()
    }
}
