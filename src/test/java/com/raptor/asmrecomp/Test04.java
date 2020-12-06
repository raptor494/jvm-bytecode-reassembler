package com.raptor.asmrecomp;

import java.nio.charset.Charset;

import org.anarres.cpp.InputLexerSource;
import org.anarres.cpp.Preprocessor;
import org.anarres.cpp.Token;

public class Test04 {

	public static void main(String[] args) throws Exception {
		
		var pp = new Preprocessor();
		
		try(var input = Test04.class.getResourceAsStream("Test04.txt")) {
			pp.addInput(new InputLexerSource(input, Charset.defaultCharset()) {
				@Override
				public String getName() {
					return "Test04.txt";
				}
			});
			
			for (;;) {
				var token = pp.token();
				if (token == null || token.getType() == Token.EOF) break;
				System.out.print(token.getText());
			}
		}
		
	}
	
}
