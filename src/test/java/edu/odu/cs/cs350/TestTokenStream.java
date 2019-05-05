package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class TestTokenStream 
{
	LinkedList<Token> tokenList = new LinkedList<Token>();
	String java = "java";
	String cpp = "cpp";
	File javafile = new File("TestDirectory/bob/ScoreTest2.java");
	File cppfile = new File("TestDirectory/tommyjones/highscore.cpp");
	
	@Test
	public void testTokenStream()
	{
		TokenStream tokenStream = new TokenStream();
		
		assertThat(tokenStream.getStream().size(), is(equalTo(0)));
	}

	@Test
	public void testTokenStreamReaderString() throws FileNotFoundException 
	{
		BufferedReader javaReader = new BufferedReader(new FileReader(javafile));
		BufferedReader cppReader = new BufferedReader(new FileReader(cppfile));
		
		TokenStream tokenStreamJava = new TokenStream(javaReader, java);
		TokenStream tokenStreamCPP = new TokenStream(cppReader, cpp);
		
		assertThat(tokenStreamJava.getStream().size(), not(equalTo(0)));
		assertThat(tokenStreamCPP.getStream().size(), not(equalTo(0)));
		assertThat(tokenStreamCPP.getStream(), not(equalTo(tokenStreamJava.getStream())));
		assertFalse(tokenStreamJava.equals(tokenStreamCPP));
		assertThat(tokenStreamJava, not(equalTo(tokenStreamCPP)));
		
		TokenStream tokenStreamJava2 = (TokenStream) tokenStreamJava.clone();
		
		assertThat(tokenStreamJava2.hashCode(), is(equalTo(tokenStreamJava.hashCode())));
		assertThat(tokenStreamJava2.toString(), is(equalTo(tokenStreamJava.toString())));
		assertThat(tokenStreamJava2.getStream().size(), is(equalTo(tokenStreamJava.getStream().size())));
	}

}
