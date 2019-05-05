package edu.odu.cs.cs350;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * SourceFile class to contain the title of the file, the number of lines in the file, and the file's extension
 * 
 */

public class SourceFile {
	private String fileTitle;
	private int linesOfCode;
	private String fileExt;
	private File sourceFile;
	
	/**
	 * Default Constructor
	 */
	public SourceFile() 
	{	
		fileTitle = "";
		linesOfCode = 0;
		fileExt = "";
		sourceFile = null;
	}
	
	/**
	 * Constructor that takes a file name, number of lines of code, and a file extension
	 * as a parameter
	 * @param titleString
	 * @param linesCode
	 * @param fileExten
	 */
	public SourceFile(String titleString, int linesCode, String fileExten) {
		this.fileTitle = titleString;
		this.linesOfCode = linesCode;
		this.fileExt = fileExten;
	}
	/**
	 * 
	 * @param file file to be processed, extracting the extension after the "." and the title as what comes before the "."
	 * @throws IOException if problem occurs with the supplied file
	 */
	public SourceFile(File file) throws IOException
	{
		sourceFile = file;
		String filePath = sourceFile.getName();
		
		fileExt = filePath.substring(filePath.lastIndexOf(".") + 1);
		fileTitle = filePath.substring(0, filePath.lastIndexOf("."));
		
		BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
		int lineCount = 0;
		while (reader.readLine() != null) {
			lineCount++;
		}
		reader.close();
		
		linesOfCode = lineCount;
	}
	
	/**
	 * 
	 * @return String containing file name
	 */
	public String getFileTitle() {
		return fileTitle;
	}
	
	/**
	 * 
	 * @return integer containing number of lines of code
	 */
	public int getLineCount() {
		return linesOfCode;
	}
	
	/**
	 * 
	 * @return String containing file extension
	 */
	public String getFileExt() {
		return fileExt;
	}
	
	/**
	 * 
	 * @param newTitle
	 */
	public void setFileTitle(String newTitle)
	{
		fileTitle = newTitle;
	}
	
	/**
	 * 
	 * @param newLength
	 */
	public void setFileLength(int newLength)
	{
		linesOfCode = newLength;
	}
	
	/**
	 * 
	 * @param newLang
	 */
	public void setFileExt(String newLang)
	{
		fileExt = newLang;
	}
	
	/**
	 * 
	 * @param newFile
	 */
	public void setSourceFile(File newFile)
	{
		sourceFile = newFile;
	}
	
	/**
	 * 
	 * @return sourceFile File object
	 */
	public File getSourceFile()
	{
		return sourceFile;
	}
	
	/**
	 * Extracts information from a supplied path, taking a string composed of what occurs after the last file separator, "/" or "\", up to the "."
	 * @param pathName file path for the source file having its information extracted
	 * @throws IOException handles problems with file path
	 */
	public void setFile(String pathName) throws IOException {
		
		String titleString = pathName.substring(pathName.lastIndexOf(File.separator)+1, pathName.lastIndexOf(".")); // file structure \...\student1\foo.cpp
		String fileExt = pathName.substring(pathName.lastIndexOf(".")+1);	
		
		BufferedReader reader = new BufferedReader(new FileReader(pathName));
		int lineCount = 0;
		while (reader.readLine() != null) {
			lineCount++;
		}
		reader.close();
		
		this.setFileTitle(titleString);
		this.setFileLength(lineCount);
		this.setFileExt(fileExt);			
	}
	
	/**
	 * 
	 * @return newFile object
	 */
	public Object Clone()
	{
		SourceFile newFile = new SourceFile();
		
		newFile.fileExt = this.fileExt;
		newFile.fileTitle = this.fileTitle;
		newFile.linesOfCode = this.linesOfCode;
		
		return newFile;
	}
	
	/**
	 * @return toString
	 */
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("Name of File: " + fileTitle + "\n");
		buffer.append("Extension of File: " + fileExt + "\n");
		buffer.append("Lines of Code: " + linesOfCode + "\n\n");
		
		return buffer.toString();
	}
	
	/**
	 * Equals method
	 */
	public boolean equals(Object obj)
	{
		if (obj instanceof SourceFile)
		{
			SourceFile newSorc = (SourceFile) obj;
			
			return fileTitle.equals(newSorc.fileTitle);
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
		return fileTitle.hashCode();
	}
}
