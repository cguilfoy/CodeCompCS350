package edu.odu.cs.cs350;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * TokenStream Class
 * Will read through a file with a JFlex Scanner and turn code into a 
 * stream of Token objects for later use
 *
 */
public class TokenStream implements Iterable<Token> {
	
	private LinkedList<Token> tokens = new LinkedList<Token>();
	private Map <String, String> tokenValues = new HashMap <String, String>();
	
	public TokenStream()
	{
		
	}
	
	public TokenStream(final Reader input, String extension) {
		
		int i = 97;
		int j = 0;
		char alpha = ' ';
		
		// This for loop takes a token's identifier and turns it into a char code
		// that will be used later to put into the tree. We did this because with
		// the size of token identifiers, it was taking way too long to search the tree
		for (TokenKind myVar : TokenKind.values())
		{
			if (j < 25)
			{
				alpha = (char) i;
				
				String alphaString = Character.toString(alpha);
				
				tokenValues.put(myVar.toString(), alphaString);
				
				i++;
				j++;
			}
			else if (j == 25)
			{
				alpha = (char) i;
				
				String alphaString = Character.toString(alpha);
				
				tokenValues.put(myVar.toString(), alphaString);
				
				i = 97;
				j++;
			}
			else if (j < 50)
			{
				alpha = (char) i;
				
				String alphaString = Character.toString(alpha);
				
				tokenValues.put(myVar.toString(), ("a" + alphaString));
				
				i++;
				j++;
			}
			else if (j == 50)
			{
				alpha = (char) i;
				
				String alphaString = Character.toString(alpha);
				
				tokenValues.put(myVar.toString(), ("a" + alphaString));
				
				i = 97;
				j++;
			}
			else if (j < 75)
			{
				alpha = (char) i;
				
				String alphaString = Character.toString(alpha);
				
				tokenValues.put(myVar.toString(), ("b" + alphaString));
				
				i++;
				j++;
			}
			else if (j == 75)
			{
				alpha = (char) i;
				
				String alphaString = Character.toString(alpha);
				
				tokenValues.put(myVar.toString(), ("b" + alphaString));
				
				i = 97;
				j++;
			}
			else if (j < 100)
			{
				alpha = (char) i;
				
				String alphaString = Character.toString(alpha);
				
				tokenValues.put(myVar.toString(), ("c" + alphaString));
				
				i++;
				j++;
			}
			else if (j == 100)
			{
				alpha = (char) i;
				
				String alphaString = Character.toString(alpha);
				
				tokenValues.put(myVar.toString(), ("c" + alphaString));
				
				i = 97;
				j++;
			}
			else if (j < 125)
			{
				alpha = (char) i;
				
				String alphaString = Character.toString(alpha);
				
				tokenValues.put(myVar.toString(), ("d" + alphaString));
				
				i++;
				j++;
			}
			else if (j == 125)
			{
				alpha = (char) i;
				
				String alphaString = Character.toString(alpha);
				
				tokenValues.put(myVar.toString(), ("d" + alphaString));
				
				i = 97;
				j++;
			}
			else if (j < 150)
			{
				alpha = (char) i;
				
				String alphaString = Character.toString(alpha);
				
				tokenValues.put(myVar.toString(), ("e" + alphaString));
				
				i++;
				j++;
			}
			else if (j == 150)
			{
				alpha = (char) i;
				
				String alphaString = Character.toString(alpha);
				
				tokenValues.put(myVar.toString(), ("e" + alphaString));
				
				i = 97;
				j++;
			}
			else if (j < 175)
			{
				alpha = (char) i;
				
				String alphaString = Character.toString(alpha);
				
				tokenValues.put(myVar.toString(), ("f" + alphaString));
				
				i++;
				j++;
			}
			else if (j == 175)
			{
				alpha = (char) i;
				
				String alphaString = Character.toString(alpha);
				
				tokenValues.put(myVar.toString(), ("f" + alphaString));
				
				i = 97;
				j++;
			}
			else if (j < 200)
			{
				alpha = (char) i;
				
				String alphaString = Character.toString(alpha);
				
				tokenValues.put(myVar.toString(), ("g" + alphaString));
				
				i++;
				j++;
			}
		}
		
		if (extension.equals("java"))
		{
			JavaScanner scanner = new JavaScanner (input);
			
			try {
				Token token = scanner.yylex();
				token.setTokenValue(tokenValues.get(token.getKind().toString()));
				
				while (token != null && token.getKind() != TokenKind.EOF) {
					
					tokens.add (token);
					
					try
					{
						token = scanner.yylex();
						token.setTokenValue(tokenValues.get(token.getKind().toString()));
					}
					catch (Exception e)
					{
						//System.out.println("Unrecognized Token");
					}
				}
			} catch (IOException exception) {
				System.out.println("Error when trying to scan tokens!");
			}
		}
		
		else if (extension.equals("cpp") || extension.equals("h"))
		{
			CPPScanner scanner = new CPPScanner (input);
			
			Token token = new Token();
				
			try
			{
				Token firstToken = scanner.yylex();
				token = (Token) firstToken.clone();
				token.setTokenValue(tokenValues.get(token.getKind().toString()));
			}
			catch (Exception e)
			{
					
			}
				
			while (token != null && token.getKind() != TokenKind.EOF) 
			{
					
				tokens.add (token);
					
				try
				{	
					token = scanner.yylex();
					token.setTokenValue(tokenValues.get(token.getKind().toString()));
				}
				catch (Exception e)
				{
			
				}
			}
		} 
	}

	
	/**
	 * toString method
	 */
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		
		for (int i = 0; i < tokens.size(); i++)
		{
			buffer.append(tokens.get(i).getKind().toString() + " : ");
		}
		
		return buffer.toString();
	}
	
	/**
	 * Equals method
	 */
	public boolean equals(Object obj)
	{
		if (obj instanceof TokenStream)
		{
			TokenStream tokStr = (TokenStream) obj;
			
			return tokens.equals(tokStr.tokens);
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Hash method
	 */
	public int hashCode()
	{
		String hashString = "";
		
		for (int i = 0; i < tokens.size(); i++)
		{
			hashString.concat(tokens.get(i).getTokenValue());
		}
		
		return hashString.hashCode();
	}
	
	/**
	 * Clone method
	 */
	public Object clone()
	{
		TokenStream tokenStr = new TokenStream();
		
		for (int i = 0; i < tokens.size(); i++)
		{
			Token tok = new Token();
			tok = (Token)tokens.get(i).clone();
			tokenStr.tokens.add(tok);
		}
		
		return tokenStr;
	}
	
	/**
	 * 
	 * @return
	 */
	public LinkedList<Token> getStream()
	{
		return tokens;
	}
	
	/**
	 * 
	 */
	@Override
	public final Iterator<Token> iterator() {
		return tokens.iterator();
	}
}
