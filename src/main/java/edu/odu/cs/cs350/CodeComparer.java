package edu.odu.cs.cs350;

import java.util.ArrayList;

import edu.odu.cs.cs350.codeCompCommon.*;

/**
 * 
 * CodeComparer Class
 *
 */
public class CodeComparer 
{
	private SharedPhrases codeComp = new SharedPhrases();
	
	private double totalScore;
	private double average;
	private double standardDev;
	ArrayList<Score> scoreList = new ArrayList<Score>();
	
	/**
	 * Default Constructor
	 */
	public CodeComparer()
	{
		totalScore = 0;
		average = 0;
		standardDev = 0;
	}
	
	/**
	 * Constructor that takes a list of students as input
	 * @param studentList
	 */
	public CodeComparer(ArrayList<Student> studentList)
	{
		//Construction of the initial tree consisting of all code from all students
		//****************************************************************************
		for (int i = 0; i < studentList.size(); i++)
		{
			for (int j = 0; j < studentList.get(i).getFinalSubmission().getTokenString().size(); j++)
			{
				codeComp.addSentence(studentList.get(i).getFinalSubmission().getTokenString().get(j), studentList.get(i).getStudentName());
			}
		}
		
		//****************************************************************************
		
		System.out.println("Now Analyzing Student Work. Please wait...\n");
		
		// This section will search the tree N * (N - 1) / 2 times comparing sets of students for similarities
		// in their code. It will keep track of the scoring and at the end computer the average and standard deviations.
		// It also creates a new Score object and stores student data and raw scores in a list for later use.
		//****************************************************************************
		
		for (int i = 0; i < studentList.size(); i++)
		{
			for (int j = 0; j < studentList.size(); j++)
			{
				if (j >= i && !(j == i))
				{
					for (CharSequence p: codeComp.allPhrases())
					{
						if (codeComp.sourcesOf((String) p).contains(studentList.get(i).getStudentName()) && 
								codeComp.sourcesOf((String) p).contains(studentList.get(j).getStudentName()))
						{
							totalScore += ((p.length()) / Math.pow((codeComp.sourcesOf((String) p).size()-1), 2));
						}
					}
					
					totalScore = (4*totalScore) / Math.pow((studentList.get(i).getFinalSubmission().getTokenListSize() + 
							studentList.get(j).getFinalSubmission().getTokenListSize()), 2);
					
					Score newScore = new Score(studentList.get(i).getStudentName(), studentList.get(j).getStudentName(), 
							totalScore, 0);
					
					scoreList.add(newScore);
					
					average = average + totalScore;
					
					//System.out.println("Score for Students " + studentList.get(i).getStudentName() + 
					//		" and " + studentList.get(j).getStudentName() + " " + totalScore);
				}
			}
		}
		
		//System.out.println();
		
		average = average / ((studentList.size() * (studentList.size() - 1)) / 2);
		
		ArrayList<Double> numList = new ArrayList<Double>();
		double num1 = 0;
		double total = 0;
		
		for (int i = 0; i < scoreList.size(); i++)
		{
			num1 = Math.pow((scoreList.get(i).getRawScore() - average), 2);
			numList.add(num1);
			total = total + num1;
		}
		
		total = total / scoreList.size();
		
		standardDev = Math.sqrt(total);
		
		//****************************************************************************
	}
	
	/**
	 * 
	 * @param newScore
	 */
	public void setTotalScore(double newScore)
	{
		totalScore = newScore;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getTotalScore()
	{
		return totalScore;
	}
	
	/**
	 * 
	 * @param newAverage
	 */
	public void setAverage(double newAverage)
	{
		average = newAverage;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getAverage()
	{
		return average;
	}
	
	/**
	 * 
	 * @param newStdDev
	 */
	public void setStandardDev (double newStdDev)
	{
		standardDev= newStdDev;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getStandardDev()
	{
		return standardDev;
	}
	
	/**
	 * 
	 * @param newPhrases
	 */
	public void setSharedPhrases(SharedPhrases newPhrases)
	{
		codeComp = newPhrases;
	}
	
	/**
	 * 
	 * @return
	 */
	public SharedPhrases getSharedPhrases()
	{
		return codeComp;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Score> getScoreList()
	{
		return scoreList;
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
				
		for (CharSequence p: codeComp.allPhrases())
		{
				buffer.append("Phrase: " + p);
				
				for (String source: codeComp.sourcesOf((String) p))
				{
					buffer.append(" Written by " + source);
				}
			
				buffer.append("\n");
		}
		
		buffer.append("Average: " + average + " TotalScore: " + totalScore + 
				" Standard Deviation: " + standardDev + "\n");
		
		return buffer.toString();		
	}
	
	/**
	 * Method used to get the z score from the raw scores, and insert the z score
	 * into the score list.
	 */
	public void scoreStudents()
	{
		for (int i = 0; i < scoreList.size(); i++)
		{
			scoreList.get(i).setZScore((scoreList.get(i).getRawScore()-average)/standardDev);
			
			/*System.out.println("Student 1: " + scoreList.get(i).getStudent1() + "\n" + 
					"Student 2: " + scoreList.get(i).getStudent2() + "\n" + 
					"Raw Score: " + scoreList.get(i).getRawScore() + "\n" +
					"Z Score: " + scoreList.get(i).getZScore() + "\n");*/
		}
	}
	
	/**
	 * Cloning method
	 */
	public Object clone()
	{
		CodeComparer newComp = new CodeComparer();
		
		newComp.totalScore = totalScore;
		newComp.average = average;
		newComp.standardDev = standardDev;
		newComp.setSharedPhrases(codeComp);
		
		for (int i = 0; i < scoreList.size(); i++)
		{
			Score newScore = new Score();
			newScore = (Score) scoreList.get(i);
			newComp.scoreList.add(newScore);
		}
		
		return newComp;
	}
	
	/**
	 * Equals method
	 */
	public boolean equals(Object obj)
	{
		if (obj instanceof CodeComparer)
		{
			CodeComparer comp = (CodeComparer) obj;
			
			return codeComp.equals(comp.codeComp);
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
		return codeComp.hashCode();
	}
}



