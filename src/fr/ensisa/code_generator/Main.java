package fr.ensisa.code_generator;

import java.io.FileReader;
import java_cup.runtime.ComplexSymbolFactory;

public class Main {

	static public void main(String argv[]) {    
    try {
    	String name;
    	if (argv.length == 1) {
    		name = argv[0];
    	} else {
    		name = "WebColor_Generator.txt";
    	}
    	
    	ComplexSymbolFactory csf = new ComplexSymbolFactory ();
    	Lexer l = new Lexer(new FileReader(name));
    	l.setSymbolFactory(csf);
    	Parser p = new Parser(l, csf);
    	p.setContext(new Context());
    	p.parse(); 
    } catch (Exception e) {
    	e.printStackTrace();
    }
  }
}
