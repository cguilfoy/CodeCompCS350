package edu.odu.cs.cs350;

import java.util.ArrayList;

/**
 * 
 * Student class to hold the student and the files submitted in the studen't directory accounting for multiple versions
 *
 */

public class Student 
{
	private String studentName;
	private ArrayList<Submission> submissionList = new ArrayList<Submission>();
	private Submission finalSubmission = new Submission();
	
	/**
	 * Default Constructor
	 */
	public Student()
	{
		studentName = "";
		ArrayList<Submission> submissionList = new ArrayList<Submission>();
	}
	
	/**
	 * 
	 * @param studentName
	 */
	public Student(String studentName)
	{
		this.studentName = studentName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getStudentName()
	{
		return studentName;
	}
	
	/**
	 * 
	 * @param newStudentName
	 */
	public void setStudentName(String newStudentName)
	{
		studentName = newStudentName;
	}
	
	/**
	 * 
	 * @param newSubmission
	 */
	public void addSubmission(Submission newSubmission)
	{
		submissionList.add(newSubmission);
	}
	
	/**
	 * 
	 * @return
	 */
	public Submission getFinalSubmission()
	{
		return this.finalSubmission;
	}
	
	/**
	 * Parses student submissions comparing the version number, setting the highest as the studen't final submission
	 */
	public void findFinalSubmission()
	{
		int highestSubmissionIndex = 0;
		int currentHighestSubmission = 0;
		
		for (int i = 0; i < submissionList.size(); i++)
		{
			if (submissionList.get(i).getVersion() == -1)
			{
				highestSubmissionIndex = i;
				finalSubmission = (Submission) submissionList.get(i).clone();
				return;
			}
			else
			{
				if (submissionList.get(i).getVersion() > currentHighestSubmission)
				{
					currentHighestSubmission = submissionList.get(i).getVersion();
					highestSubmissionIndex = i;
				}
			}
		}
		
		finalSubmission = (Submission) submissionList.get(highestSubmissionIndex).clone();
	}
	
	/**
	 * 
	 */
	public boolean equals(Object obj) 
	{
	    if (obj instanceof Student) 
	    {
	    	Student stu = (Student) obj;
	    	
	    	return studentName.equals(stu.studentName);
	    } 
	    else 
	    {
	    	return false;
	    }
	}
	
	/**
	 * 
	 */
	public int hashCode() {
		return studentName.hashCode();
	}
	
	/**
	 * 
	 */
	public Object clone() {
		Student clone = new Student(studentName);
		
		clone.studentName = this.studentName;
		
		clone.finalSubmission = (Submission) this.finalSubmission.clone();
		
		for (int i = 0; i < this.submissionList.size(); i++)
		{
			Submission newSub = new Submission();
			newSub = (Submission) this.submissionList.get(i).clone();
			clone.submissionList.add(newSub);
		}
		
		return clone; 
	}
	
	/**
	 * 
	 */
	public String toString()
	{	
		String toString = String.format("%-16s%-10s%-10s\n", studentName, "Files: " + 
				finalSubmission.getNumberOfFiles(), "LOC: " + finalSubmission.getSubmissionLOC());
		
		return toString;
	}
}
