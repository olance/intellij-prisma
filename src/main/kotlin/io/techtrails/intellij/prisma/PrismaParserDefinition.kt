package io.techtrails.intellij.prisma

import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import io.techtrails.intellij.prisma.psi.PrismaFile
import io.techtrails.intellij.prisma.psi.PrismaTypes.*

class PrismaParserDefinition : ParserDefinition {
    companion object {
        val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
        val COMMENTS = TokenSet.create(DOUBLE_COMMENT, TRIPLE_COMMENT)
        val STRINGS = TokenSet.create(STRING)
        val FILE = IFileElementType(Language.findInstance(PrismaLanguage::class.java))
    }

    override fun getFileNodeType() = FILE
    override fun getWhitespaceTokens() = WHITE_SPACES
    override fun getCommentTokens() = COMMENTS
    override fun getStringLiteralElements() = STRINGS

    override fun createFile(viewProvider: FileViewProvider) = PrismaFile(viewProvider)

    override fun createLexer(project: Project?) = PrismaLexerAdapter()
    override fun createParser(project: Project?) = PrismaParser()

    override fun createElement(node: ASTNode?): PsiElement = Factory.createElement(node)
}