package com.raptor.antlr.denterhelper;

import org.antlr.v4.runtime.IntStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class InvalidDedentException extends RecognitionException {

	private static final long serialVersionUID = 469694898991394586L;

	public InvalidDedentException(Recognizer<?, ?> recognizer, IntStream input, ParserRuleContext ctx) {
		super(recognizer, input, ctx);
	}

	public InvalidDedentException(String message, Recognizer<?, ?> recognizer, IntStream input, ParserRuleContext ctx) {
		super(message, recognizer, input, ctx);
	}

}
