package io.techtrails.intellij.prisma;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static io.techtrails.intellij.prisma.psi.PrismaTypes.*;

%%

%{
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
WHITE_SPACE=[\t ]+

STRING=\"[\w/._%@:?=-]*\"
BOOLEAN=(true|false)
NUMBER=((0(x|X)[0-9a-fA-F]*)|(\\+|-)?\\b(([0-9]+\\.?[0-9]*)|(\\.[0-9]+))((e|E)(\\+|-)?[0-9]+)?)([LlFfUuDdg]|UL|ul)?\\b
TRIPLE_COMMENT="///".*
DOUBLE_COMMENT="//".*
MODEL_BLOCK_ATTRIBUTE_NAME=@@[a-z]+
MODEL_FIELD_ATTRIBUTE_NAME=@[a-z]+
ENTITY_NAME=[A-Za-z][a-zA-Z_0-9]*
BLOCK_NAME=[A-Za-z][a-zA-Z_0-9]*
FUNCTION_NAME=[a-z]+

%state BLOCK_DEF
%%

<BLOCK_DEF> {
    {BLOCK_NAME}                    { return BLOCK_NAME; }
    "{"                             { yybegin(YYINITIAL); return L_CURLY; } // Reset to initial state when entering block
}

<YYINITIAL> {
  "}"                               { return R_CURLY; }
  "["                               { return L_BRACKET; }
  "]"                               { return R_BRACKET; }
  "("                               { return L_PAREN; }
  ")"                               { return R_PAREN; }
  ","                               { return COMMA; }
  "="                               { return EQ; }
  "?"                               { return QUESTION_MARK; }
  ":"                               { return COLON; }
  "datasource"                      { yybegin(BLOCK_DEF); return KEYWORD_DATASOURCE; }
  "generator"                       { yybegin(BLOCK_DEF); return KEYWORD_GENERATOR; }
  "model"                           { yybegin(BLOCK_DEF); return KEYWORD_MODEL; }
  "enum"                            { yybegin(BLOCK_DEF); return KEYWORD_ENUM; }
  "provider"                        { return FIELD_PROVIDER; }
  "url"                             { return FIELD_URL; }
  "output"                          { return FIELD_OUTPUT; }

  {STRING}                          { return STRING; }
  {BOOLEAN}                         { return BOOLEAN; }
  {NUMBER}                          { return NUMBER; }
  {TRIPLE_COMMENT}                  { return TRIPLE_COMMENT; }
  {DOUBLE_COMMENT}                  { return DOUBLE_COMMENT; }
  {MODEL_BLOCK_ATTRIBUTE_NAME}      { return MODEL_BLOCK_ATTRIBUTE_NAME; }
  {MODEL_FIELD_ATTRIBUTE_NAME}      { return MODEL_FIELD_ATTRIBUTE_NAME; }
  {ENTITY_NAME}                     { return ENTITY_NAME; }
  {FUNCTION_NAME}/\s*\(             { return FUNCTION_CALL; }
}

{EOL}         { return EOL; }
{WHITE_SPACE} { return WHITE_SPACE; }
[^] { return BAD_CHARACTER; }