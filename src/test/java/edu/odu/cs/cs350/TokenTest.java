package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import org.junit.Test;

public class TokenTest {

	@Test
	public void testDefaultConstructor() {
		Token testToken = new Token();
		
		assertEquals(null, testToken.getKind());
		assertEquals("", testToken.getLexeme());
		assertEquals(0, testToken.getLineNumber(), 0); //(expected, actual, delta) where delta is value the two can be off by.
		assertEquals(0, testToken.getColumnNumber());
		assertEquals("", testToken.getTokenValue());
	}
	
	@Test
	public void testConstructor() {
		Token testToken = new Token (TokenKind.ABSTRACT, 5, 10, "thelexeme");
		
		assertEquals(TokenKind.ABSTRACT, testToken.getKind());
		assertEquals(5, testToken.getLineNumber(), 0);
		assertEquals(10, testToken.getColumnNumber(), 0);
		assertEquals("thelexeme", testToken.getLexeme());
	}
	
	@Test
	public void testConstructorNoLexeme() {
		Token testToken = new Token (TokenKind.FINAL, 10, 5);
		
		assertEquals(TokenKind.FINAL, testToken.getKind());
		assertEquals(10, testToken.getLineNumber(), 0);
		assertEquals(5, testToken.getColumnNumber(), 0);
		assertEquals("", testToken.getLexeme());
	}	
}
