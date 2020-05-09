package io.techtrails.intellij.prisma

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.*
import com.intellij.openapi.editor.colors.*
import com.intellij.openapi.editor.colors.TextAttributesKey.*
import com.intellij.openapi.fileTypes.*
import com.intellij.psi.*
import com.intellij.psi.tree.*

import io.techtrails.intellij.prisma.psi.*

class PrismaSyntaxHighlighter : SyntaxHighlighterBase() {
    companion object {
        private val DOUBLE_COMMENT = createTextAttributesKey(
                "PRISMA_DOUBLE_COMMENT",
                DefaultLanguageHighlighterColors.LINE_COMMENT
        )
        private val TRIPLE_COMMENT = createTextAttributesKey(
                "PRISMA_TRIPLE_COMMENT",
                DefaultLanguageHighlighterColors.BLOCK_COMMENT
        )

        private val STRING = createTextAttributesKey(
                "PRISMA_STRING",
                DefaultLanguageHighlighterColors.STRING
        )
        private val KEYWORD = createTextAttributesKey(
                "PRISMA_KEYWORD",
                DefaultLanguageHighlighterColors.KEYWORD
        )
        private val NUMBER = createTextAttributesKey(
                "PRISMA_NUMBER",
                DefaultLanguageHighlighterColors.NUMBER
        )

        private val BLOCK_NAME = createTextAttributesKey(
                "PRISMA_BLOCK_NAME",
                DefaultLanguageHighlighterColors.CLASS_NAME
        )
        private val ENTITY_NAME = createTextAttributesKey(
                "PRISMA_ENTITY_NAME",
                DefaultLanguageHighlighterColors.IDENTIFIER
        )
        private val FUNCTION_CALL = createTextAttributesKey(
                "PRISMA_FUNCTION_CALL",
                DefaultLanguageHighlighterColors.FUNCTION_CALL
        )

        private val BRACES = createTextAttributesKey(
                "PRISMA_BRACES",
                DefaultLanguageHighlighterColors.BRACES
        )
        private val BRACKETS = createTextAttributesKey(
                "PRISMA_BRACKETS",
                DefaultLanguageHighlighterColors.BRACKETS
        )
        private val PARENS = createTextAttributesKey(
                "PRISMA_PARENS",
                DefaultLanguageHighlighterColors.PARENTHESES
        )
        private val COMMA = createTextAttributesKey(
                "PRISMA_COMMA",
                DefaultLanguageHighlighterColors.COMMA
        )

        private val DOUBLE_COMMENT_KEYS = arrayOf(DOUBLE_COMMENT)
        private val TRIPLE_COMMENT_KEYS = arrayOf(TRIPLE_COMMENT)

        private val KEYWORD_KEYS = arrayOf(KEYWORD)
        private val STRING_KEYS = arrayOf(STRING)
        private val NUMBER_KEYS = arrayOf(NUMBER)

        private val BLOCK_NAME_KEYS = arrayOf(BLOCK_NAME)
        private val ENTITY_NAME_KEYS = arrayOf(ENTITY_NAME)
        private val FUNCTION_CALL_KEYS = arrayOf(FUNCTION_CALL)

        private val BRACES_KEYS = arrayOf(BRACES)
        private val BRACKETS_KEYS = arrayOf(BRACKETS)
        private val PARENS_KEYS = arrayOf(PARENS)
        private val COMMA_KEYS = arrayOf(COMMA)

        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    }

    override fun getTokenHighlights(tokenType: IElementType) = when (tokenType) {
        PrismaTypes.DOUBLE_COMMENT -> DOUBLE_COMMENT_KEYS
        PrismaTypes.TRIPLE_COMMENT -> TRIPLE_COMMENT_KEYS

        PrismaTypes.KEYWORD_DATASOURCE, PrismaTypes.KEYWORD_GENERATOR, PrismaTypes.KEYWORD_MODEL,
        PrismaTypes.KEYWORD_ENUM, PrismaTypes.BOOLEAN, PrismaTypes.FIELD_PROVIDER, PrismaTypes.FIELD_OUTPUT,
        PrismaTypes.FIELD_URL -> KEYWORD_KEYS
        PrismaTypes.STRING -> STRING_KEYS
        PrismaTypes.NUMBER -> NUMBER_KEYS

        PrismaTypes.BLOCK_NAME -> BLOCK_NAME_KEYS
        PrismaTypes.ENTITY_NAME -> ENTITY_NAME_KEYS
        PrismaTypes.FUNCTION_CALL -> FUNCTION_CALL_KEYS

        PrismaTypes.L_CURLY, PrismaTypes.R_CURLY -> BRACES_KEYS
        PrismaTypes.L_BRACKET, PrismaTypes.R_BRACKET -> BRACKETS_KEYS
        PrismaTypes.L_PAREN, PrismaTypes.R_PAREN -> PARENS_KEYS
        PrismaTypes.COMMA -> COMMA_KEYS

        else -> EMPTY_KEYS
    }

    override fun getHighlightingLexer() = PrismaLexerAdapter()
}