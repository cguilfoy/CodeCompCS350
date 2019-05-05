package edu.odu.cs.cs350;

/**
 * 
 * Token class consisting of the kind of token, 
 * the lexeme(string actual), and the location in the file 
 *
 */
public class Token {
	
	private TokenKind kind;
	private String lexeme;
	private int lineNumber;
	private int columnNumber;
	private String tokenValue;
	
	/**
	 * Default Constructor
	 */
	public Token()
	{
		kind = null;
		lexeme = "";
		lineNumber = 0;
		columnNumber = 0;
		tokenValue = "";
	}
	
/**
 * 
 * @param theKind the kind of token that it is
 * @param line the line in the file where the token is found
 * @param column the column of the file where the token is found
 */
	public Token (final TokenKind theKind, final int line, final int column) {
		kind = theKind;
		lexeme = "";
		lineNumber = line;
		columnNumber = column;
	}
	
/**
 * 
 * @param theKind the kind of token that it is
 * @param line the line in the file where the token is found
 * @param column the column of the file where the token is found
 * @param theLexeme the actual string value of the token
 */
    public Token (final TokenKind theKind, final int line, final int column, final String theLexeme) {
        kind = theKind;
        lexeme = theLexeme;
        lineNumber = line;
        columnNumber = column;
    }

	/**
	 *  toString method for the token class
	 */
	@Override
	public final String toString() {
		if (getLexeme().length() > 0) {
			return getKind() + ":" + getLexeme();
		}
		else {
			return getKind().toString();
		}
	}
	
	/**
	 * clone method for the token class
	 */
	public Object clone()
	{
		Token newToken = new Token();
		
		newToken.kind = this.kind;
		newToken.lexeme = this.lexeme;
		newToken.lineNumber = this.lineNumber;
		newToken.columnNumber = this.columnNumber;
		
		return newToken;
	}
	
	/**
	 * Equals method for the token class
	 */
	public boolean equals(Object obj)
	{
		if (obj instanceof Token)
		{
			Token tok = (Token) obj;
			
			return tokenValue.equals(tok.tokenValue);
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Hash method for the token class
	 */
	public int hashCode()
	{
		return tokenValue.hashCode();
	}
	
	/**
	 * 
	 * @return returns the kind of token
	 */
	public final TokenKind getKind() {
		return kind;
	}
	
	/**
	 * 
	 * @param newTokenValue setter for the token value
	 */
	public final void setTokenValue(String newTokenValue)
	{
		tokenValue = newTokenValue;
	}
	
	/**
	 * 
	 * @return returns the value of the token
	 */
	public final String getTokenValue()
	{
		return tokenValue;
	}
	
	/**
	 * 
	 * @return returns the lexeme of the token
	 */
	public final String getLexeme() {
		return lexeme;
	}
	
	/**
	 * 
	 * @return returns the line number of the token
	 */
	public int getLineNumber() {
		return lineNumber;
	}
	
	/**
	 * 
	 * @return returns the column number of the token
	 */
	public int getColumnNumber() {
		return columnNumber;
	}
}
