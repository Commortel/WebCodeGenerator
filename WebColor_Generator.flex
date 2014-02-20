
%%
   
%package fr.ensisa.code_generator
%class Lexer
%line
%column
%cup

%%
[ \t\f]					{ }
[\r\n]					{ }
";"						{ return getSymbolFactory().newSymbol ("TERM", Sym.TERM); }
"{"						{ return getSymbolFactory().newSymbol ("OPEN_BRACE", Sym.OPEN_BRACE); }
"}"						{ return getSymbolFactory().newSymbol ("CLOSE_BRACE", Sym.CLOSE_BRACE); }
"["						{ return getSymbolFactory().newSymbol ("OPEN_BRACKET", Sym.OPEN_BRACKET); }
"]"						{ return getSymbolFactory().newSymbol ("CLOSE_BRACKET", Sym.CLOSE_BRACKET); }

"public"				{ return getSymbolFactory().newSymbol ("KEYWORD", Sym.KEYWORD, yytext()); }
"private"				{ return getSymbolFactory().newSymbol ("KEYWORD", Sym.KEYWORD, yytext()); }
"protected"				{ return getSymbolFactory().newSymbol ("KEYWORD", Sym.KEYWORD, yytext()); }
"static"				{ return getSymbolFactory().newSymbol ("KEYWORD", Sym.KEYWORD, yytext()); }
"final"					{ return getSymbolFactory().newSymbol ("KEYWORD", Sym.KEYWORD, yytext()); }
"native"				{ return getSymbolFactory().newSymbol ("KEYWORD", Sym.KEYWORD, yytext()); }
"synchronized"			{ return getSymbolFactory().newSymbol ("KEYWORD", Sym.KEYWORD, yytext()); }
"abstract"				{ return getSymbolFactory().newSymbol ("KEYWORD", Sym.KEYWORD, yytext()); }
"threadsafe"			{ return getSymbolFactory().newSymbol ("KEYWORD", Sym.KEYWORD, yytext()); }
"transient"				{ return getSymbolFactory().newSymbol ("KEYWORD", Sym.KEYWORD, yytext()); }

"class"					{ return getSymbolFactory().newSymbol ("CLASS", Sym.CLASS); }

[0-9]+      			{ return getSymbolFactory().newSymbol ("NUMBER", Sym.NUMBER, new Integer(yytext())); }
[A-Za-z][A-Za-z0-9]*	{ return getSymbolFactory().newSymbol ("ID", Sym.ID, yytext()); }
\/\*([^*]|\*[^/])*\*+\/		{ return getSymbolFactory().newSymbol ("COMMENT", Sym.COMMENT, yytext()); }


[^]                    { throw new Error("Illegal character <"+yytext()+">"); }