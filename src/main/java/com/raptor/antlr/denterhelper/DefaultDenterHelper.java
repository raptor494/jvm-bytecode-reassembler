package com.raptor.antlr.denterhelper;

import java.util.Objects;

import org.antlr.v4.runtime.Token;

public class DefaultDenterHelper extends DenterHelper {
	protected TokenPuller tokenPuller;
	
	public DefaultDenterHelper(int nlToken, int indentToken, int dedentToken, String defaultNewlineTokenText, String defaultIndentTokenText, String defaultDedentTokenText, TokenPuller tokenPuller) {
		super(nlToken, indentToken, dedentToken, defaultNewlineTokenText, defaultIndentTokenText, defaultDedentTokenText);
		this.tokenPuller = Objects.requireNonNull(tokenPuller);
	}

	public DefaultDenterHelper(int nlToken, int indentToken, int dedentToken, TokenPuller tokenPuller) {
		super(nlToken, indentToken, dedentToken);
		this.tokenPuller = Objects.requireNonNull(tokenPuller);
	}

	@Override
	protected Token pullToken() {
		return tokenPuller.pullToken();
	}

}
