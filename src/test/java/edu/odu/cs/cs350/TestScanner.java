package edu.odu.cs.cs350;

import static org.junit.Assert.assertEquals;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;

import org.junit.Test;
/**
 * 
 * @author zeil edited by efryar
 *
 */

public class TestScanner {
	/*
	 * 123\t( \nvoid 42\n" takes the form:
	 * 
	 * 123	(
	 * void 42
	 * 
	 * with the following row and column structure:
	 * 
	 * Row--v
	 *      1: 123	(
	 *      2: void 42
	 *      3: 
	 *         12345678 : <-- Column
	 */
	
	/**
	 * Test scanner that reads a string that simulates file contents 
	 */
	@Test
	public final void testScanner() {
		String inString = "123\t( \nvoid 42\n";
		String extension = "java";
		Reader input = new StringReader(inString);
		TokenStream tokenstream = new TokenStream(input, extension);
		ArrayList<Token> tokens = new ArrayList<Token>();
		for (Token tok : tokenstream) {
			tokens.add(tok);
		}
		assertEquals(4, tokens.size()); //tokens are: 123 ( KEYWORD 42
        
		Token t = tokens.get(0);
        assertEquals (TokenKind.INTEGER_LITERAL, t.getKind());
        assertEquals ("123", t.getLexeme());
        assertEquals (1, t.getLineNumber());
        assertEquals (1, t.getColumnNumber());
        
        t = tokens.get(1);
        assertEquals (TokenKind.LPAREN, t.getKind());
        assertEquals (1, t.getLineNumber());
        assertEquals (5, t.getColumnNumber());
        
        t = tokens.get(2);
        assertEquals (TokenKind.VOID, t.getKind());
        assertEquals (2, t.getLineNumber());
        assertEquals (1, t.getColumnNumber());
        
        t = tokens.get(3);
        assertEquals (TokenKind.INTEGER_LITERAL, t.getKind());
        assertEquals ("42", t.getLexeme());
        assertEquals (2, t.getLineNumber());
        assertEquals (6, t.getColumnNumber());
	}

}
