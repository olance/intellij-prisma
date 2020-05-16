package io.techtrails.intellij.prisma

import com.intellij.openapi.editor.*
import com.intellij.openapi.editor.colors.*
import com.intellij.openapi.editor.colors.TextAttributesKey.*
import com.intellij.openapi.fileTypes.*
import com.intellij.psi.tree.*

import io.techtrails.intellij.prisma.psi.*

class PrismaSyntaxHighlighter : SyntaxHighlighterBase() {
    companion object {
        val DOUBLE_COMMENT = createTextAttributesKey("PRISMA_DOUBLE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val TRIPLE_COMMENT = createTextAttributesKey("PRISMA_TRIPLE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)

        val STRING = createTextAttributesKey("PRISMA_STRING", DefaultLanguageHighlighterColors.STRING)
        val KEYWORD = createTextAttributesKey("PRISMA_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        val NUMBER = createTextAttributesKey("PRISMA_NUMBER", DefaultLanguageHighlighterColors.NUMBER)

        val BLOCK_NAME = createTextAttributesKey("PRISMA_BLOCK_NAME", DefaultLanguageHighlighterColors.CLASS_NAME)
        val TYPE_NAME = createTextAttributesKey("PRISMA_TYPE_NAME", DefaultLanguageHighlighterColors.CLASS_NAME)
        val FUNCTION_NAME = createTextAttributesKey("PRISMA_FUNCTION_NAME", DefaultLanguageHighlighterColors.FUNCTION_CALL)
        val FIELD_NAME = createTextAttributesKey("PRISMA_FIELD_NAME", DefaultLanguageHighlighterColors.IDENTIFIER)

        val TYPE_MODIFIER = createTextAttributesKey("PRISMA_TYPE_MODIFIER", DefaultLanguageHighlighterColors.OPERATION_SIGN)

        val FIELD_ATTRIBUTE = createTextAttributesKey("PRISMA_TYPE_ATTRIBUTE", DefaultLanguageHighlighterColors.FUNCTION_CALL)
        val MODEL_ATTRIBUTE = createTextAttributesKey("PRISMA_MODEL_ATTRIBUTE", DefaultLanguageHighlighterColors.FUNCTION_CALL)

        val ATTRIBUTE_ARG_NAME = createTextAttributesKey("PRISMA_ATTRIBUTE_PARAM_NAME", DefaultLanguageHighlighterColors.INSTANCE_FIELD)

        val ENUM_CONSTANT = createTextAttributesKey("PRISMA_ENUM_CONSTANT", DefaultLanguageHighlighterColors.CONSTANT)

        val BRACES = createTextAttributesKey("PRISMA_BRACES", DefaultLanguageHighlighterColors.BRACES)
        val BRACKETS = createTextAttributesKey("PRISMA_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)
        val PARENS = createTextAttributesKey("PRISMA_PARENS", DefaultLanguageHighlighterColors.PARENTHESES)
        val COMMA = createTextAttributesKey("PRISMA_COMMA", DefaultLanguageHighlighterColors.COMMA)

        private val DOUBLE_COMMENT_KEYS = arrayOf(DOUBLE_COMMENT)
        private val TRIPLE_COMMENT_KEYS = arrayOf(TRIPLE_COMMENT)

        private val KEYWORD_KEYS = arrayOf(KEYWORD)
        private val STRING_KEYS = arrayOf(STRING)
        private val NUMBER_KEYS = arrayOf(NUMBER)

        private val FUNCTION_NAME_KEYS = arrayOf(FUNCTION_NAME)

        private val FIELD_ATTRIBUTE_KEYS = arrayOf(FIELD_ATTRIBUTE)
        private val MODEL_ATTRIBUTE_KEYS = arrayOf(MODEL_ATTRIBUTE)

        private val BRACES_KEYS = arrayOf(BRACES)
        private val BRACKETS_KEYS = arrayOf(BRACKETS)
        private val PARENS_KEYS = arrayOf(PARENS)
        private val COMMA_KEYS = arrayOf(COMMA)

        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    }

    override fun getTokenHighlights(tokenType: IElementType) = when (tokenType) {
        PrismaTypes.KEYWORD_DATASOURCE, PrismaTypes.KEYWORD_GENERATOR, PrismaTypes.KEYWORD_MODEL,
        PrismaTypes.KEYWORD_TYPE, PrismaTypes.KEYWORD_ENUM, PrismaTypes.BOOLEAN -> KEYWORD_KEYS

        PrismaTypes.DOUBLE_COMMENT -> DOUBLE_COMMENT_KEYS
        PrismaTypes.TRIPLE_COMMENT -> TRIPLE_COMMENT_KEYS
        PrismaTypes.STRING -> STRING_KEYS
        PrismaTypes.NUMBER -> NUMBER_KEYS

        PrismaTypes.FUNCTION_NAME -> FUNCTION_NAME_KEYS
        PrismaTypes.MODEL_FIELD_ATTRIBUTE_NAME -> FIELD_ATTRIBUTE_KEYS
        PrismaTypes.MODEL_BLOCK_ATTRIBUTE_NAME -> MODEL_ATTRIBUTE_KEYS

        PrismaTypes.L_CURLY, PrismaTypes.R_CURLY -> BRACES_KEYS
        PrismaTypes.L_BRACKET, PrismaTypes.R_BRACKET -> BRACKETS_KEYS
        PrismaTypes.L_PAREN, PrismaTypes.R_PAREN -> PARENS_KEYS
        PrismaTypes.COMMA -> COMMA_KEYS

        else -> EMPTY_KEYS
    }

    override fun getHighlightingLexer() = PrismaLexerAdapter()
}