package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class TestAssignment
{
	String directory = "TestDirectory";
	
	@Test
	public void testDefaultConstructor()
	{
		Assignment assignment = new Assignment();
		
		assertThat(assignment.getAssignmentDirectory(), is(equalTo("")));
		assertThat(assignment.getStudents().size(), is(equalTo(0)));
		
		int hash = assignment.hashCode();
		assertThat(assignment.hashCode(), is(equalTo(hash)));
		
		assignment.setAssignmentDirectory("TestDirectory");
		
		assertThat(assignment.getAssignmentDirectory(), is(equalTo("TestDirectory")));
		assertThat(assignment.hashCode(), not(equalTo(hash)));
		assertThat(assignment.toString(), containsString("TestDirectory"));
		
		Assignment assignment2 = new Assignment();
		
		assertThat(assignment, not(equalTo(assignment2)));
		assertThat(assignment.hashCode(), not(equalTo(assignment2.hashCode())));
		assertThat(assignment.toString(), not(equalTo(assignment2.toString())));
	}
	
	@Test
	public void testDirectoryConstructor()
	{
		Assignment assignment = new Assignment(directory);
		
		assertThat(assignment.getAssignmentDirectory(), is(equalTo("TestDirectory")));
		
		Assignment assignment2 = new Assignment();
		
		assertThat(assignment, not(equalTo(assignment2)));
		assertThat(assignment.hashCode(), not(equalTo(assignment2.hashCode())));
		assertThat(assignment.toString(), not(equalTo(assignment2.toString())));
	}
	
	@Test
	public void testFindStudents() throws IOException
	{
		Assignment assignment = new Assignment(directory);
		
		assertThat(assignment.getAssignmentDirectory(), is(equalTo("TestDirectory")));
		
		Assignment assignment2 = new Assignment();
		
		assertThat(assignment, not(equalTo(assignment2)));
		assertThat(assignment.hashCode(), not(equalTo(assignment2.hashCode())));
		assertThat(assignment.toString(), not(equalTo(assignment2.toString())));
		
		assignment.findStudents(directory);
		
		assertThat(assignment.getStudents().size(), not(equalTo(0)));
		assertThat(assignment.toString(), containsString(assignment.getStudents().get(0).getStudentName()));
		
		Assignment assignment3 = (Assignment) assignment.clone();
		
		assertThat(assignment3.hashCode(), is(equalTo(assignment.hashCode())));
		assertThat(assignment3.toString(), is(equalTo(assignment.toString())));
		assertThat(assignment3, is(equalTo(assignment)));
		assertThat(assignment3, not(equalTo(assignment2)));
	}
	
	@Test
	public void testGenerateComparisons() throws IOException
	{
		Assignment assignment = new Assignment(directory);
		
		assertThat(assignment.getAssignmentDirectory(), is(equalTo("TestDirectory")));
		
		Assignment assignment2 = new Assignment();
		
		assertThat(assignment, not(equalTo(assignment2)));
		assertThat(assignment.hashCode(), not(equalTo(assignment2.hashCode())));
		assertThat(assignment.toString(), not(equalTo(assignment2.toString())));
		
		assignment.findStudents(directory);
		
		CodeComparer codeComparer = new CodeComparer();
		
		codeComparer = assignment.generateComparisons();
		
		assertThat(codeComparer.getAverage(), not(equalTo(0)));
		assertThat(codeComparer.getStandardDev(), not(equalTo(0)));
		assertThat(codeComparer.getTotalScore(), not(equalTo(0)));
		assertThat(codeComparer.getScoreList().size(), not(equalTo(0)));
	}
	
	@Test
	public void testEmptyStudentList() throws IOException 
	{
		ArrayList<Student> newStudentList = new ArrayList<Student>();
		
		assertTrue (newStudentList.isEmpty());
	}
	
	@Test
	public void testAddStudent() throws IOException 
	{
		Student student1 = new Student();
		Student student2 = new Student();
		String testDirectory = "";				
		Assignment newAssignment1 = new Assignment(testDirectory);		
		
		newAssignment1.addStudent(student1);
		newAssignment1.addStudent(student2);		
		ArrayList<Student> newStudentList1 = newAssignment1.getStudents();		
		
		assertThat (newStudentList1.size(), is(equalTo(2)));
	}

}
