package edu.odu.cs.cs350;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Submission class containing submissions, their path, and their version
 *
 */
public class Submission 
{
	private int submissionVersion;
	private int submissionLinesOfCode;
	private String submissionName;
	private String submissionPath;
	private ArrayList<String> tokenString = new ArrayList<String>();
	private ArrayList<SourceFile> sourceList = new ArrayList<SourceFile>();
	private List<Token> tokenList = new LinkedList<Token>();
	
	/**
	 * Default Constructor
	 */
	public Submission()
	{
		submissionVersion = 0;
		submissionLinesOfCode = 0;
		submissionName = "";
		submissionPath = "";
	}
	
	/**
	 * 
	 * @param submissionDirectory sets the path for the directory of the submission
	 */
	public Submission(String submissionDirectory)
	{
		submissionVersion = 0;
		submissionLinesOfCode = 0;
		submissionName = "";
		submissionPath = submissionDirectory;
	}
	
	/**
	 * 
	 * @return returns the name of the submission
	 */
	public String getSubmissionName()
	{
		return submissionName;
	}
	
	/**
	 * 
	 * @param newSubmissionName setter for the name of a submission
	 */
	public void setSubmissionName(String newSubmissionName)
	{
		submissionName = newSubmissionName;
	}
	
	/**
	 * 
	 * @return returns the version of the submission for later version comparisons
	 */
	public int getVersion()
	{	
		return submissionVersion;
	}
	
	/**
	 *
	 * @param newVersion setter for the version
	 */
	public void setVersion(int newVersion)
	{
		submissionVersion = newVersion;
	}
	
	/**
	 * 
	 * @return returns the path for a given submission
	 */
	public String getPath()
	{
		return submissionPath;
	}
	
	/**
	 * 
	 * @param newPath setter for the path to a given submission
	 */
	public void setPath(String newPath)
	{
		submissionPath = newPath;
	}
	
	/**
	 * 
	 * @return returns the token string of the arraylist
	 */
	public ArrayList<String> getTokenString()
	{
		return tokenString;
	}
	
	/**
	 * 
	 * @return returns the number of lines of a submission
	 */
	public int getSubmissionLOC()
	{
		return submissionLinesOfCode;
	}
	
	/**
	 * 
	 * @return returns the number of files
	 */
	public int getNumberOfFiles()
	{
		return sourceList.size();
	}
	
	/**
	 * 
	 * @return returns the number of tokens that have been found
	 */
	public int getTokenListSize()
	{
		return tokenList.size();
	}
	
	/**
	 * Parses and extracts the student's name and version number from a submission
	 * @param pathName path of the submission
	 */
	public void parseSubmission(String pathName)
	{
		String versionString = "";
		String newStudentName = "";
		int versionNumber = 0;
		
		if (pathName.contains("."))
		{
			versionString = pathName.substring(pathName.lastIndexOf(".") + 1);
			newStudentName = pathName.substring(0, pathName.lastIndexOf("."));
			versionNumber = Integer.parseInt(versionString);
		}
		else
		{
			newStudentName = pathName;
			versionNumber = -1;
		}
		
		submissionVersion = versionNumber;
		submissionName = newStudentName;
		submissionPath = pathName;
	}
	
	/**
	 * Adds source files to a list
	 * @param file submission file to be added to the sourceList
	 * 
	 */
	public void findFiles(File file) throws IOException
	{	
		File[] fileList = file.listFiles();
		
		if(fileList != null)
		{
			for (File fil : fileList)
			{
				if (fil.isDirectory())
				{
					findFiles(fil);
				}
				else if(fil.isFile())
				{
					sourceList.add(new SourceFile(fil));
				}
			}
		}
	}
	
	/**
	 * Method will read in a token stream, split the tokens by line, and 
	 * create a list of lines of tokens to be inputting into the tree
	 * as sentences belonging to students for comparison later.
	 * @throws FileNotFoundException
	 */
	public void tokenizeFiles() throws FileNotFoundException
	{	
		for (int i = 0; i < sourceList.size(); i++)
		{	
			BufferedReader reader = new BufferedReader(new FileReader(sourceList.get(i).getSourceFile()));
			TokenStream newStream = new TokenStream(reader, sourceList.get(i).getFileExt());
			String streamList[] = new String[newStream.getStream().get(newStream.getStream().size()-1).getLineNumber()+1];
			
			for (int k = 0; k < streamList.length; k++)
			{
				streamList[k] = "";
			}
			
			for (int j = 0; j < newStream.getStream().size(); j++)
			{
				if (!newStream.getStream().get(j).getTokenValue().equals("null"))
				{	
					streamList[newStream.getStream().get(j).getLineNumber()] += newStream.getStream().get(j).getTokenValue();
				}
			}
			
			tokenList.addAll(newStream.getStream());
			List<String> newList = Arrays.asList(streamList);
			tokenString.addAll(newList);
		}
	}
	
	/**
	 * Turns the list of tokens into a list of char codes
	 * @return
	 */
	public String tokenListToString()
	{
		StringBuffer buffer = new StringBuffer();
		
		for (int i = 0; i < tokenString.size(); i++)
		{
			buffer.append(tokenString.get(i));
		}
		
		return buffer.toString();
	}
	
	/**
	 * Counts the number of lines of code for output later
	 */
	public void calculateLinesOfCode()
	{
		for (int i = 0; i < sourceList.size(); i++)
		{
			submissionLinesOfCode += sourceList.get(i).getLineCount();
		}
	}
	
	/**
	 * Clone Method
	 */
	public Object clone() 
	{
		Submission subClone = new Submission();
		
		subClone.submissionName = this.submissionName;
		subClone.submissionVersion = this.submissionVersion;
		subClone.submissionPath = this.submissionPath;
		subClone.submissionLinesOfCode = this.submissionLinesOfCode;
		
		for (int i = 0; i < tokenString.size(); i++)
		{
			String tokenStr;
			tokenStr = tokenString.get(i);
			subClone.tokenString.add(tokenStr);
		}
		
		for (int i = 0; i < sourceList.size(); i++)
		{
			SourceFile newFile = new SourceFile();
			newFile = (SourceFile) this.sourceList.get(i).Clone();
			subClone.sourceList.add(newFile);
		}
		
		for (int i = 0; i < tokenList.size(); i++)
		{
			Token newToken = new Token();
			newToken = (Token) this.tokenList.get(i).clone();
			subClone.tokenList.add(newToken);
		}
		
		return subClone; 
	}
	
	/**
	 * Equality method, uses submission name as a test
	 */
	public boolean equals(Object obj) 
	{
		if((obj instanceof Submission)) 
		{
			Submission sub = (Submission)obj;
			
			return submissionName.equals(sub.submissionName);
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * hashCode method
	 */
	public int hashCode() 
	{
		return submissionName.hashCode();
	}
	
	/**
	 * toString method for the submission class
	 */
	public String toString() 
	{
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("Submission Name: " + submissionName + "\n");
		buffer.append("Submission Version: " + submissionVersion + "\n\n");
		buffer.append("Files in Submission: " + sourceList.size() + "\n\n");
		
		for (int i = 0; i < sourceList.size(); i++)
		{
			buffer.append(sourceList.get(i).toString());
		}
		
		return buffer.toString();
	}
}
