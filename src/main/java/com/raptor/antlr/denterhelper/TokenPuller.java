package com.raptor.antlr.denterhelper;

import org.antlr.v4.runtime.Token;

@FunctionalInterface
public interface TokenPuller {
	Token pullToken();
}