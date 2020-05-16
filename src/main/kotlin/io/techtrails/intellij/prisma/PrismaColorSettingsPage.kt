package io.techtrails.intellij.prisma

import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage

class PrismaColorSettingsPage : ColorSettingsPage {
    private val tags = mapOf(
        "keyword" to PrismaSyntaxHighlighter.KEYWORD,
        "block_name" to PrismaSyntaxHighlighter.BLOCK_NAME,
        "function" to PrismaSyntaxHighlighter.FUNCTION_NAME,
        "field_name" to PrismaSyntaxHighlighter.FIELD_NAME,
        "type" to PrismaSyntaxHighlighter.TYPE_NAME,
        "modifier" to PrismaSyntaxHighlighter.TYPE_MODIFIER,
        "field_attr" to PrismaSyntaxHighlighter.FIELD_ATTRIBUTE,
        "model_attr" to PrismaSyntaxHighlighter.MODEL_ATTRIBUTE,
        "named_arg" to PrismaSyntaxHighlighter.ATTRIBUTE_ARG_NAME,
        "enum_const" to PrismaSyntaxHighlighter.ENUM_CONSTANT
    )

    private val descriptors = arrayOf(
        AttributesDescriptor("Braces", PrismaSyntaxHighlighter.BRACES),
        AttributesDescriptor("Brackets", PrismaSyntaxHighlighter.BRACKETS),
        AttributesDescriptor("Parentheses", PrismaSyntaxHighlighter.PARENS),
        AttributesDescriptor("Commas", PrismaSyntaxHighlighter.COMMA),
        AttributesDescriptor("Strings", PrismaSyntaxHighlighter.STRING),
        AttributesDescriptor("Numbers", PrismaSyntaxHighlighter.NUMBER),
        AttributesDescriptor("Keywords", PrismaSyntaxHighlighter.KEYWORD),
        AttributesDescriptor("Double comments", PrismaSyntaxHighlighter.DOUBLE_COMMENT),
        AttributesDescriptor("Triple comments", PrismaSyntaxHighlighter.TRIPLE_COMMENT),
        AttributesDescriptor("Configuration block names", PrismaSyntaxHighlighter.BLOCK_NAME),
        AttributesDescriptor("Type names", PrismaSyntaxHighlighter.TYPE_NAME),
        AttributesDescriptor("Type modifiers", PrismaSyntaxHighlighter.TYPE_MODIFIER),
        AttributesDescriptor("Function calls", PrismaSyntaxHighlighter.FUNCTION_NAME),
        AttributesDescriptor("Field names", PrismaSyntaxHighlighter.FIELD_NAME),
        AttributesDescriptor("Field attributes", PrismaSyntaxHighlighter.FIELD_ATTRIBUTE),
        AttributesDescriptor("Model (block) attributes", PrismaSyntaxHighlighter.MODEL_ATTRIBUTE),
        AttributesDescriptor("Named arguments", PrismaSyntaxHighlighter.ATTRIBUTE_ARG_NAME),
        AttributesDescriptor("Enum constants", PrismaSyntaxHighlighter.ENUM_CONSTANT)
    )

    override fun getIcon() = PrismaIcon
    override fun getDisplayName() = PrismaLanguage.displayName
    override fun getHighlighter() = PrismaSyntaxHighlighter()
    override fun getAttributeDescriptors() = descriptors
    override fun getAdditionalHighlightingTagToDescriptorMap() = tags
    override fun getColorDescriptors() = ColorDescriptor.EMPTY_ARRAY

    override fun getDemoText() = """
        // Configure connection to postgres
        <keyword>datasource</keyword> <block_name>postgresql</block_name> {
            <field_name>provider</field_name> = "postgresql"
            <field_name>url</field_name>      = <function>env</function>("DATABASE_URL")
        }

        <keyword>generator</keyword> <block_name>client</block_name> {
          <field_name>provider</field_name> = "prisma-client-js"
          <field_name>output</field_name>   = "/some/output/path/"

          <field_name>binaryTargets</field_name> = ["native"]
        }

        /// This is the User model
        <keyword>model</keyword> <type>User</type> {
          <field_name>id</field_name>      <type>Int</type>      <field_attr>@id</field_attr> <field_attr>@default</field_attr>(<function>autoincrement</function>())
          <field_name>email</field_name>   <type>String</type>   <field_attr>@unique</field_attr>
          <field_name>name</field_name>    <type>String</type><modifier>?</modifier>
          <field_name>age</field_name>     <type>Int</type>      <field_attr>@default</field_attr>(42)
          <field_name>role</field_name>    <type>Role</type>     <field_attr>@default</field_attr>(<field_name>USER</field_name>)
          <field_name>posts</field_name>   <type>Post</type><modifier>[]</modifier>

          <model_attr>@@map</model_attr>(<named_arg>name:</named_arg> "users")
        }

        <keyword>enum</keyword> <type>Role</type> {
          <enum_const>USER</enum_const>
          <enum_const>ADMIN</enum_const>
        }
    """.trimIndent()

}