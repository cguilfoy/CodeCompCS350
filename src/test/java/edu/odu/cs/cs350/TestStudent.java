package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class TestStudent {

	String defaultStudent = "Sam"; 
	Student empty = new Student();
	
	
	@Test
	public void testStudentConstructorDefault() 
	{
		Student student = new Student();
		Student emptyStudent = new Student();
		
		assertThat (student.getStudentName(), is(""));
		assertThat (student.getStudentName(), is(not(defaultStudent)) );
		
		assertEquals (student, emptyStudent);
		assertEquals (student.hashCode(), emptyStudent.hashCode());
		assertEquals (student.toString(), emptyStudent.toString());
	}
	
	
	@Test
	public void testStudentConstructorNonDefault()
	{
	
		 Student student = new Student();
		 student.setStudentName(defaultStudent);
		 
		 assertThat (student.getStudentName(), is("Sam"));
		 assertThat (student.getStudentName(), is(defaultStudent) );
		  
		 assertThat (student.getStudentName(), is(not("")) );
		 assertThat(student, is(not(empty)));
		 
		 String studStr = student.toString();
		 
		 assertTrue(studStr.contains(defaultStudent));
		 assertTrue(studStr.contains("Sam"));
	}
	
	
	@Test
	public void testSetStudentName()
	{
		Student student = new Student();
		
		student.setStudentName("Jake");
		assertThat (student.getStudentName(), is("Jake"));
		
		assertThat (student.getStudentName(), is(not("")) );
		assertThat(student, is(not(empty)));
		
		String studStr = student.toString();
		 
		assertTrue(studStr.contains("Jake"));
	}
	
	@Test
	public void testAddSubmission()
	{
		Submission sub1 = new Submission("sam01");
		Submission sub2 = new Submission("sam02");
		Submission sub3 = new Submission("sam03");
		
		ArrayList<Submission> subList = new ArrayList<Submission>();
	
		int oldHashCode = subList.hashCode();
		
		subList.add(sub1);
		
		assertThat(subList.hashCode(), not(equalTo(oldHashCode)));
		
		subList.add(sub2);
		subList.add(sub3);
		
		String subListStr = subList.toString();
		
		assertTrue(subListStr.contains("sam01"));
		assertTrue(subListStr.contains("sam02"));
		assertTrue(subListStr.contains("sam03"));
		
		
	}

}
