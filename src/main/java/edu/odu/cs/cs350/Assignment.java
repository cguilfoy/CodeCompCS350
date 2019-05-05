package edu.odu.cs.cs350;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * Assignment class that handles the supplied directory where student directories and source files reside.
 *
 */
public class Assignment 
{
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private String assignmentDirectory;
	
	/**
	 * Default Constructor
	 */
	public Assignment()
	{
		assignmentDirectory = "";
	}
	
	/**
	 * Constructor that takes a root directory as a String
	 * @param newRootDirectory
	 */
	public Assignment(String newRootDirectory)
	{
		assignmentDirectory = newRootDirectory;
	}
	
	/**
	 * Adds a new Student object to studentList
	 * @param newStudent
	 */
	public void addStudent(Student newStudent)
	{
		studentList.add(newStudent);
	}
	
	/**
	 * Returns an ArrayList of students
	 * @return studentList
	 */
	public ArrayList<Student> getStudents()
	{
		return studentList;
	}
	
	/**
	 * 
	 * @param directory
	 */
	public void setAssignmentDirectory(String directory)
	{
		assignmentDirectory = directory;
	}
	
	/**
	 * 
	 * @return assignmentDirectory
	 */
	public String getAssignmentDirectory()
	{
		return assignmentDirectory;
	}
	
	/**
	 * This method takes a rootDirectoryName as a parameter, and from that root
	 * directory saves the first directory layer as the Student names. It then goes further
	 * into that directory, and looks for files. When it finds files, it saves them to a new
	 * instance of submission, tokenizes the files, and assigns that submission to a student.
	 * It will then figure out which submission is the one that shall be graded, and mark it as so.
	 * @param rootDirectoryName directory to be parsed for student directories and source files
	 * @throws IOException handles invalid directory paths
	 */
	public void findStudents(String rootDirectoryName) throws IOException
	{
		File rootDirectory = new File(rootDirectoryName);
		
		File[]rootDirectoryList = rootDirectory.listFiles(new FileFilter()
				{
					public boolean accept(File pathname)
					{
						return pathname.isDirectory();
					}
				});
		
		for (int i = 0; i < rootDirectoryList.length; i++)
		{
			String studentDirectoryName = rootDirectoryList[i].getName();
			Submission newSubmission = new Submission(studentDirectoryName);
			Student newStudent = new Student();
			
			newSubmission.parseSubmission(studentDirectoryName);
			newSubmission.findFiles(rootDirectoryList[i]);
			newSubmission.tokenizeFiles();
			newSubmission.calculateLinesOfCode();
			newStudent.setStudentName(newSubmission.getSubmissionName());
			
			for (int j = 0; j < studentList.size(); j++)
			{
				if (studentList.get(j).getStudentName().equals(newStudent.getStudentName()))
				{
					studentList.get(j).addSubmission(newSubmission);
					break;
				}
			}
			
			
			if (!studentList.contains(newStudent))
			{
				studentList.add(newStudent);
				newStudent.addSubmission(newSubmission);
			}
		}
		
		for (int i = 0; i < studentList.size(); i++)
		{
			studentList.get(i).findFinalSubmission();
		}
	}
	
	/**
	 * Initializes a new CodeComparer object. That object will
	 * take the studentList, build the tree of shared code, 
	 * and analyze the scores. The method then returns that object
	 * for later writing to a spreadsheet.
	 * @return
	 */
	public CodeComparer generateComparisons()
	{
		CodeComparer codeComp = new CodeComparer(studentList);
		
		codeComp.scoreStudents();
		
		return codeComp;
	}
	
	/**
	 * Clone method
	 */
	public Object clone()
	{
		Assignment newAssignment = new Assignment();
		
		newAssignment.assignmentDirectory = assignmentDirectory;
		
		for (int i = 0; i < studentList.size(); i++)
		{
			Student stu = new Student();
			stu = (Student) studentList.get(i).clone();
			newAssignment.studentList.add(stu);
		}
		
		return newAssignment;
	}
	
	/**
	 * Equals method
	 */
	public boolean equals (Object obj)
	{
		if (obj instanceof Assignment) 
	    {
	    	Assignment assign = (Assignment) obj;
	    	
	    	return assignmentDirectory.equals(assign.assignmentDirectory);
	    } 
	    else 
	    {
	    	return false;
	    }
	}
	
	/**
	 * Hash method
	 */
	public int hashCode ()
	{
		return assignmentDirectory.hashCode();
	}
	
	/**
	 * toString() method
	 */
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("Assignment Directory: " + assignmentDirectory + ".\n\n");
		
		for (int i = 0; i < studentList.size(); i++)
		{
			buffer.append(studentList.get(i).toString());
		}
		
		return buffer.toString();
	}
}
