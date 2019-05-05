package edu.odu.cs.cs350;
@SuppressWarnings("unused")


%%

%public
%class CPPScanner
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
"alignas"                   { return symbol(TokenKind.ALIGNAS); }
"alignof"                   { return symbol(TokenKind.ALIGNOF); }
"and"                       { return symbol(TokenKind.AND); }
"and_eq"                    { return symbol(TokenKind.ANDEQ); }
"asm"                       { return symbol(TokenKind.ASM); }
"atomic_cancel"             { return symbol(TokenKind.ATOMIC_CANCEL); }
"atomic_commit"             { return symbol(TokenKind.ATOMIC_COMMIT); }
"atomic_noexcept"           { return symbol(TokenKind.ATOMIC_NOEXCEPT); }
"auto"                      { return symbol(TokenKind.AUTO); }
"bitand"                    { return symbol(TokenKind.BITAND); }
"bitor"                     { return symbol(TokenKind.BITOR); }
"bool"                      { return symbol(TokenKind.BOOL); }
"break"                     { return symbol(TokenKind.BREAK); }
"case"                      { return symbol(TokenKind.CASE); }
"catch"                     { return symbol(TokenKind.CATCH); }
"char"                      { return symbol(TokenKind.CHAR); }
"cin"                       { return symbol(TokenKind.CIN); }
"std::cin"                  { return symbol(TokenKind.CIN); }
"class"                     { return symbol(TokenKind.CLASS); }
"compl"                     { return symbol(TokenKind.COMPL); }
"cout"                      { return symbol(TokenKind.COUT); }
"std::cout"                 { return symbol(TokenKind.COUT); }
"concept"                   { return symbol(TokenKind.CONCEPT); }
"const"                     { return symbol(TokenKind.CONST); }
"consteval"                 { return symbol(TokenKind.CONSTEVAL); }
"constexpr"                 { return symbol(TokenKind.CONSTEXPR); }
"const_cast"                { return symbol(TokenKind.CONST_CAST); }
"continue"                  { return symbol(TokenKind.CONTINUE); }
"co_await"                  { return symbol(TokenKind.CO_AWAIT); }
"co_return"                 { return symbol(TokenKind.CO_RETURN); }
"co_yield"                  { return symbol(TokenKind.CO_YIELD); }
"decltype"                  { return symbol(TokenKind.DECLTYPE); }
"default"                   { return symbol(TokenKind.DEFAULT); }
"delete"                    { return symbol(TokenKind.DELETE); }
"do"                        { return symbol(TokenKind.DO); }
"double"                    { return symbol(TokenKind.DOUBLE); }
"dynamic_cast"              { return symbol(TokenKind.DYNAMIC_CAST); }
"else"                      { return symbol(TokenKind.ELSE); }
"enum"                      { return symbol(TokenKind.ENUM); }
"explicit"                  { return symbol(TokenKind.EXPLICIT); }
"export"                    { return symbol(TokenKind.EXPORT); }
"extern"                    { return symbol(TokenKind.EXTERN); }
"float"                     { return symbol(TokenKind.FLOAT); }
"for"                       { return symbol(TokenKind.FOR); }
"friend"                    { return symbol(TokenKind.FRIEND); }
"goto"                      { return symbol(TokenKind.GOTO); }
"if"                        { return symbol(TokenKind.IF); }
"inline"                    { return symbol(TokenKind.INLINE); }
"int"                       { return symbol(TokenKind.INT); }
"long"                      { return symbol(TokenKind.LONG); }
"mutable"                   { return symbol(TokenKind.MUTABLE); }
"namespace"                 { return symbol(TokenKind.NAMESPACE); }
"new"                       { return symbol(TokenKind.NEW); }
"noexcept"                  { return symbol(TokenKind.NOEXCEPT); }
"nullptr"                   { return symbol(TokenKind.NULLPTR); }
"operator"                  { return symbol(TokenKind.OPERATOR); }
"or"                        { return symbol(TokenKind.OR); }
"or_eq"                     { return symbol(TokenKind.OREQ); }
"private"                   { return symbol(TokenKind.PRIVATE); }
"protected"                 { return symbol(TokenKind.PROTECTED); }
"public"                    { return symbol(TokenKind.PUBLIC); }
"reflexpr"                  { return symbol(TokenKind.REFLEXPR); }
"register"                  { return symbol(TokenKind.REGISTER); }
"reinterpret_cast"          { return symbol(TokenKind.REINTERPRET_CAST); }
"requires"                  { return symbol(TokenKind.REQUIRES); }
"return"                    { return symbol(TokenKind.RETURN); }
"short"                     { return symbol(TokenKind.SHORT); }
"signed"                    { return symbol(TokenKind.SIGNED); }
"sizeof"                    { return symbol(TokenKind.SIZEOF); }
"static"                    { return symbol(TokenKind.STATIC); }
"static_assert"             { return symbol(TokenKind.STATIC_ASSERT); }
"static_cast"               { return symbol(TokenKind.STATIC_CAST); }
"struct"                    { return symbol(TokenKind.STRUCT); }
"switch"                    { return symbol(TokenKind.SWITCH); }
"synchronized"              { return symbol(TokenKind.SYNCHRONIZED); }
"template"                  { return symbol(TokenKind.TEMPLATE); }
"this"                      { return symbol(TokenKind.THIS); }
"thread_local"              { return symbol(TokenKind.THREAD_LOCAL); }
"throw"                     { return symbol(TokenKind.THROW); }
"try"                       { return symbol(TokenKind.TRY); }
"typedef"                   { return symbol(TokenKind.TYPEDEF); }
"typeid"                    { return symbol(TokenKind.TYPEID); }
"typename"                  { return symbol(TokenKind.TYPENAME); }
"union"                     { return symbol(TokenKind.UNION); }
"unsigned"                  { return symbol(TokenKind.UNSIGNED); }
"using"                     { return symbol(TokenKind.USING); }
"virtual"                   { return symbol(TokenKind.VIRTUAL); }
"void"                      { return symbol(TokenKind.VOID); }
"volatile"                  { return symbol(TokenKind.VOLATILE); }
"wchart_t"                  { return symbol(TokenKind.WCHART_T); }
"while"                     { return symbol(TokenKind.WHILE); }
"xor"                       { return symbol(TokenKind.XOR); }
"xor_eq"                    { return symbol(TokenKind.XOREQ); }


