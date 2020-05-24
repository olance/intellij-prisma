package io.techtrails.intellij.prisma

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import io.techtrails.intellij.prisma.psi.*
import io.techtrails.intellij.prisma.PrismaSyntaxHighlighter.Companion as Highlight

class PrismaAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when(element) {
            is PrismaBlockName          -> holder.annotateSyntax(element, Highlight.BLOCK_NAME)
            is PrismaTypeName           -> holder.annotateSyntax(element, Highlight.TYPE_NAME)
            is PrismaFieldName          -> holder.annotateSyntax(element, Highlight.FIELD_NAME)
            is PrismaTypeModifier       -> holder.annotateSyntax(element, Highlight.TYPE_MODIFIER)
            is PrismaAttributeArgName   -> holder.annotateSyntax(element, Highlight.ATTRIBUTE_ARG_NAME)
            is PrismaEnumConstant       -> holder.annotateSyntax(element, Highlight.ENUM_CONSTANT)
        }
    }

    private fun AnnotationHolder.annotateSyntax(element: PsiElement, attr: TextAttributesKey) {
        val annotation = createInfoAnnotation(element, null)
        annotation.textAttributes = attr
    }
}
