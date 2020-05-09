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
    create_token_set_(BLOCK, DATASOURCE_BLOCK, ENUM_BLOCK, GENERATOR_BLOCK,
      MODEL_BLOCK),
  };

  /* ********************************************************** */
  // '[]' | '[' (field-value (',' field-value)*)* ']'
  static boolean array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array")) return false;
    if (!nextTokenIs(b, "", BRACKET_PAIR, L_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACKET_PAIR);
    if (!r) r = array_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' (field-value (',' field-value)*)* ']'
  private static boolean array_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, L_BRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, array_1_1(b, l + 1));
    r = p && consumeToken(b, R_BRACKET) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (field-value (',' field-value)*)*
  private static boolean array_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!array_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_1_1", c)) break;
    }
    return true;
  }

  // field-value (',' field-value)*
  private static boolean array_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = field_value(b, l + 1);
    p = r; // pin = 1
    r = r && array_1_1_0_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (',' field-value)*
  private static boolean array_1_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!array_1_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_1_1_0_1", c)) break;
    }
    return true;
  }

  // ',' field-value
  private static boolean array_1_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_1_0_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && field_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // datasource-block | generator-block | model-block | enum-block
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, BLOCK, "<block>");
    r = datasource_block(b, l + 1);
    if (!r) r = generator_block(b, l + 1);
    if (!r) r = model_block(b, l + 1);
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
  // 'datasource'    block-name '{' (datasource-block-statement  | comment)* '}'
  public static boolean datasource_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "datasource_block")) return false;
    if (!nextTokenIs(b, KEYWORD_DATASOURCE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DATASOURCE_BLOCK, null);
    r = consumeToken(b, KEYWORD_DATASOURCE);
    p = r; // pin = 1
    r = r && report_error_(b, block_name(b, l + 1));
    r = p && report_error_(b, consumeToken(b, L_CURLY)) && r;
    r = p && report_error_(b, datasource_block_3(b, l + 1)) && r;
    r = p && consumeToken(b, R_CURLY) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (datasource-block-statement  | comment)*
  private static boolean datasource_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "datasource_block_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!datasource_block_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "datasource_block_3", c)) break;
    }
    return true;
  }

  // datasource-block-statement  | comment
  private static boolean datasource_block_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "datasource_block_3_0")) return false;
    boolean r;
    r = datasource_block_statement(b, l + 1);
    if (!r) r = comment(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'provider' '=' STRING | 'url' '=' string-or-env
  public static boolean datasource_block_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "datasource_block_statement")) return false;
    if (!nextTokenIs(b, "<datasource block statement>", FIELD_PROVIDER, FIELD_URL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DATASOURCE_BLOCK_STATEMENT, "<datasource block statement>");
    r = parseTokens(b, 1, FIELD_PROVIDER, EQ, STRING);
    if (!r) r = datasource_block_statement_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'url' '=' string-or-env
  private static boolean datasource_block_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "datasource_block_statement_1")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeTokens(b, 1, FIELD_URL, EQ);
    p = r; // pin = 1
    r = r && string_or_env(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'enum'          block-name '{' (enum-block-statement        | comment)* '}'
  public static boolean enum_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_block")) return false;
    if (!nextTokenIs(b, KEYWORD_ENUM)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENUM_BLOCK, null);
    r = consumeToken(b, KEYWORD_ENUM);
    p = r; // pin = 1
    r = r && report_error_(b, block_name(b, l + 1));
    r = p && report_error_(b, consumeToken(b, L_CURLY)) && r;
    r = p && report_error_(b, enum_block_3(b, l + 1)) && r;
    r = p && consumeToken(b, R_CURLY) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (enum-block-statement        | comment)*
  private static boolean enum_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_block_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enum_block_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_block_3", c)) break;
    }
    return true;
  }

  // enum-block-statement        | comment
  private static boolean enum_block_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_block_3_0")) return false;
    boolean r;
    r = enum_block_statement(b, l + 1);
    if (!r) r = comment(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ENTITY_NAME ('=' STRING)?
  public static boolean enum_block_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_block_statement")) return false;
    if (!nextTokenIs(b, ENTITY_NAME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENUM_BLOCK_STATEMENT, null);
    r = consumeToken(b, ENTITY_NAME);
    p = r; // pin = 1
    r = r && enum_block_statement_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('=' STRING)?
  private static boolean enum_block_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_block_statement_1")) return false;
    enum_block_statement_1_0(b, l + 1);
    return true;
  }

  // '=' STRING
  private static boolean enum_block_statement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_block_statement_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeTokens(b, 1, EQ, STRING);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'env(' STRING ')'
  static boolean env_var_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "env_var_value")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "env(");
    r = r && consumeTokens(b, 0, STRING, R_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // scalar-value | array | env-var-value
  static boolean field_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_value")) return false;
    boolean r;
    r = scalar_value(b, l + 1);
    if (!r) r = array(b, l + 1);
    if (!r) r = env_var_value(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'generator'     block-name '{' (generator-block-statement   | comment)* '}'
  public static boolean generator_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_block")) return false;
    if (!nextTokenIs(b, KEYWORD_GENERATOR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, GENERATOR_BLOCK, null);
    r = consumeToken(b, KEYWORD_GENERATOR);
    p = r; // pin = 1
    r = r && report_error_(b, block_name(b, l + 1));
    r = p && report_error_(b, consumeToken(b, L_CURLY)) && r;
    r = p && report_error_(b, generator_block_3(b, l + 1)) && r;
    r = p && consumeToken(b, R_CURLY) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (generator-block-statement   | comment)*
  private static boolean generator_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_block_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!generator_block_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "generator_block_3", c)) break;
    }
    return true;
  }

  // generator-block-statement   | comment
  private static boolean generator_block_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_block_3_0")) return false;
    boolean r;
    r = generator_block_statement(b, l + 1);
    if (!r) r = comment(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'provider' '=' STRING | 'output' '=' string-or-env
  static boolean generator_block_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_block_field")) return false;
    if (!nextTokenIs(b, "", FIELD_OUTPUT, FIELD_PROVIDER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parseTokens(b, 1, FIELD_PROVIDER, EQ, STRING);
    if (!r) r = generator_block_field_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'output' '=' string-or-env
  private static boolean generator_block_field_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_block_field_1")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeTokens(b, 1, FIELD_OUTPUT, EQ);
    p = r; // pin = 1
    r = r && string_or_env(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // generator-block-field | generator-config-field
  public static boolean generator_block_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_block_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GENERATOR_BLOCK_STATEMENT, "<generator block statement>");
    r = generator_block_field(b, l + 1);
    if (!r) r = generator_config_field(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ENTITY_NAME '=' field-value
  static boolean generator_config_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generator_config_field")) return false;
    if (!nextTokenIs(b, ENTITY_NAME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeTokens(b, 1, ENTITY_NAME, EQ);
    p = r; // pin = 1
    r = r && field_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ENTITY_NAME ':'
  public static boolean model_attribute_param_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_attribute_param_name")) return false;
    if (!nextTokenIs(b, ENTITY_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ENTITY_NAME, COLON);
    exit_section_(b, m, MODEL_ATTRIBUTE_PARAM_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // model-attribute-param-value-scalar | model-attribute-param-value-array | model-function
  public static boolean model_attribute_param_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_attribute_param_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODEL_ATTRIBUTE_PARAM_VALUE, "<model attribute param value>");
    r = model_attribute_param_value_scalar(b, l + 1);
    if (!r) r = model_attribute_param_value_array(b, l + 1);
    if (!r) r = model_function(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '[]' | '[' model-attribute-param-value-scalar? (',' model-attribute-param-value-scalar)* ']'
  static boolean model_attribute_param_value_array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_attribute_param_value_array")) return false;
    if (!nextTokenIs(b, "", BRACKET_PAIR, L_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACKET_PAIR);
    if (!r) r = model_attribute_param_value_array_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' model-attribute-param-value-scalar? (',' model-attribute-param-value-scalar)* ']'
  private static boolean model_attribute_param_value_array_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_attribute_param_value_array_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_BRACKET);
    r = r && model_attribute_param_value_array_1_1(b, l + 1);
    r = r && model_attribute_param_value_array_1_2(b, l + 1);
    r = r && consumeToken(b, R_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // model-attribute-param-value-scalar?
  private static boolean model_attribute_param_value_array_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_attribute_param_value_array_1_1")) return false;
    model_attribute_param_value_scalar(b, l + 1);
    return true;
  }

  // (',' model-attribute-param-value-scalar)*
  private static boolean model_attribute_param_value_array_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_attribute_param_value_array_1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!model_attribute_param_value_array_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "model_attribute_param_value_array_1_2", c)) break;
    }
    return true;
  }

  // ',' model-attribute-param-value-scalar
  private static boolean model_attribute_param_value_array_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_attribute_param_value_array_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && model_attribute_param_value_scalar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ENTITY_NAME | STRING | NUMBER | BOOLEAN
  static boolean model_attribute_param_value_scalar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_attribute_param_value_scalar")) return false;
    boolean r;
    r = consumeToken(b, ENTITY_NAME);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, BOOLEAN);
    return r;
  }

  /* ********************************************************** */
  // '(' model-attribute-param-name? model-attribute-param-value (',' model-attribute-param-name model-attribute-param-value)* ')'
  static boolean model_attribute_params(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_attribute_params")) return false;
    if (!nextTokenIs(b, L_PAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, L_PAREN);
    p = r; // pin = 1
    r = r && report_error_(b, model_attribute_params_1(b, l + 1));
    r = p && report_error_(b, model_attribute_param_value(b, l + 1)) && r;
    r = p && report_error_(b, model_attribute_params_3(b, l + 1)) && r;
    r = p && consumeToken(b, R_PAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // model-attribute-param-name?
  private static boolean model_attribute_params_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_attribute_params_1")) return false;
    model_attribute_param_name(b, l + 1);
    return true;
  }

  // (',' model-attribute-param-name model-attribute-param-value)*
  private static boolean model_attribute_params_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_attribute_params_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!model_attribute_params_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "model_attribute_params_3", c)) break;
    }
    return true;
  }

  // ',' model-attribute-param-name model-attribute-param-value
  private static boolean model_attribute_params_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_attribute_params_3_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && report_error_(b, model_attribute_param_name(b, l + 1));
    r = p && model_attribute_param_value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'model'         block-name '{' (model-block-statement       | comment)* '}'
  public static boolean model_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_block")) return false;
    if (!nextTokenIs(b, KEYWORD_MODEL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MODEL_BLOCK, null);
    r = consumeToken(b, KEYWORD_MODEL);
    p = r; // pin = 1
    r = r && report_error_(b, block_name(b, l + 1));
    r = p && report_error_(b, consumeToken(b, L_CURLY)) && r;
    r = p && report_error_(b, model_block_3(b, l + 1)) && r;
    r = p && consumeToken(b, R_CURLY) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (model-block-statement       | comment)*
  private static boolean model_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_block_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!model_block_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "model_block_3", c)) break;
    }
    return true;
  }

  // model-block-statement       | comment
  private static boolean model_block_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_block_3_0")) return false;
    boolean r;
    r = model_block_statement(b, l + 1);
    if (!r) r = comment(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // MODEL_BLOCK_ATTRIBUTE_NAME model-attribute-params?
  public static boolean model_block_attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_block_attribute")) return false;
    if (!nextTokenIs(b, MODEL_BLOCK_ATTRIBUTE_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MODEL_BLOCK_ATTRIBUTE_NAME);
    r = r && model_block_attribute_1(b, l + 1);
    exit_section_(b, m, MODEL_BLOCK_ATTRIBUTE, r);
    return r;
  }

  // model-attribute-params?
  private static boolean model_block_attribute_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_block_attribute_1")) return false;
    model_attribute_params(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // model-field-definition | model-block-attribute
  public static boolean model_block_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_block_statement")) return false;
    if (!nextTokenIs(b, "<model block statement>", ENTITY_NAME, MODEL_BLOCK_ATTRIBUTE_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODEL_BLOCK_STATEMENT, "<model block statement>");
    r = model_field_definition(b, l + 1);
    if (!r) r = model_block_attribute(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // MODEL_FIELD_ATTRIBUTE_NAME model-attribute-params?
  public static boolean model_field_attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_field_attribute")) return false;
    if (!nextTokenIs(b, MODEL_FIELD_ATTRIBUTE_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MODEL_FIELD_ATTRIBUTE_NAME);
    r = r && model_field_attribute_1(b, l + 1);
    exit_section_(b, m, MODEL_FIELD_ATTRIBUTE, r);
    return r;
  }

  // model-attribute-params?
  private static boolean model_field_attribute_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_field_attribute_1")) return false;
    model_attribute_params(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ENTITY_NAME model-field-type model-field-attribute*
  static boolean model_field_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_field_definition")) return false;
    if (!nextTokenIs(b, ENTITY_NAME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, ENTITY_NAME);
    p = r; // pin = 1
    r = r && report_error_(b, model_field_type(b, l + 1));
    r = p && model_field_definition_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // model-field-attribute*
  private static boolean model_field_definition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_field_definition_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!model_field_attribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "model_field_definition_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ENTITY_NAME model-type-modifier?
  public static boolean model_field_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_field_type")) return false;
    if (!nextTokenIs(b, ENTITY_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENTITY_NAME);
    r = r && model_field_type_1(b, l + 1);
    exit_section_(b, m, MODEL_FIELD_TYPE, r);
    return r;
  }

  // model-type-modifier?
  private static boolean model_field_type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_field_type_1")) return false;
    model_type_modifier(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // FUNCTION_CALL ')'
  static boolean model_function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_function")) return false;
    if (!nextTokenIs(b, FUNCTION_CALL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FUNCTION_CALL, R_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '?' | '[]'
  public static boolean model_type_modifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_type_modifier")) return false;
    if (!nextTokenIs(b, "<model type modifier>", BRACKET_PAIR, QUESTION_MARK)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODEL_TYPE_MODIFIER, "<model type modifier>");
    r = consumeToken(b, QUESTION_MARK);
    if (!r) r = consumeToken(b, BRACKET_PAIR);
    exit_section_(b, l, m, r, false, null);
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
  // !<<eof>> block | comment
  static boolean root_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_item")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = root_item_0(b, l + 1);
    if (!r) r = comment(b, l + 1);
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
  // STRING | env-var-value
  static boolean string_or_env(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_or_env")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = env_var_value(b, l + 1);
    return r;
  }

}
