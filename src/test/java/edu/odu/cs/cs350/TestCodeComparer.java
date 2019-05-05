package edu.odu.cs.cs350;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import edu.odu.cs.cs350.codeCompCommon.SharedPhrases;
import static org.hamcrest.CoreMatchers.*;

public class TestCodeComparer {
	
	ArrayList<Student> studentList = new ArrayList<Student>();
	SharedPhrases wordsOfWisdom = new SharedPhrases();
	
	Student sam = new Student("Sam");
	Student john = new Student("John");
	
	@Before
	public void setUp()
	{
		studentList.add(sam);
		studentList.add(john);
		
		wordsOfWisdom.addSentence("aabbecdaeapdggg", "Sam");
		wordsOfWisdom.addSentence("aabbecddmcpehbg", "John");
	}

	@Test
	public void testCodeComparer() 
	{
		CodeComparer newCodeComp = new CodeComparer();
		SharedPhrases somePhrases = new SharedPhrases();
		
		somePhrases.addSentence("I'll have the steak", "John");
		somePhrases.addSentence("I'll have the fish", "Bob");
		
		assertThat(newCodeComp.getAverage(), is(equalTo(0.0)));
		assertThat(newCodeComp.getStandardDev(), is(equalTo(0.0)));
		assertThat(newCodeComp.getTotalScore(), is(equalTo(0.0)));
		
		int hash = newCodeComp.hashCode();
		
		newCodeComp.setAverage(2.4);
		newCodeComp.setStandardDev(3.5);
		newCodeComp.setTotalScore(4.7);
		newCodeComp.setSharedPhrases(somePhrases);
		
		assertThat(newCodeComp.getAverage(), is(equalTo(2.4)));
		assertThat(newCodeComp.getStandardDev(), is(equalTo(3.5)));
		assertThat(newCodeComp.getTotalScore(), is(equalTo(4.7)));
		
		assertThat(newCodeComp.hashCode(), not(equalTo(hash)));
		
		CodeComparer codeComp2 = new CodeComparer();
		
		assertThat(newCodeComp, not(equalTo(codeComp2)));
		
		codeComp2 = (CodeComparer) newCodeComp.clone();
		
		assertThat(newCodeComp.getAverage(), is(equalTo(codeComp2.getAverage())));
		assertThat(newCodeComp.getStandardDev(), is(equalTo(codeComp2.getStandardDev())));
		assertThat(newCodeComp.getTotalScore(), is(equalTo(codeComp2.getTotalScore())));
		
		assertThat(newCodeComp.hashCode(), is(equalTo(codeComp2.hashCode())));
		assertThat(newCodeComp, is(equalTo(codeComp2)));
		
		assertThat(codeComp2.toString(), containsString("2.4"));
	}

	@Test
	public void testCodeComparerArrayListOfStudent() 
	{
		CodeComparer codeComp = new CodeComparer(studentList);
		CodeComparer otherCodeComp = new CodeComparer();
		
		codeComp.setSharedPhrases(wordsOfWisdom);
		
		assertThat(codeComp.hashCode(), not(equalTo(otherCodeComp.hashCode())));
		assertThat(codeComp.toString(), not(equalTo(otherCodeComp.toString())));
		assertThat(codeComp, not(equalTo(otherCodeComp)));
		
		CodeComparer codeComp2 = (CodeComparer) codeComp.clone();
		
		assertThat(codeComp.hashCode(), is(equalTo(codeComp2.hashCode())));
		assertThat(codeComp, is(equalTo(codeComp2)));
		assertThat(codeComp.getScoreList().size(), is(equalTo(codeComp2.getScoreList().size())));
		assertThat(codeComp.getSharedPhrases(), is(equalTo(codeComp2.getSharedPhrases())));
	}

	@Test
	public void testScoreStudents() throws IOException 
	{
		CodeComparer codeComp = new CodeComparer();
		
		String directoryPath = "TestDirectory";
		String outputPath = "";
		String sheetName = "Report.xls";
		String templateName = "";
		
		Assignment assignment = new Assignment(directoryPath);
		
		assertThat(assignment.getAssignmentDirectory(), is(equalTo(directoryPath)));
		
		try 
		{
			assignment.findStudents(directoryPath);
		} 
		catch (IOException e) 
		{
			
		}
		
		assertThat(assignment.getStudents().size(), equalTo(11));
		
		codeComp = assignment.generateComparisons();
		
		Spreadsheet newSheet = new Spreadsheet();
		
		newSheet.outputExcel(codeComp.scoreList, outputPath + sheetName, templateName);
		
		
	}

}
