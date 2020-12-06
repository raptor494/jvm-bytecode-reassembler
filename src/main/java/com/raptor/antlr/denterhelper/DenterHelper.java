package com.raptor.antlr.denterhelper;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Queue;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import com.yuvalshavit.antlr4.DenterOptions;

public abstract class DenterHelper {
	public final ArrayDeque<Token> dentsBuffer = new ArrayDeque<>();
	protected final ArrayDeque<Integer> indentations = new ArrayDeque<>();
	protected final int nlToken;
	protected final int indentToken;
	protected final int dedentToken;
	protected boolean reachedEof;
	protected EofHandler eofHandler = new StandardEofHandler();
	protected String defaultNewlineTokenText, defaultIndentTokenText, defaultDedentTokenText;
	protected boolean enabled = true;
	
	protected DenterHelper(int nlToken, int indentToken, int dedentToken) {
		this(nlToken, indentToken, dedentToken, "\n", "<INDENT>", "<DEDENT>");
	}
	
	protected DenterHelper(int nlToken, int indentToken, int dedentToken, String defaultNewlineTokenText, String defaultIndentTokenText, String defaultDedentTokenText) {
		this.nlToken = nlToken;
		this.indentToken = indentToken;
		this.dedentToken = dedentToken;
		this.defaultNewlineTokenText = defaultNewlineTokenText;
		this.defaultIndentTokenText = defaultIndentTokenText;
		this.defaultDedentTokenText = defaultDedentTokenText;
	}
	
