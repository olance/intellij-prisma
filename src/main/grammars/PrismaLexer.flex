package io.techtrails.intellij.prisma;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static io.techtrails.intellij.prisma.psi.PrismaTypes.*;

%%

%{
    IElementType currentBlock = null;
    public IElementType currentBlockForKeyword(String keyword) {
        if (keyword == "datasource") {
            return DATASOURCE_BLOCK;
        } else if (keyword == "generator") {
            return GENERATOR_BLOCK;
        } else if (keyword == "model") {
            return MODEL_BLOCK;
        } else if (keyword == "enum") {
            return ENUM_BLOCK;
        }

        return null;
    }

    public IElementType blockKeywordToken(String keyword) {
        if (keyword == "datasource") {
            return KEYWORD_DATASOURCE;
        } else if (keyword == "generator") {
            return KEYWORD_GENERATOR;
        } else if (keyword == "model") {
            return KEYWORD_MODEL;
        } else if (keyword == "enum") {
            return KEYWORD_ENUM;
        }

        return null;
    }

    public int fieldsStateForBlock(IElementType block) {
        if (block == DATASOURCE_BLOCK) {
            return DATASOURCE_FIELDS;
        } else if (block == GENERATOR_BLOCK) {
            return GENERATOR_FIELDS;
        } else if (block == MODEL_BLOCK) {
            return MODEL_FIELDS;
        } else if (block == ENUM_BLOCK) {
            return ENUM_FIELDS;
        }

        return 0;
    }

    int fieldValueState = 0;

    public _PrismaLexer() {
        this((java.io.Reader)null);
    }
%}

%public
%class _PrismaLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\r|\n|\r\n
WHITE_SPACE=\s+

STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\\"|\\'|\\)*\")
BOOLEAN=(true|false)
NUMBER=[0-9]*\.?[0-9]+
TRIPLE_COMMENT="///".*
DOUBLE_COMMENT="//".*
MODEL_BLOCK_ATTRIBUTE_NAME=@@[a-z]+
MODEL_FIELD_ATTRIBUTE_NAME=@[a-z]+
ENTITY_NAME=[A-Za-z][a-zA-Z_0-9]*
FUNCTION_CALL=[a-z]+\(

%state BLOCK_DEF_KEYWORD, AFTER_BLOCK_NAME
%state AFTER_FIELD_NAME, BEFORE_FIELD_VALUE
%state STRING_FIELD_VALUE
%state DATASOURCE_FIELDS, DATASOURCE_PROVIDER_VALUE
%state GENERATOR_FIELDS
%state MODEL_FIELDS
%state ENUM_FIELDS
%%
<YYINITIAL> {
    datasource | generator | model | enum  {
          yybegin(BLOCK_DEF_KEYWORD);
          currentBlock = currentBlockForKeyword(yytext().toString());
          return blockKeywordToken(yytext().toString());
    }

    <DATASOURCE_FIELDS, GENERATOR_FIELDS, MODEL_FIELDS, ENUM_FIELDS> {
        {WHITE_SPACE}      { return WHITE_SPACE; }
        {TRIPLE_COMMENT}   { return TRIPLE_COMMENT; }
        {DOUBLE_COMMENT}   { return DOUBLE_COMMENT; }
    }
}

<BLOCK_DEF_KEYWORD> {
    {WHITE_SPACE}  { return WHITE_SPACE; }
    {ENTITY_NAME}  { yybegin(AFTER_BLOCK_NAME); return ENTITY_NAME; }
}

<AFTER_BLOCK_NAME> {
    {WHITE_SPACE}  { return WHITE_SPACE; }
    "{"            { yybegin(fieldsStateForBlock(currentBlock)); return L_CURLY; }
}

<DATASOURCE_FIELDS> {
    // Datasources only allow `provider` and `url` fields
    "provider"  { yybegin(AFTER_FIELD_NAME); fieldValueState = DATASOURCE_PROVIDER_VALUE; return ENTITY_NAME; }
    "url"       { yybegin(AFTER_FIELD_NAME); fieldValueState = STRING_FIELD_VALUE; return ENTITY_NAME; }
}

<DATASOURCE_PROVIDER_VALUE> {
    "\"mysql\"" | "\"postgresql\"" | "\"sqlite\""  { yybegin(DATASOURCE_FIELDS); return STRING; }
}

<AFTER_FIELD_NAME> {
    {WHITE_SPACE}  { return WHITE_SPACE; }
    "="            { yybegin(BEFORE_FIELD_VALUE); return EQ; }
}

<BEFORE_FIELD_VALUE> {
    {WHITE_SPACE}  { yybegin(fieldValueState); return WHITE_SPACE; }
}

<DATASOURCE_FIELDS, GENERATOR_FIELDS, MODEL_FIELDS, ENUM_FIELDS> {
    "}"            { yybegin(YYINITIAL); currentBlock = null; return R_CURLY; }
}

[^] { return BAD_CHARACTER; }

//<YYINITIAL> {
//  {WHITE_SPACE}                     { return WHITE_SPACE; }
//
//  "{"                               { return L_CURLY; }
//  "}"                               { return R_CURLY; }
//  "["                               { return L_BRACKET; }
//  "]"                               { return R_BRACKET; }
//  "[]"                              { return BRACKET_PAIR; }
//  "("                               { return L_PAREN; }
//  ")"                               { return R_PAREN; }
//  ","                               { return COMMA; }
//  "="                               { return EQ; }
//  "?"                               { return QUESTION_MARK; }
//  ":"                               { return COLON; }
//  "datasource"                      { return KEYWORD_DATASOURCE; }
//  "generator"                       { return KEYWORD_GENERATOR; }
//  "model"                           { return KEYWORD_MODEL; }
//  "enum"                            { return KEYWORD_ENUM; }
//  "provider"                        { return FIELD_PROVIDER; }
//  "url"                             { return FIELD_URL; }
//  "output"                          { return FIELD_OUTPUT; }
//
//  {STRING}                          { return STRING; }
//  {BOOLEAN}                         { return BOOLEAN; }
//  {NUMBER}                          { return NUMBER; }
//  {TRIPLE_COMMENT}                  { return TRIPLE_COMMENT; }
//  {DOUBLE_COMMENT}                  { return DOUBLE_COMMENT; }
//  {MODEL_BLOCK_ATTRIBUTE_NAME}      { return MODEL_BLOCK_ATTRIBUTE_NAME; }
//  {MODEL_FIELD_ATTRIBUTE_NAME}      { return MODEL_FIELD_ATTRIBUTE_NAME; }
//  {ENTITY_NAME}                     { return ENTITY_NAME; }
//  {FUNCTION_CALL}                   { return FUNCTION_CALL; }
//
//}