/* containers */
"array"                     { return symbol(TokenKind.ARRAY); }
"std::array"                { return symbol(TokenKind.ARRAY); }
"bitset"                    { return symbol(TokenKind.BITSET); }
"std::bitset"               { return symbol(TokenKind.BITSET); }
"deque"                     { return symbol(TokenKind.DEQUE); }
"std::deque"                { return symbol(TokenKind.DEQUE); }
"forward_list"              { return symbol(TokenKind.FORWARD_LIST); }
"std::forward_list"         { return symbol(TokenKind.FORWARD_LIST); }
"list"                      { return symbol(TokenKind.LIST); }
"std::list"                 { return symbol(TokenKind.LIST); }
"map"                       { return symbol(TokenKind.MAP); }
"std::map"                  { return symbol(TokenKind.MAP); }
"queue"                     { return symbol(TokenKind.QUEUE); }
"std::queue"                { return symbol(TokenKind.QUEUE); }
"set"                       { return symbol(TokenKind.SET); }
"std::set"                  { return symbol(TokenKind.SET); }
"stack"                     { return symbol(TokenKind.STACK); }
"std::stack"                { return symbol(TokenKind.STACK); }
"unordered_map"             { return symbol(TokenKind.UNORDERED_MAP); }
"std::unordered_map"        { return symbol(TokenKind.UNORDERED_MAP); }
"unordered_set"             { return symbol(TokenKind.UNORDERED_SET); }
"std::unordered_set"        { return symbol(TokenKind.UNORDERED_SET); }


/* General */
"algorithm"                 { return symbol(TokenKind.ALGORITHM); }
"std::algorithm"            { return symbol(TokenKind.ALGORITHM); }
"chrono"                    { return symbol(TokenKind.CHRONO); }
"std::chrono"               { return symbol(TokenKind.CHRONO); }
"functional"                { return symbol(TokenKind.FUNCTIONAL); }
"std::functional"           { return symbol(TokenKind.FUNCTIONAL); }
"iterator"                  { return symbol(TokenKind.ITERATOR); }
"std::iterator"             { return symbol(TokenKind.ITERATOR); }
"memory"                    { return symbol(TokenKind.MEMORY); }
"std::memory"               { return symbol(TokenKind.MEMORY); }
"stdexcept"                 { return symbol(TokenKind.STDEXCEPT); }
"std::stdexcept"            { return symbol(TokenKind.STDEXCEPT); }
"utility"                   { return symbol(TokenKind.UTILITY); }
"std::utility"              { return symbol(TokenKind.UTILITY); }
"string"                   { return symbol(TokenKind.STRING); }
"std::string"              { return symbol(TokenKind.STRING); }


/* IO Streams */
"fstream"                   { return symbol(TokenKind.FSTREAM); }
"std::fstream"              { return symbol(TokenKind.FSTREAM); }
"iomanip"                   { return symbol(TokenKind.IOMANIP); }
"std::iomanip"              { return symbol(TokenKind.IOMANIP); }
"ios"                       { return symbol(TokenKind.IOS); }
"std::ios"                  { return symbol(TokenKind.IOS); }
"iosfwd"                    { return symbol(TokenKind.IOSFWD); }
"std::iosfwd"               { return symbol(TokenKind.IOSFWD); }
"iostream"                  { return symbol(TokenKind.IOSTREAM); }
"std::iostream"             { return symbol(TokenKind.IOSTREAM); }
"istream"                   { return symbol(TokenKind.ISTREAM); }
"std::istream"              { return symbol(TokenKind.ISTREAM); }
"ostream"                   { return symbol(TokenKind.OSTREAM); }
"std::ostream"              { return symbol(TokenKind.OSTREAM); }
"sstream"                   { return symbol(TokenKind.SSTREAM); }
"std::sstream"              { return symbol(TokenKind.SSTREAM); }
"streambuf"                 { return symbol(TokenKind.STREAMBUF); }
"std::streambuf"            { return symbol(TokenKind.STREAMBUF); }


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
