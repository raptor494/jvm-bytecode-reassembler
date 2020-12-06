package com.raptor.asmrecomp;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStreamRewriter;

public class Test03 {
	private static final Path LEXER_GRAMMAR_FILE = Paths.get("src/main/java/com/raptor/asmrecomp/ASMLexer.g4");
	
	private static final int LINE = 0, OFFSET = 1;
	
	public static void main(String[] args) throws Exception {
		
		var lexer = new ASMLexer(CharStreams.fromString("""
			public class Foo {
				void foo();
					Code:
					line1
					line2
					line3
					line4
			
				void bar();
					descriptor: null
					Code:
						value1
							value2
						value3
						
					done
			}
			"""));
		
		var tokenStream = new CommonTokenStream(lexer);
		tokenStream.fill();

		var rewriter = new TokenStreamRewriter(tokenStream);
		rewriter.insertAfter(4, " extends String");
		lexer = new ASMLexer(CharStreams.fromString(rewriter.getText()));
		tokenStream = new CommonTokenStream(lexer);
		tokenStream.fill();
		
		
		var vocab = lexer.getVocabulary();
		var tokens = tokenStream.getTokens().toArray(Token[]::new);
		final int count = tokens.length+1;
		
		var names    = new String[count];
		var contents = new String[count];
		var lines    = new String[count];
		var offsets  = new String[count];
		var channels = new String[count];
		
		names[0]    = "NAME";
		contents[0] = "TEXT";
		lines[0]    = "L";
		offsets[0]  = "C";
		channels[0] = "CHANNEL";
		
		int longestName    = names[0].length();
		int longestContent = contents[0].length();
		int longestLine    = lines[0].length();
		int longestOffset  = offsets[0].length();
		int longestChannel = channels[0].length();
		
		for (int i = 1; i <= tokens.length; i++) {
			var token = tokens[i-1];
			int type  = token.getType();
			String name = vocab.getSymbolicName(type);
			if (name == null) {
				name = vocab.getLiteralName(type);
				if (name == null) {
					name = vocab.getDisplayName(type);
				}
			}
			String line    = token.getLine() + "";
			String offset  = token.getCharPositionInLine() + "";
			String channel = token.getChannel() == Lexer.DEFAULT_TOKEN_CHANNEL? "" : lexer.getChannelNames()[token.getChannel()];
			String content = switch (type) {
				case ASMLexer.INDENT, ASMLexer.DEDENT, ASMLexer.EOF -> Objects.requireNonNullElse(token.getText(), "");
				default -> "'" + token.getText().replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t").replace("\f", "\\f").replace("'", "\\'") + "'";
			};
			if (name.length() > longestName)
				longestName = name.length();
			if (content.length() > longestContent)
				longestContent = content.length();
			if (line.length() > longestLine)
				longestLine = line.length();
			if (offset.length() > longestOffset)
				longestOffset = offset.length();
			if (channel.length() > longestChannel)
				longestChannel = channel.length();
			names[i]    = name;
			contents[i] = content;
			lines[i]    = line;
			offsets[i]  = offset;
			channels[i] = channel;
		}
		
		if (longestLine > 1) {
			lines[0] = switch (longestLine) {
				case 2, 3 -> "L#";
				case 4 -> "LINE";
				case 5 -> "LINE#";
				case 6 -> "LINE #";
				case 7 -> "LINENUM";
				case 8, 9, 10 -> "LINE NUMBER".substring(0, longestLine);
				default -> "LINE NUMBER";
			};
		}
		if (longestOffset > 1) {
			offsets[0] = switch (longestOffset) {
				case 2 -> "C#";
				case 3 -> "COL";
				case 4, 5 -> "COL#";
				case 6 -> "COLUMN";
				case 7 -> "COLUMN#";
				case 8 -> "COLUMN #";
				case 9 -> "COLUMNNUM";
				case 10, 11, 12 -> "COLUMN NUMBER".substring(0, longestOffset);
				default -> "COLUMN NUMBER";
			};
		}
		
		var format = "%"+longestLine+"s:%-"+longestOffset+"s  %-"+longestName+"s %-"+longestContent+"s %-"+longestChannel+"s\n";
	
		for (int i = 0; i < count; i++) {
			System.out.printf(format, lines[i], offsets[i], names[i], contents[i], channels[i]);
		}
		
//		String grammarText = Files.readString(LEXER_GRAMMAR_FILE);
//		String fileName = LEXER_GRAMMAR_FILE.getFileName().toString();
//		var lexerGrammar = new LexerGrammar(fileName, grammarText, null);
//		//var ignoreTokenNames = Set.of("WS", "NegativeIntegerLiteral", "IntegerLiteral", "FloatingPointLiteral", "CharacterLiteral", "StringLiteral"); 
//		for (var name : lexerGrammar.getTokenSymbolicNames()) {
//			if (name == null) continue;
//			
//			System.out.printf("IND_%1$s : %1$s -> type(%1$s);\n", name);
//		}
	}
}