	public void reset() {
		dentsBuffer.clear();
		indentations.clear();
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void enable() {
		enabled = true;
	}
	
	public void disable() {
		enabled = false;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Token nextToken() {
		initIfFirstRun();
		Token tk;
		if (dentsBuffer.isEmpty()) {
			tk = pullToken();
		} else {
			tk = dentsBuffer.remove();
//			if (!enabled) {
//				while (!dentsBuffer.isEmpty() && (tk.getType() == indentToken || tk.getType() == dedentToken)) {
//					tk = dentsBuffer.remove();
//				}
//				if (tk.getType() == indentToken || tk.getType() == dedentToken) {
//					tk = pullToken();
//				}
//			}
		}
		if (reachedEof) {
			return tk;
		}
		if (tk.getType() == nlToken) {
			return handleNewlineToken(tk);
		}
		if (tk.getType() == Token.EOF) {
			return eofHandler.apply(tk);
		}
		return tk;
	}

	private DenterOptions options;

	public DenterOptions getOptions() {
		var options = this.options;
		return (options == null)? this.options = createDefaultOptions() : options;
	}

	protected DenterOptions createDefaultOptions() {
		return new DenterOptions() {
			@Override
			public void ignoreEOF() {
				eofHandler = new IgnoreEofHandler();
			}
		};
	}

	protected abstract Token pullToken();

	protected void initIfFirstRun() {
		if (indentations.isEmpty()) {
			indentations.push(0);
			// First invocation. Look for the first non-NL. Enqueue it, and
			// possibly an indentation if that non-NL
			// token doesn't start at char 0.
			Token firstRealToken;
			do {
				firstRealToken = pullToken();
			} while (firstRealToken.getType() == nlToken);

			if (firstRealToken.getCharPositionInLine() > 0) {
				int indent;
				if (firstRealToken instanceof CommonToken commonToken) {
					String indentStr = commonToken.getInputStream().getText(Interval.of(firstRealToken.getStartIndex() - firstRealToken.getCharPositionInLine(), firstRealToken.getStartIndex() - 1));
					indent = getIndentCount(indentStr);
				} else {
					indent = firstRealToken.getCharPositionInLine();
				}
				
				indentations.push(indent);
				dentsBuffer.add(createToken(indentToken, firstRealToken));
			}
			dentsBuffer.add(firstRealToken);
		}
	}
	
	protected int TAB_SIZE = 8;
	
	public int getIndentCount(String indentStr) {
		int indent = indentStr.length();
		int tab = TAB_SIZE - 1;
		for (int i = 0; i < indentStr.length(); i++) {
			if (indentStr.charAt(i) == '\t')
				indent += tab;
		}
		return indent;
	}

	protected Token handleNewlineToken(Token tk) {
		if (!enabled) return tk;
		// fast-forward to the next non-NL
		Token nextNext = pullToken();
		while (nextNext.getType() == nlToken) {
			tk = nextNext;
			nextNext = pullToken();
		}
		if (nextNext.getType() == Token.EOF) {
			return eofHandler.apply(nextNext);
		}
		// nextNext is now a non-NL token; we'll queue it up after any possible dents

		String nlText = tk.getText();
		int indent = getIndentCount(nlText) - 1; // every NL has one \n char, so shorten the length to account for it
		if (nlText.length() > 1 && nlText.charAt(0) == '\r') {
			--indent; // If the NL also has a \r char, we should account for that as well
		}
		int prevIndent = indentations.peek();
		final Token res;
		if (indent == prevIndent) {
			res = tk; // just a newline
		}
		else if (indent > prevIndent) {
			res = createToken(indentToken, tk);
			indentations.push(indent);
		}
		else {
			res = unwindTo(indent, tk);
		}
		dentsBuffer.add(nextNext);
		return res;
	}
	
	protected class StandardEofHandler implements EofHandler {
		@Override
		public Token apply(Token tk) {
			Token res;
			if (enabled) {
				// when we reach EOF, unwind all indentations. If there aren't any,
				// insert a NL. This lets the grammar treat un-indented 
				// expressions as just being NL-terminated, rather than NL|EOF.
				if (indentations.isEmpty()) {
					res = createToken(nlToken, tk);
					dentsBuffer.add(tk);
				}
				else {
					res = unwindTo(0, tk);
					dentsBuffer.add(tk);
				}
			} else {
				res = tk;
			}
			reachedEof = true;
			return res;
		}
	}
	
	protected class IgnoreEofHandler implements EofHandler {
		@Override
		public Token apply(Token tk) {
			reachedEof = true;
			return tk;
		}
	}

	protected Token createToken(int tokenType, Token copyFrom) {
		CommonToken result = new CommonToken(copyFrom);
		result.setType(tokenType);
		String text = getDefaultTokenText(tokenType);
		if (text != null) result.setText(text);
		result.setChannel(0);
		return result;
	}
	
	protected String getDefaultTokenText(int tokenType) {
		if (tokenType == nlToken)     return defaultNewlineTokenText;
		if (tokenType == indentToken) return defaultIndentTokenText;
		if (tokenType == dedentToken) return defaultDedentTokenText;
		return null;
	}

	/**
	 * Returns a DEDENT token, and also queues up additional DEDENTS as
	 * necessary.
	 * 
	 * @param targetIndent
	 *            the "size" of the indentation (number of spaces) by the end
	 * @param copyFrom
	 *            the triggering token
	 * @return a DEDENT token
	 */
	protected Token unwindTo(int targetIndent, Token copyFrom) {
		assert dentsBuffer.isEmpty() : dentsBuffer;
		dentsBuffer.add(createToken(nlToken, copyFrom));
		// To make things easier, we'll queue up ALL of the dedents, and then
		// pop off the first one.
		// For example, here's how some text is analyzed:
		//
		// Text : Indentation : Action : Indents Deque
		// [ baseline ] : 0 : nothing : [0]
		// [ foo ] : 2 : INDENT : [0, 2]
		// [ bar ] : 3 : INDENT : [0, 2, 3]
		// [ baz ] : 0 : DEDENT x2 : [0]

		while (true) {
			int prevIndent = indentations.pop();
			if (prevIndent == targetIndent) {
				break;
			}
			if (targetIndent > prevIndent) {
				// "weird" condition above
				handlePartialDedent(prevIndent, targetIndent, copyFrom);
				
				break;
			}
			dentsBuffer.add(createToken(dedentToken, copyFrom));
		}
		indentations.push(targetIndent);
		return dentsBuffer.remove();
	}
	
	protected void handlePartialDedent(int prevIndent, int targetIndent, Token copyFrom) {
		indentations.push(prevIndent); // restore previous indentation,
										// since we've indented from it
		dentsBuffer.add(createToken(indentToken, copyFrom));
	}

	
	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		protected int nl;
		protected boolean $nl_specified;
		protected int indent;
		protected boolean $indent_specified;
		protected int dedent;
		protected boolean $dedent_specified;
		protected String defaultNewlineTokenText;
		protected boolean $defaultNewlineTokenText_specified;
		protected String defaultIndentTokenText;
		protected boolean $defaultIndentTokenText_specified;
		protected String defaultDedentTokenText;
		protected boolean $defaultDedentTokenText_specified;
		protected TokenPuller tokenPuller;
		protected boolean $tokenPuller_specified;

		public Builder newline(int nl) {
			this.nl = nl;
			$nl_specified = true;
			return this;
		}

		public Builder indent(int indent) {
			this.indent = indent;
			$indent_specified = true;
			return this;
		}

		public Builder dedent(int dedent) {
			this.dedent = dedent;
			$dedent_specified = true;
			return this;
		}
		
		public Builder defaultNewlineTokenText(String defaultNewlineTokenText) {
			this.defaultNewlineTokenText = defaultNewlineTokenText;
			$defaultNewlineTokenText_specified = true;
			return this;
		}
		
		public Builder defaultIndentTokenText(String defaultIndentTokenText) {
			this.defaultIndentTokenText = defaultIndentTokenText;
			$defaultIndentTokenText_specified = true;
			return this;
		}
		
		public Builder defaultDedentTokenText(String defaultDedentTokenText) {
			this.defaultDedentTokenText = defaultDedentTokenText;
			$defaultDedentTokenText_specified = true;
			return this;
		}

		public Builder pullToken(TokenPuller puller) {
			this.tokenPuller = Objects.requireNonNull(puller);
			$tokenPuller_specified = true;
			return this;
		}
		
		public DenterHelper build() {
			if (!$nl_specified)
				throw new IllegalStateException("Cannot build: newline was not specified");
			if (!$indent_specified)
				throw new IllegalStateException("Cannot build: indent was not specified");
			if (!$dedent_specified)
				throw new IllegalStateException("Cannot build: dedent was not specified");
			if (!$tokenPuller_specified)
				throw new IllegalStateException("Cannot build: tokenPuller was not specified");
			if (!($defaultIndentTokenText_specified || $defaultDedentTokenText_specified || $defaultNewlineTokenText_specified))
				return new DefaultDenterHelper(nl, indent, dedent, tokenPuller);
			if ($defaultIndentTokenText_specified && $defaultDedentTokenText_specified && $defaultNewlineTokenText_specified)
				return new DefaultDenterHelper(nl, indent, dedent, defaultNewlineTokenText, defaultIndentTokenText, defaultDedentTokenText, tokenPuller);
			var denter = new DefaultDenterHelper(nl, indent, dedent, tokenPuller);
			if ($defaultNewlineTokenText_specified)
				denter.defaultNewlineTokenText = defaultNewlineTokenText;
			if ($defaultIndentTokenText_specified)
				denter.defaultIndentTokenText = defaultIndentTokenText;
			if ($defaultDedentTokenText_specified)
				denter.defaultDedentTokenText = defaultDedentTokenText;
			return denter;
		}
	}
}
