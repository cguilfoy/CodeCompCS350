package edu.odu.cs.cs350;
@SuppressWarnings("unused")


%%

%public
%class JavaScanner
%unicode
%line
%column
%type Token

%{

  StringBuilder string = new StringBuilder();
  
  private Token symbol(TokenKind type) {
    return new Token(type, yyline+1, yycolumn+1);
  }

  private Token symbol(TokenKind type, String value) {
    return new Token(type, yyline+1, yycolumn+1, value);
  }
  
%}

/* main character classes */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace = {LineTerminator} | [ \t\f]


/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}
TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent = ( [^*] | \*+ [^/*] )*

/* identifiers */
Identifier = [:jletter:][:jletterdigit:]*

/* integer literals */
IntegerLiteral = [0-9][0-9]* | [0-9][_0-9]*[0-9]
DecIntegerLiteral = 0 | [1-9][0-9]*


%%


/* keywords */
"abstract"                  { return symbol(TokenKind.ABSTRACT); }
"boolean"                   { return symbol(TokenKind.BOOLEAN); }
"break"                     { return symbol(TokenKind.BREAK); }
"byte"                      { return symbol(TokenKind.BYTE); }
"case"                      { return symbol(TokenKind.CASE); }
"catch"                     { return symbol(TokenKind.CATCH); }
"char"                      { return symbol(TokenKind.CHAR); }
"class"                     { return symbol(TokenKind.CLASS); }
"const"                     { return symbol(TokenKind.CONST); }
"continue"                  { return symbol(TokenKind.CONTINUE); }
"do"                        { return symbol(TokenKind.DO); }
"double"                    { return symbol(TokenKind.DOUBLE); }
"else"                      { return symbol(TokenKind.ELSE); }
"extends"                   { return symbol(TokenKind.EXTENDS); }
"final"                     { return symbol(TokenKind.FINAL); }
"finally"                   { return symbol(TokenKind.FINALLY); }
"float"                     { return symbol(TokenKind.FLOAT); }
"for"                       { return symbol(TokenKind.FOR); }
"default"                   { return symbol(TokenKind.DEFAULT); }
"implements"                { return symbol(TokenKind.IMPLEMENTS); }
"import"                    { return symbol(TokenKind.IMPORT); }
"instanceof"                { return symbol(TokenKind.INSTANCEOF); }
"int"                       { return symbol(TokenKind.INT); }
"interface"                 { return symbol(TokenKind.INTERFACE); }
"long"                      { return symbol(TokenKind.LONG); }
"native"                    { return symbol(TokenKind.NATIVE); }
"new"                       { return symbol(TokenKind.NEW); }
"goto"                      { return symbol(TokenKind.GOTO); }
"if"                        { return symbol(TokenKind.IF); }
"public"                    { return symbol(TokenKind.PUBLIC); }
"short"                     { return symbol(TokenKind.SHORT); }
"String"                    { return symbol(TokenKind.STRING); }
"super"                     { return symbol(TokenKind.SUPER); }
"switch"                    { return symbol(TokenKind.SWITCH); }
"synchronized"              { return symbol(TokenKind.SYNCHRONIZED); }
"package"                   { return symbol(TokenKind.PACKAGE); }
"private"                   { return symbol(TokenKind.PRIVATE); }
"protected"                 { return symbol(TokenKind.PROTECTED); }
"transient"                 { return symbol(TokenKind.TRANSIENT); }
"return"                    { return symbol(TokenKind.RETURN); }
"void"                      { return symbol(TokenKind.VOID); }
"static"                    { return symbol(TokenKind.STATIC); }
"while"                     { return symbol(TokenKind.WHILE); }
"this"                      { return symbol(TokenKind.THIS); }
"throw"                     { return symbol(TokenKind.THROW); }
"throws"                    { return symbol(TokenKind.THROWS); }
"try"                       { return symbol(TokenKind.TRY); }
"volatile"                  { return symbol(TokenKind.VOLATILE); }
"strictfp"                  { return symbol(TokenKind.STRICTFP); }


/* boolean literals */
"true"                      { return symbol(TokenKind.BOOLEANTRUE); }
"false"                     { return symbol(TokenKind.BOOLEANFALSE); }
  
/* null literal */
"null"                      { return symbol(TokenKind.NULL_LITERAL); }

/* separators */
"("                         { return symbol(TokenKind.LPAREN); }
")"                         { return symbol(TokenKind.RPAREN); }
"{"                         { return symbol(TokenKind.LBRACE); }
"}"                         { return symbol(TokenKind.RBRACE); }
"["                         { return symbol(TokenKind.LBRACK); }
"]"                         { return symbol(TokenKind.RBRACK); }
";"                         { return symbol(TokenKind.SEMICOLON); }
","                         { return symbol(TokenKind.COMMA); }
"."                         { return symbol(TokenKind.DOT); }

/* operators */
"="                         { return symbol(TokenKind.EQ); }
">"                         { return symbol(TokenKind.GT); }
"<"                         { return symbol(TokenKind.LT); }
"!"                         { return symbol(TokenKind.NOT); }
"~"                         { return symbol(TokenKind.COMP); }
"?"                         { return symbol(TokenKind.QUESTION); }
":"                         { return symbol(TokenKind.COLON); }
"=="                        { return symbol(TokenKind.EQEQ); }
"<="                        { return symbol(TokenKind.LTEQ); }
">="                        { return symbol(TokenKind.GTEQ); }
"!="                        { return symbol(TokenKind.NOTEQ); }
"&&"                        { return symbol(TokenKind.ANDAND); }
"||"                        { return symbol(TokenKind.OROR); }
"++"                        { return symbol(TokenKind.PLUSPLUS); }
"--"                        { return symbol(TokenKind.MINUSMINUS); }
"+"                         { return symbol(TokenKind.PLUS); }
"-"                         { return symbol(TokenKind.MINUS); }
"*"                         { return symbol(TokenKind.MULT); }
"/"                         { return symbol(TokenKind.DIV); }
"&"                         { return symbol(TokenKind.AND); }
"|"                         { return symbol(TokenKind.OR); }
"^"                         { return symbol(TokenKind.XOR); }
"%"                         { return symbol(TokenKind.MOD); }
"<<"                        { return symbol(TokenKind.LSHIFT); }
">>"                        { return symbol(TokenKind.RSHIFT); }
">>>"                       { return symbol(TokenKind.URSHIFT); }
"+="                        { return symbol(TokenKind.PLUSEQ); }
"-="                        { return symbol(TokenKind.MINUSEQ); }
"*="                        { return symbol(TokenKind.MULTEQ); }
"/="                        { return symbol(TokenKind.DIVEQ); }
"&="                        { return symbol(TokenKind.ANDEQ); }
"|="                        { return symbol(TokenKind.OREQ); }
"^="                        { return symbol(TokenKind.XOREQ); }
"%="                        { return symbol(TokenKind.MODEQ); }
"<<="                       { return symbol(TokenKind.LSHIFTEQ); }
">>="                       { return symbol(TokenKind.RSHIFTEQ); }
">>>="                      { return symbol(TokenKind.URSHIFTEQ); }
""""                        { /* Ignore: don't return anything. */ }  
  
{IntegerLiteral}            { return symbol(TokenKind.INTEGER_LITERAL, yytext()); }  
{DecIntegerLiteral}         { return symbol(TokenKind.DEC_INTEGER_LITERAL, yytext()); }
{Identifier}                { return symbol(TokenKind.IDENTIFIER, yytext()); }  
{WhiteSpace}                {/* Ignore: don't return anything. */}
{Comment}                   { /* Ignore: don't return anything. */ }


/* error fallback */
[^]                         { throw new RuntimeException("Illegal character \""+yytext()+
                                                              "\" at line "+yyline+", column "+yycolumn); }
<<EOF>>                     { return symbol(TokenKind.EOF); }
