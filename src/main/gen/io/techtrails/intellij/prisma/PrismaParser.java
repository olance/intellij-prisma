// This is a generated file. Not intended for manual editing.
package io.techtrails.intellij.prisma;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static io.techtrails.intellij.prisma.psi.PrismaTypes.*;
import static io.techtrails.intellij.prisma.PrismaParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class PrismaParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return prisma_schema(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(BLOCK, CONFIG_BLOCK, ENUM_BLOCK, MODEL_BLOCK,
      TYPE_ALIAS),
  };

  /* ********************************************************** */
  // '[' (field-value (',' field-value)*)? ']'
  static boolean array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array")) return false;
    if (!nextTokenIs(b, L_BRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, L_BRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, array_1(b, l + 1));
    r = p && consumeToken(b, R_BRACKET) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (field-value (',' field-value)*)?
  private static boolean array_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1")) return false;
    array_1_0(b, l + 1);
    return true;
  }

  // field-value (',' field-value)*
  private static boolean array_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = field_value(b, l + 1);
    p = r; // pin = 1
    r = r && array_1_0_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (',' field-value)*
  private static boolean array_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!array_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_1_0_1", c)) break;
    }
    return true;
  }

  // ',' field-value
  private static boolean array_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && field_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ENTITY_NAME ':'
  public static boolean attribute_arg_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_arg_name")) return false;
    if (!nextTokenIs(b, ENTITY_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ENTITY_NAME, COLON);
    exit_section_(b, m, ATTRIBUTE_ARG_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // attribute-arg-value-scalar | attribute-arg-value-array | model-function
  static boolean attribute_arg_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_arg_value")) return false;
    boolean r;
    r = attribute_arg_value_scalar(b, l + 1);
    if (!r) r = attribute_arg_value_array(b, l + 1);
    if (!r) r = model_function(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // '[' (attribute-arg-value-scalar | attribute-arg-value-array (',' attribute-arg-value-scalar | attribute-arg-value-array)*)? ']'
  static boolean attribute_arg_value_array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_arg_value_array")) return false;
    if (!nextTokenIs(b, L_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_BRACKET);
    r = r && attribute_arg_value_array_1(b, l + 1);
    r = r && consumeToken(b, R_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // (attribute-arg-value-scalar | attribute-arg-value-array (',' attribute-arg-value-scalar | attribute-arg-value-array)*)?
  private static boolean attribute_arg_value_array_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_arg_value_array_1")) return false;
    attribute_arg_value_array_1_0(b, l + 1);
    return true;
  }

  // attribute-arg-value-scalar | attribute-arg-value-array (',' attribute-arg-value-scalar | attribute-arg-value-array)*
  private static boolean attribute_arg_value_array_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_arg_value_array_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = attribute_arg_value_scalar(b, l + 1);
    if (!r) r = attribute_arg_value_array_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // attribute-arg-value-array (',' attribute-arg-value-scalar | attribute-arg-value-array)*
  private static boolean attribute_arg_value_array_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_arg_value_array_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = attribute_arg_value_array(b, l + 1);
    r = r && attribute_arg_value_array_1_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' attribute-arg-value-scalar | attribute-arg-value-array)*
  private static boolean attribute_arg_value_array_1_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_arg_value_array_1_0_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute_arg_value_array_1_0_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "attribute_arg_value_array_1_0_1_1", c)) break;
    }
    return true;
  }

  // ',' attribute-arg-value-scalar | attribute-arg-value-array
  private static boolean attribute_arg_value_array_1_0_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_arg_value_array_1_0_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = attribute_arg_value_array_1_0_1_1_0_0(b, l + 1);
    if (!r) r = attribute_arg_value_array(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ',' attribute-arg-value-scalar
  private static boolean attribute_arg_value_array_1_0_1_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_arg_value_array_1_0_1_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && attribute_arg_value_scalar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STRING | NUMBER | BOOLEAN | identifier
  static boolean attribute_arg_value_scalar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_arg_value_scalar")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, BOOLEAN);
    if (!r) r = identifier(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // '(' attribute-arg-name? attribute-arg-value (',' attribute-arg-name attribute-arg-value)* ')'
  static boolean attribute_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_args")) return false;
    if (!nextTokenIs(b, L_PAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, L_PAREN);
    r = r && attribute_args_1(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, attribute_arg_value(b, l + 1));
    r = p && report_error_(b, attribute_args_3(b, l + 1)) && r;
    r = p && consumeToken(b, R_PAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // attribute-arg-name?
  private static boolean attribute_args_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_args_1")) return false;
    attribute_arg_name(b, l + 1);
    return true;
  }

  // (',' attribute-arg-name attribute-arg-value)*
  private static boolean attribute_args_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_args_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute_args_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "attribute_args_3", c)) break;
    }
    return true;
  }

  // ',' attribute-arg-name attribute-arg-value
  private static boolean attribute_args_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_args_3_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    r = r && attribute_arg_name(b, l + 1);
    p = r; // pin = 2
    r = r && attribute_arg_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // config-block | model-block | type-alias | enum-block
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, BLOCK, "<block>");
    r = config_block(b, l + 1);
    if (!r) r = model_block(b, l + 1);
    if (!r) r = type_alias(b, l + 1);
    if (!r) r = enum_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ENTITY_NAME
  public static boolean block_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_name")) return false;
    if (!nextTokenIs(b, ENTITY_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENTITY_NAME);
    exit_section_(b, m, BLOCK_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // TRIPLE_COMMENT | DOUBLE_COMMENT
  static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    if (!nextTokenIs(b, "", DOUBLE_COMMENT, TRIPLE_COMMENT)) return false;
    boolean r;
    r = consumeToken(b, TRIPLE_COMMENT);
    if (!r) r = consumeToken(b, DOUBLE_COMMENT);
    return r;
  }

  /* ********************************************************** */
  // ('datasource' | 'generator') block-name '{' EOL? ((config-block-statement comment? EOL)  | comment | EOL)* '}'
  public static boolean config_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block")) return false;
    if (!nextTokenIs(b, "<config block>", KEYWORD_DATASOURCE, KEYWORD_GENERATOR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_BLOCK, "<config block>");
    r = config_block_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, block_name(b, l + 1));
    r = p && report_error_(b, consumeToken(b, L_CURLY)) && r;
    r = p && report_error_(b, config_block_3(b, l + 1)) && r;
    r = p && report_error_(b, config_block_4(b, l + 1)) && r;
    r = p && consumeToken(b, R_CURLY) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // 'datasource' | 'generator'
  private static boolean config_block_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_0")) return false;
    boolean r;
    r = consumeToken(b, KEYWORD_DATASOURCE);
    if (!r) r = consumeToken(b, KEYWORD_GENERATOR);
    return r;
  }

  // EOL?
  private static boolean config_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_3")) return false;
    consumeToken(b, EOL);
    return true;
  }

  // ((config-block-statement comment? EOL)  | comment | EOL)*
  private static boolean config_block_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!config_block_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "config_block_4", c)) break;
    }
    return true;
  }

  // (config-block-statement comment? EOL)  | comment | EOL
  private static boolean config_block_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_block_4_0_0(b, l + 1);
    if (!r) r = comment(b, l + 1);
    if (!r) r = consumeToken(b, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  // config-block-statement comment? EOL
  private static boolean config_block_4_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_4_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_block_statement(b, l + 1);
    r = r && config_block_4_0_0_1(b, l + 1);
    r = r && consumeToken(b, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  // comment?
  private static boolean config_block_4_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_4_0_0_1")) return false;
    comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // field-name '=' field-value
  public static boolean config_block_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_block_statement")) return false;
    if (!nextTokenIs(b, ENTITY_NAME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONFIG_BLOCK_STATEMENT, null);
    r = field_name(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, EQ));
    r = p && field_value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'enum'  type-name '{' EOL? ((enum-block-statement comment? EOL)  | comment | EOL)* '}'
  public static boolean enum_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_block")) return false;
    if (!nextTokenIs(b, KEYWORD_ENUM)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENUM_BLOCK, null);
    r = consumeToken(b, KEYWORD_ENUM);
    p = r; // pin = 1
    r = r && report_error_(b, type_name(b, l + 1));
    r = p && report_error_(b, consumeToken(b, L_CURLY)) && r;
    r = p && report_error_(b, enum_block_3(b, l + 1)) && r;
    r = p && report_error_(b, enum_block_4(b, l + 1)) && r;
    r = p && consumeToken(b, R_CURLY) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // EOL?
  private static boolean enum_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_block_3")) return false;
    consumeToken(b, EOL);
    return true;
  }

  // ((enum-block-statement comment? EOL)  | comment | EOL)*
  private static boolean enum_block_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_block_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enum_block_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_block_4", c)) break;
    }
    return true;
  }

  // (enum-block-statement comment? EOL)  | comment | EOL
  private static boolean enum_block_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_block_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enum_block_4_0_0(b, l + 1);
    if (!r) r = comment(b, l + 1);
    if (!r) r = consumeToken(b, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  // enum-block-statement comment? EOL
  private static boolean enum_block_4_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_block_4_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enum_block_statement(b, l + 1);
    r = r && enum_block_4_0_0_1(b, l + 1);
    r = r && consumeToken(b, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  // comment?
  private static boolean enum_block_4_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_block_4_0_0_1")) return false;
    comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // enum-constant-definition | model-attribute
  public static boolean enum_block_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_block_statement")) return false;
    if (!nextTokenIs(b, "<enum block statement>", ENTITY_NAME, MODEL_BLOCK_ATTRIBUTE_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_BLOCK_STATEMENT, "<enum block statement>");
    r = enum_constant_definition(b, l + 1);
    if (!r) r = model_attribute(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ENTITY_NAME
  public static boolean enum_constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_constant")) return false;
    if (!nextTokenIs(b, ENTITY_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENTITY_NAME);
    exit_section_(b, m, ENUM_CONSTANT, r);
    return r;
  }

  /* ********************************************************** */
  // enum-constant ('=' enum-constant-value | field-attribute)?
  static boolean enum_constant_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_constant_definition")) return false;
    if (!nextTokenIs(b, ENTITY_NAME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = enum_constant(b, l + 1);
    p = r; // pin = 1
    r = r && enum_constant_definition_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('=' enum-constant-value | field-attribute)?
  private static boolean enum_constant_definition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_constant_definition_1")) return false;
    enum_constant_definition_1_0(b, l + 1);
    return true;
  }

  // '=' enum-constant-value | field-attribute
  private static boolean enum_constant_definition_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_constant_definition_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enum_constant_definition_1_0_0(b, l + 1);
    if (!r) r = field_attribute(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '=' enum-constant-value
  private static boolean enum_constant_definition_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_constant_definition_1_0_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, EQ);
    p = r; // pin = 1
    r = r && enum_constant_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // STRING
  public static boolean enum_constant_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_constant_value")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, ENUM_CONSTANT_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // 'env' '(' STRING ')'
  static boolean env_var_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "env_var_value")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "env");
    r = r && consumeTokens(b, 0, L_PAREN, STRING, R_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MODEL_FIELD_ATTRIBUTE_NAME attribute-args?
  static boolean field_attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_attribute")) return false;
    if (!nextTokenIs(b, MODEL_FIELD_ATTRIBUTE_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MODEL_FIELD_ATTRIBUTE_NAME);
    r = r && field_attribute_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // attribute-args?
  private static boolean field_attribute_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_attribute_1")) return false;
    attribute_args(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ENTITY_NAME
  public static boolean field_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_name")) return false;
    if (!nextTokenIs(b, ENTITY_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENTITY_NAME);
    exit_section_(b, m, FIELD_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // type-name type-modifier?
  public static boolean field_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_type")) return false;
    if (!nextTokenIs(b, ENTITY_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_name(b, l + 1);
    r = r && field_type_1(b, l + 1);
    exit_section_(b, m, FIELD_TYPE, r);
    return r;
  }

  // type-modifier?
  private static boolean field_type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_type_1")) return false;
    type_modifier(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // scalar-value | array | env-var-value
  public static boolean field_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_VALUE, "<field value>");
    r = scalar_value(b, l + 1);
    if (!r) r = array(b, l + 1);
    if (!r) r = env_var_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ENTITY_NAME
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    if (!nextTokenIs(b, ENTITY_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENTITY_NAME);
    exit_section_(b, m, IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // MODEL_BLOCK_ATTRIBUTE_NAME attribute-args?
  static boolean model_attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_attribute")) return false;
    if (!nextTokenIs(b, MODEL_BLOCK_ATTRIBUTE_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MODEL_BLOCK_ATTRIBUTE_NAME);
    r = r && model_attribute_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // attribute-args?
  private static boolean model_attribute_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_attribute_1")) return false;
    attribute_args(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'model' type-name '{' EOL? ((model-block-statement comment? EOL) | comment | EOL)* '}'
  public static boolean model_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_block")) return false;
    if (!nextTokenIs(b, KEYWORD_MODEL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MODEL_BLOCK, null);
    r = consumeToken(b, KEYWORD_MODEL);
    p = r; // pin = 1
    r = r && report_error_(b, type_name(b, l + 1));
    r = p && report_error_(b, consumeToken(b, L_CURLY)) && r;
    r = p && report_error_(b, model_block_3(b, l + 1)) && r;
    r = p && report_error_(b, model_block_4(b, l + 1)) && r;
    r = p && consumeToken(b, R_CURLY) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // EOL?
  private static boolean model_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_block_3")) return false;
    consumeToken(b, EOL);
    return true;
  }

  // ((model-block-statement comment? EOL) | comment | EOL)*
  private static boolean model_block_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_block_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!model_block_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "model_block_4", c)) break;
    }
    return true;
  }

  // (model-block-statement comment? EOL) | comment | EOL
  private static boolean model_block_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_block_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = model_block_4_0_0(b, l + 1);
    if (!r) r = comment(b, l + 1);
    if (!r) r = consumeToken(b, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  // model-block-statement comment? EOL
  private static boolean model_block_4_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_block_4_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = model_block_statement(b, l + 1);
    r = r && model_block_4_0_0_1(b, l + 1);
    r = r && consumeToken(b, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  // comment?
  private static boolean model_block_4_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_block_4_0_0_1")) return false;
    comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // model-field-definition | model-attribute
  public static boolean model_block_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_block_statement")) return false;
    if (!nextTokenIs(b, "<model block statement>", ENTITY_NAME, MODEL_BLOCK_ATTRIBUTE_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODEL_BLOCK_STATEMENT, "<model block statement>");
    r = model_field_definition(b, l + 1);
    if (!r) r = model_attribute(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // field-name model-field-type-and-attrs
  static boolean model_field_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_field_definition")) return false;
    if (!nextTokenIs(b, ENTITY_NAME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = field_name(b, l + 1);
    p = r; // pin = 1
    r = r && model_field_type_and_attrs(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // field-type (field-attribute (EOL? field-attribute)*)?
  static boolean model_field_type_and_attrs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_field_type_and_attrs")) return false;
    if (!nextTokenIs(b, ENTITY_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = field_type(b, l + 1);
    r = r && model_field_type_and_attrs_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (field-attribute (EOL? field-attribute)*)?
  private static boolean model_field_type_and_attrs_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_field_type_and_attrs_1")) return false;
    model_field_type_and_attrs_1_0(b, l + 1);
    return true;
  }

  // field-attribute (EOL? field-attribute)*
  private static boolean model_field_type_and_attrs_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_field_type_and_attrs_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = field_attribute(b, l + 1);
    r = r && model_field_type_and_attrs_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (EOL? field-attribute)*
  private static boolean model_field_type_and_attrs_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_field_type_and_attrs_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!model_field_type_and_attrs_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "model_field_type_and_attrs_1_0_1", c)) break;
    }
    return true;
  }

  // EOL? field-attribute
  private static boolean model_field_type_and_attrs_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_field_type_and_attrs_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = model_field_type_and_attrs_1_0_1_0_0(b, l + 1);
    r = r && field_attribute(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EOL?
  private static boolean model_field_type_and_attrs_1_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_field_type_and_attrs_1_0_1_0_0")) return false;
    consumeToken(b, EOL);
    return true;
  }

  /* ********************************************************** */
  // FUNCTION_NAME '(' ')'
  static boolean model_function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_function")) return false;
    if (!nextTokenIs(b, FUNCTION_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FUNCTION_NAME, L_PAREN, R_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // root-item *
  static boolean prisma_schema(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prisma_schema")) return false;
    while (true) {
      int c = current_position_(b);
      if (!root_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "prisma_schema", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // !<<eof>> block | comment | EOL
  static boolean root_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_item")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = root_item_0(b, l + 1);
    if (!r) r = comment(b, l + 1);
    if (!r) r = consumeToken(b, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  // !<<eof>> block
  private static boolean root_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_item_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = root_item_0_0(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !<<eof>>
  private static boolean root_item_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_item_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NUMBER | BOOLEAN | STRING
  static boolean scalar_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scalar_value")) return false;
    boolean r;
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, BOOLEAN);
    if (!r) r = consumeToken(b, STRING);
    return r;
  }

  /* ********************************************************** */
  // 'type'  type-name '=' model-field-type-and-attrs comment? EOL
  public static boolean type_alias(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_alias")) return false;
    if (!nextTokenIs(b, KEYWORD_TYPE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TYPE_ALIAS, null);
    r = consumeToken(b, KEYWORD_TYPE);
    p = r; // pin = 1
    r = r && report_error_(b, type_name(b, l + 1));
    r = p && report_error_(b, consumeToken(b, EQ)) && r;
    r = p && report_error_(b, model_field_type_and_attrs(b, l + 1)) && r;
    r = p && report_error_(b, type_alias_4(b, l + 1)) && r;
    r = p && consumeToken(b, EOL) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // comment?
  private static boolean type_alias_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_alias_4")) return false;
    comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '?' | '[' + ']'
  public static boolean type_modifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_modifier")) return false;
    if (!nextTokenIs(b, "<type modifier>", L_BRACKET, QUESTION_MARK)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_MODIFIER, "<type modifier>");
    r = consumeToken(b, QUESTION_MARK);
    if (!r) r = type_modifier_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '[' + ']'
  private static boolean type_modifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_modifier_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_modifier_1_0(b, l + 1);
    r = r && consumeToken(b, R_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' +
  private static boolean type_modifier_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_modifier_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_BRACKET);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, L_BRACKET)) break;
      if (!empty_element_parsed_guard_(b, "type_modifier_1_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ENTITY_NAME
  public static boolean type_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_name")) return false;
    if (!nextTokenIs(b, ENTITY_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENTITY_NAME);
    exit_section_(b, m, TYPE_NAME, r);
    return r;
  }

}
