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
NUMBER=((0(x|X)[0-9a-fA-F]*)|(\+|-)?(([0-9]+\.?[0-9]*)|(\.[0-9]+))((e|E)(\+|-)?[0-9]+)?)([LlFfUuDdg]|UL|ul)?
TRIPLE_COMMENT="///".*
DOUBLE_COMMENT="//".*
MODEL_BLOCK_ATTRIBUTE_NAME=@@[a-zA-Z]+
MODEL_FIELD_ATTRIBUTE_NAME=@[a-zA-Z\.]+
ENTITY_NAME=[A-Za-z][a-zA-Z_0-9]*
FUNCTION_NAME=[a-zA-Z]+

%%

<YYINITIAL> {
  "datasource"                      { return KEYWORD_DATASOURCE; }
  "generator"                       { return KEYWORD_GENERATOR; }
  "model"                           { return KEYWORD_MODEL; }
  "type"                            { return KEYWORD_TYPE; }
  "enum"                            { return KEYWORD_ENUM; }

  {STRING}                          { return STRING; }
  {BOOLEAN}                         { return BOOLEAN; }
  {NUMBER}                          { return NUMBER; }
  {TRIPLE_COMMENT}                  { return TRIPLE_COMMENT; }
  {DOUBLE_COMMENT}                  { return DOUBLE_COMMENT; }
  {MODEL_BLOCK_ATTRIBUTE_NAME}      { return MODEL_BLOCK_ATTRIBUTE_NAME; }
  {MODEL_FIELD_ATTRIBUTE_NAME}      { return MODEL_FIELD_ATTRIBUTE_NAME; }
  {FUNCTION_NAME}/\s*\(             { return FUNCTION_NAME; }
  {ENTITY_NAME}                     { return ENTITY_NAME; }

  "}"                               { return R_CURLY; }
  "{"                               { return L_CURLY; }
  "["                               { return L_BRACKET; }
  "]"                               { return R_BRACKET; }
  "("                               { return L_PAREN; }
  ")"                               { return R_PAREN; }
  ","                               { return COMMA; }
  "="                               { return EQ; }
  "?"                               { return QUESTION_MARK; }
  ":"                               { return COLON; }
}

{EOL}         { return EOL; }
{WHITE_SPACE} { return WHITE_SPACE; }
[^] { return BAD_CHARACTER; }
