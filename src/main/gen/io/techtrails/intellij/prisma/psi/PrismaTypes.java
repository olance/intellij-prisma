// This is a generated file. Not intended for manual editing.
package io.techtrails.intellij.prisma.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.techtrails.intellij.prisma.psi.impl.*;

public interface PrismaTypes {

  IElementType ATTRIBUTE_ARG_NAME = new PrismaElementType("ATTRIBUTE_ARG_NAME");
  IElementType ATTRIBUTE_ARG_VALUE = new PrismaElementType("ATTRIBUTE_ARG_VALUE");
  IElementType BLOCK = new PrismaElementType("BLOCK");
  IElementType BLOCK_NAME = new PrismaElementType("BLOCK_NAME");
  IElementType CONFIG_BLOCK = new PrismaElementType("CONFIG_BLOCK");
  IElementType CONFIG_BLOCK_STATEMENT = new PrismaElementType("CONFIG_BLOCK_STATEMENT");
  IElementType ENUM_BLOCK = new PrismaElementType("ENUM_BLOCK");
  IElementType ENUM_BLOCK_STATEMENT = new PrismaElementType("ENUM_BLOCK_STATEMENT");
  IElementType ENUM_CONSTANT = new PrismaElementType("ENUM_CONSTANT");
  IElementType FIELD_NAME = new PrismaElementType("FIELD_NAME");
  IElementType FIELD_TYPE = new PrismaElementType("FIELD_TYPE");
  IElementType FIELD_VALUE = new PrismaElementType("FIELD_VALUE");
  IElementType IDENTIFIER = new PrismaElementType("IDENTIFIER");
  IElementType MODEL_BLOCK = new PrismaElementType("MODEL_BLOCK");
  IElementType MODEL_BLOCK_STATEMENT = new PrismaElementType("MODEL_BLOCK_STATEMENT");
  IElementType TYPE_ALIAS = new PrismaElementType("TYPE_ALIAS");
  IElementType TYPE_MODIFIER = new PrismaElementType("TYPE_MODIFIER");
  IElementType TYPE_NAME = new PrismaElementType("TYPE_NAME");

  IElementType BOOLEAN = new PrismaTokenType("BOOLEAN");
  IElementType COLON = new PrismaTokenType(":");
  IElementType COMMA = new PrismaTokenType(",");
  IElementType DOUBLE_COMMENT = new PrismaTokenType("DOUBLE_COMMENT");
  IElementType ENTITY_NAME = new PrismaTokenType("ENTITY_NAME");
  IElementType EOL = new PrismaTokenType("EOL");
  IElementType EQ = new PrismaTokenType("=");
  IElementType FUNCTION_NAME = new PrismaTokenType("FUNCTION_NAME");
  IElementType KEYWORD_DATASOURCE = new PrismaTokenType("datasource");
  IElementType KEYWORD_ENUM = new PrismaTokenType("enum");
  IElementType KEYWORD_GENERATOR = new PrismaTokenType("generator");
  IElementType KEYWORD_MODEL = new PrismaTokenType("model");
  IElementType KEYWORD_TYPE = new PrismaTokenType("type");
  IElementType L_BRACKET = new PrismaTokenType("[");
  IElementType L_CURLY = new PrismaTokenType("{");
  IElementType L_PAREN = new PrismaTokenType("(");
  IElementType MODEL_BLOCK_ATTRIBUTE_NAME = new PrismaTokenType("MODEL_BLOCK_ATTRIBUTE_NAME");
  IElementType MODEL_FIELD_ATTRIBUTE_NAME = new PrismaTokenType("MODEL_FIELD_ATTRIBUTE_NAME");
  IElementType NUMBER = new PrismaTokenType("NUMBER");
  IElementType QUESTION_MARK = new PrismaTokenType("?");
  IElementType R_BRACKET = new PrismaTokenType("]");
  IElementType R_CURLY = new PrismaTokenType("}");
  IElementType R_PAREN = new PrismaTokenType(")");
  IElementType STRING = new PrismaTokenType("STRING");
  IElementType TRIPLE_COMMENT = new PrismaTokenType("TRIPLE_COMMENT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ATTRIBUTE_ARG_NAME) {
        return new PrismaAttributeArgNameImpl(node);
      }
      else if (type == ATTRIBUTE_ARG_VALUE) {
        return new PrismaAttributeArgValueImpl(node);
      }
      else if (type == BLOCK_NAME) {
        return new PrismaBlockNameImpl(node);
      }
      else if (type == CONFIG_BLOCK) {
        return new PrismaConfigBlockImpl(node);
      }
      else if (type == CONFIG_BLOCK_STATEMENT) {
        return new PrismaConfigBlockStatementImpl(node);
      }
      else if (type == ENUM_BLOCK) {
        return new PrismaEnumBlockImpl(node);
      }
      else if (type == ENUM_BLOCK_STATEMENT) {
        return new PrismaEnumBlockStatementImpl(node);
      }
      else if (type == ENUM_CONSTANT) {
        return new PrismaEnumConstantImpl(node);
      }
      else if (type == FIELD_NAME) {
        return new PrismaFieldNameImpl(node);
      }
      else if (type == FIELD_TYPE) {
        return new PrismaFieldTypeImpl(node);
      }
      else if (type == FIELD_VALUE) {
        return new PrismaFieldValueImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new PrismaIdentifierImpl(node);
      }
      else if (type == MODEL_BLOCK) {
        return new PrismaModelBlockImpl(node);
      }
      else if (type == MODEL_BLOCK_STATEMENT) {
        return new PrismaModelBlockStatementImpl(node);
      }
      else if (type == TYPE_ALIAS) {
        return new PrismaTypeAliasImpl(node);
      }
      else if (type == TYPE_MODIFIER) {
        return new PrismaTypeModifierImpl(node);
      }
      else if (type == TYPE_NAME) {
        return new PrismaTypeNameImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
