package edu.odu.cs.cs350;

/**
 * 
 * Score Class
 * 
 * Used to hold student names and the raw / z scores that are
 * associated with those 2 students code.
 *
 */
public class Score 
{
	private String student1;
	private String student2;
	private double rawScore;
	private double zScore;
	
	/**
	 * Default Constructor
	 */
	public Score()
	{
		student1 = "";
		student2 = "";
		rawScore = 0;
		zScore = 0;
	}
	
	/**
	 * Constructor that takes 2 students, the resulting raw and z scores as parameters
	 * @param s1
	 * @param s2
	 * @param rScore
	 * @param zScore2
	 */
	public Score(String s1, String s2, double rScore, double zScore2)
	{
		student1 = s1;
		student2 = s2;
		rawScore = rScore;
		zScore = zScore2;
	}
	
	/**
	 * Method to set the value of student 1
	 * @param s1
	 */
	public void setStudent1(String s1)
	{
		student1 = s1;
	}
	
	/**
	 * Method to return the value of student 1
	 * @return
	 */
	public String getStudent1()
	{
		return student1;
	}
	
	/**
	 * Method to set the value of student 2
	 * @param s2
	 */
	public void setStudent2(String s2)
	{
		student2 = s2;
	}
	
	/**
	 * Method to return the value of student 2
	 * @return
	 */
	public String getStudent2()
	{
		return student2;
	}
	
	/**
	 * Method to set the value of the raw score
	 * @param rScore
	 */
	public void setRawScore(double rScore)
	{
		rawScore = rScore;
	}
	
	/**
	 * Method to return the value of raw score
	 * @return
	 */
	public double getRawScore()
	{
		return rawScore;
	}
	
	/**
	 * Method to set the value of the z score
	 * @param newZScore
	 */
	public void setZScore(double newZScore)
	{
		zScore = newZScore;
	}
	
	/**
	 * Method to return the value of the z score
	 * @return
	 */
	public double getZScore()
	{
		return zScore;
	}
	
	/**
	 * Cloning method
	 */
	public Object clone()
	{
		Score newScore = new Score();
		
		newScore.student1 = student1;
		newScore.student2 = student2;
		newScore.rawScore = rawScore;
		newScore.zScore = zScore;
		
		return newScore;
	}
	
	/**
	 * equals method, uses the student names to determine equality
	 */
	public boolean equals(Object obj) 
	{
	    if (obj instanceof Score) 
	    {
	    	Score newScore = (Score) obj;
	    	
	    	return (student1.equals(newScore.student1) && student2.equals(newScore.student2));
	    } 
	    else 
	    {
	    	return false;
	    }
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("Student 1: " + student1 + " Student 2: " + student2 + 
				" Raw Score: " + rawScore + " zScore: " + zScore);
		
		return buffer.toString();
	}
	
	/**
	 * Hash method
	 */
	public int hashCode()
	{
		return (student1.hashCode() + student2.hashCode());
	}
}
