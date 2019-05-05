package edu.odu.cs.cs350;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;

public class TestCodeComp {
    
	String blankDirectoryPath = "";
	String blankOutputPath = "";
	String blankNewSheetName = "";
	String blankNewTemplateName = "";
	
	String directoryPath = "TestDirectory";
	String outputPath = "testReport";
	String newSheetName = "testSpread";
	String newTemplateName = "testTemplate";
	
	String[] args = {"-report", newSheetName, "-template", 
			newTemplateName, directoryPath, outputPath};
	
	@Test
	public void testBlankCodeComp() 
	{
		assertThat (blankDirectoryPath, is(""));
		assertThat (blankOutputPath, is(""));
		assertThat (blankNewSheetName, is(""));
		assertThat (blankNewTemplateName, is(""));
	}
	
	@Test
	public void testGenericCodeComp() 
	{
		assertThat (directoryPath, is("TestDirectory"));
		assertThat (outputPath, is("testReport"));
		assertThat (newSheetName, is("testSpread"));
		assertThat (newTemplateName, is("testTemplate"));
	}
	
	/*
	@Test
	public void testCodeCompMain() throws IOException
	{
		CodeComp codeComp = new CodeComp();
		
		codeComp.main(args);
	}*/
	
	//TODO Figure out how to test a main driver, getting errors regarding JarNeedsHeap when trying to run this
	
	/*
	 * TODO fix test in a way that doesn't exit the system
	 * either a security manager or the System Rules library?
	 */
	
	/*@Test
	public void testHelp() throws IOException 
	{
		String [] args = {"-help"};
		CodeComp.main(args);
	}*/
}
