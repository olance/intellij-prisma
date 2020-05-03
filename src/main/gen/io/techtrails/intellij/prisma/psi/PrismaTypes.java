// This is a generated file. Not intended for manual editing.
package io.techtrails.intellij.prisma.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.techtrails.intellij.prisma.psi.impl.*;

public interface PrismaTypes {

  IElementType BLOCK = new PrismaElementType("BLOCK");
  IElementType BLOCK_NAME = new PrismaElementType("BLOCK_NAME");
  IElementType DATASOURCE_BLOCK = new PrismaElementType("DATASOURCE_BLOCK");
  IElementType DATASOURCE_BLOCK_STATEMENT = new PrismaElementType("DATASOURCE_BLOCK_STATEMENT");
  IElementType ENUM_BLOCK = new PrismaElementType("ENUM_BLOCK");
  IElementType ENUM_BLOCK_STATEMENT = new PrismaElementType("ENUM_BLOCK_STATEMENT");
  IElementType GENERATOR_BLOCK = new PrismaElementType("GENERATOR_BLOCK");
  IElementType GENERATOR_BLOCK_STATEMENT = new PrismaElementType("GENERATOR_BLOCK_STATEMENT");
  IElementType MODEL_ATTRIBUTE_PARAM_NAME = new PrismaElementType("MODEL_ATTRIBUTE_PARAM_NAME");
  IElementType MODEL_ATTRIBUTE_PARAM_VALUE = new PrismaElementType("MODEL_ATTRIBUTE_PARAM_VALUE");
  IElementType MODEL_BLOCK = new PrismaElementType("MODEL_BLOCK");
  IElementType MODEL_BLOCK_ATTRIBUTE = new PrismaElementType("MODEL_BLOCK_ATTRIBUTE");
  IElementType MODEL_BLOCK_STATEMENT = new PrismaElementType("MODEL_BLOCK_STATEMENT");
  IElementType MODEL_FIELD_ATTRIBUTE = new PrismaElementType("MODEL_FIELD_ATTRIBUTE");
  IElementType MODEL_FIELD_TYPE = new PrismaElementType("MODEL_FIELD_TYPE");
  IElementType MODEL_TYPE_MODIFIER = new PrismaElementType("MODEL_TYPE_MODIFIER");

  IElementType BOOLEAN = new PrismaTokenType("BOOLEAN");
  IElementType BRACKET_PAIR = new PrismaTokenType("[]");
  IElementType COLON = new PrismaTokenType(":");
  IElementType COMMA = new PrismaTokenType(",");
  IElementType DOUBLE_COMMENT = new PrismaTokenType("DOUBLE_COMMENT");
  IElementType ENTITY_NAME = new PrismaTokenType("ENTITY_NAME");
  IElementType EQ = new PrismaTokenType("=");
  IElementType FIELD_OUTPUT = new PrismaTokenType("output");
  IElementType FIELD_PROVIDER = new PrismaTokenType("provider");
  IElementType FIELD_URL = new PrismaTokenType("url");
  IElementType FUNCTION_CALL = new PrismaTokenType("FUNCTION_CALL");
  IElementType KEYWORD_DATASOURCE = new PrismaTokenType("datasource");
  IElementType KEYWORD_ENUM = new PrismaTokenType("enum");
  IElementType KEYWORD_GENERATOR = new PrismaTokenType("generator");
  IElementType KEYWORD_MODEL = new PrismaTokenType("model");
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
      if (type == BLOCK_NAME) {
        return new PrismaBlockNameImpl(node);
      }
      else if (type == DATASOURCE_BLOCK) {
        return new PrismaDatasourceBlockImpl(node);
      }
      else if (type == DATASOURCE_BLOCK_STATEMENT) {
        return new PrismaDatasourceBlockStatementImpl(node);
      }
      else if (type == ENUM_BLOCK) {
        return new PrismaEnumBlockImpl(node);
      }
      else if (type == ENUM_BLOCK_STATEMENT) {
        return new PrismaEnumBlockStatementImpl(node);
      }
      else if (type == GENERATOR_BLOCK) {
        return new PrismaGeneratorBlockImpl(node);
      }
      else if (type == GENERATOR_BLOCK_STATEMENT) {
        return new PrismaGeneratorBlockStatementImpl(node);
      }
      else if (type == MODEL_ATTRIBUTE_PARAM_NAME) {
        return new PrismaModelAttributeParamNameImpl(node);
      }
      else if (type == MODEL_ATTRIBUTE_PARAM_VALUE) {
        return new PrismaModelAttributeParamValueImpl(node);
      }
      else if (type == MODEL_BLOCK) {
        return new PrismaModelBlockImpl(node);
      }
      else if (type == MODEL_BLOCK_ATTRIBUTE) {
        return new PrismaModelBlockAttributeImpl(node);
      }
      else if (type == MODEL_BLOCK_STATEMENT) {
        return new PrismaModelBlockStatementImpl(node);
      }
      else if (type == MODEL_FIELD_ATTRIBUTE) {
        return new PrismaModelFieldAttributeImpl(node);
      }
      else if (type == MODEL_FIELD_TYPE) {
        return new PrismaModelFieldTypeImpl(node);
      }
      else if (type == MODEL_TYPE_MODIFIER) {
        return new PrismaModelTypeModifierImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
