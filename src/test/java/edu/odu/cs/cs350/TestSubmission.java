package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class TestSubmission 
{	
	ArrayList<String> tokenString = new ArrayList<String>(
		Arrays.asList("aefrdeaasgbgg", "aedrtfswe", "aasdeddf"));
	
	File file = new File("TestDirectory/bob/ScoreTest2.java");
	
	ArrayList<SourceFile> sourceList = new ArrayList<SourceFile>();
	LinkedList<Token> tokenList = new LinkedList<Token>();
	
	@Test
	public void testSubmissionDefault() throws IOException 
	{
		Submission submission = new Submission(); 
			
		File file = new File("TestDirectory/bob/");
		
		String pathName = "TestDirectory/bob/";
		
		assertThat(submission.getNumberOfFiles(), is(equalTo(0)));
		assertThat(submission.getPath(), is(equalTo("")));
		assertThat(submission.getSubmissionLOC(), is(equalTo(0)));
		assertThat(submission.getSubmissionName(), is(equalTo("")));
		assertThat(submission.getTokenListSize(), is(equalTo(0)));
		assertThat(submission.getTokenString().size(), is(equalTo(0)));
		assertThat(submission.getVersion(), is(equalTo(0)));
		
		submission.parseSubmission(pathName);
		submission.findFiles(file);
		submission.tokenizeFiles();
		String tokenString = submission.tokenListToString();
		submission.calculateLinesOfCode();
		
		assertThat(submission.getNumberOfFiles(), is(equalTo(1)));
		assertThat(submission.getPath(), is(equalTo("TestDirectory/bob/")));
		assertThat(submission.getSubmissionLOC(), is(equalTo(4)));
		assertThat(submission.getSubmissionName(), is(equalTo("TestDirectory/bob/")));
		assertThat(submission.getTokenListSize(), not(equalTo(0)));
		assertThat(submission.getTokenString().size(), not(equalTo(0)));
		assertThat(submission.getVersion(), is(equalTo(-1)));
		
		Submission submission2 = (Submission) submission.clone();
		
		assertThat(submission2.getNumberOfFiles(), is(equalTo(submission.getNumberOfFiles())));
		assertThat(submission2.getPath(), is(equalTo(submission.getPath())));
		assertThat(submission2.getSubmissionLOC(), is(equalTo(submission.getSubmissionLOC())));
		assertThat(submission2.getSubmissionName(), is(equalTo(submission.getSubmissionName())));
		assertThat(submission2.getTokenListSize(), is(equalTo(submission.getTokenListSize())));
		assertThat(submission2.getTokenString().size(), is(equalTo(submission.getTokenString().size())));
		assertThat(submission2.getVersion(), is(equalTo(submission.getVersion())));
		assertThat(submission2.tokenListToString(), is(equalTo(tokenString)));
		assertThat(submission2.hashCode(), is(equalTo(submission.hashCode())));
		assertThat(submission2.toString(), is(equalTo(submission.toString())));
		assertTrue(submission2.equals(submission));
		
		Submission submission3 = new Submission();
		
		assertThat(submission3.hashCode(), not(equalTo(submission2.hashCode())));
		assertThat(submission3.toString(), not(equalTo(submission2.toString())));
		assertFalse(submission3.equals(submission2));
	}

	@Test
	public void testSubmissionNonDefualt() throws IOException 
	{
		File file = new File("TestDirectory/bob/");
		
		String pathName = "TestDirectory/bob/";
		
		Submission submission = new Submission(pathName);
		
		submission.parseSubmission(pathName);
		submission.findFiles(file);
		submission.tokenizeFiles();
		String tokenString = submission.tokenListToString();
		submission.calculateLinesOfCode();
		
		assertThat(submission.getNumberOfFiles(), is(equalTo(1)));
		assertThat(submission.getPath(), is(equalTo("TestDirectory/bob/")));
		assertThat(submission.getSubmissionLOC(), is(equalTo(4)));
		assertThat(submission.getSubmissionName(), is(equalTo("TestDirectory/bob/")));
		assertThat(submission.getTokenListSize(), not(equalTo(0)));
		assertThat(submission.getTokenString().size(), not(equalTo(0)));
		assertThat(submission.getVersion(), is(equalTo(-1)));
		
		Submission submission2 = (Submission) submission.clone();
		
		assertThat(submission2.getNumberOfFiles(), is(equalTo(submission.getNumberOfFiles())));
		assertThat(submission2.getPath(), is(equalTo(submission.getPath())));
		assertThat(submission2.getSubmissionLOC(), is(equalTo(submission.getSubmissionLOC())));
		assertThat(submission2.getSubmissionName(), is(equalTo(submission.getSubmissionName())));
		assertThat(submission2.getTokenListSize(), is(equalTo(submission.getTokenListSize())));
		assertThat(submission2.getTokenString().size(), is(equalTo(submission.getTokenString().size())));
		assertThat(submission2.getVersion(), is(equalTo(submission.getVersion())));
		assertThat(submission2.tokenListToString(), is(equalTo(tokenString)));
		assertThat(submission2.hashCode(), is(equalTo(submission.hashCode())));
		assertThat(submission2.toString(), is(equalTo(submission.toString())));
		assertTrue(submission2.equals(submission));
		
		Submission submission3 = new Submission();
		
		assertThat(submission3.hashCode(), not(equalTo(submission2.hashCode())));
		assertThat(submission3.toString(), not(equalTo(submission2.toString())));
		assertFalse(submission3.equals(submission2));
	}
}
