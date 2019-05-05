/* Birthday Guessing Game
 * Written and Coded by Chris Guilfoy
 * 
 * In this game, the computer will generate a random birthday, and its up to the user
 * to guess the correct birthday. Choose carefully, as you only have 5 attempts to
 * get it right!
 * 
 */

import java.util.Random;
import java.util.Scanner;

public class ClassLab2 {

	//Array to hold the months of the year for random generation purposes
	public static String [] birthdayMonth = {"January", "February", "March", "April", "May", 
			"June", "July", "August", "September", "October", "November", "December"};
	
	//Array parallel to the month array representing how many days each month has
	public static int [] birthdayDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	//Variables to hold the randomly generated birthday month and day
	public static String currentBirthdayMonth = "";
	public static int currentBirthdayDay = 0;
	
	//Variables to hold what the users current guess is
	public static String birthdayMonthGuess = "";
	public static int birthdayDayGuess = 0;
	public static int randomNumber;
	
	/* This method will take the birthdayMonth and birthdayDay arrays as
	 * parameters and generate / assign a random birthday to the Variables 
	 * meant to hold them. It also returns the randomly generated int value
	 * for use later in the program as a reference to where the birthday was
	 * chosen.
	 */
	
	public static int generateBirthday(String [] month, int [] day) {
		
		Random rand = new Random();
		int randomNumber = rand.nextInt(12);
		currentBirthdayMonth = month[randomNumber];
		currentBirthdayDay = rand.nextInt(day[randomNumber]);
		
		return randomNumber;
	}
	
	/******************************************************
	 * ****************************************************
	 * ***************************************************/
	 
	
	public static void main(String [] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		randomNumber = generateBirthday(birthdayMonth, birthdayDay);
		
		/* Beginning of the for loop that will allow the user to guess
		 * 5 times before the loop ends. First it checks to see if the 
		 * user actually did guess the correct answer. If not, then it 
		 * will progress and first check to see if the user at least guessed 
		 * the correct month. If the month is correct, the computer will 
		 * let the user know that they got the month correct, but not the day, 
		 * and if the day was too high or low. If they did not guess the 
		 * month correctly, it will tell them if the correct month is lower 
		 * or higher than what they guessed. The loop will then repeat and 
		 * ask the user to enter the month and day again. If they did not 
		 * guess correctly within the 5 attempts, the for loop ends and the 
		 * correct month and day are displayed.
		 */
		
		for (int i = 0; i < 5; i++) {

			System.out.println("Please enter a Month: ");
			birthdayMonthGuess = scnr.next();
			
			System.out.println("Please enter a Day within " + birthdayMonthGuess + ": ");
			birthdayDayGuess = scnr.nextInt();
			
			if (birthdayMonthGuess.equals(currentBirthdayMonth) && birthdayDayGuess == currentBirthdayDay) {
				System.out.println("Congratulations! You won!");
			}
			else {
				if (birthdayMonthGuess.equals(currentBirthdayMonth)) {
					System.out.println("You got the Month right, but not the day...");
					
					if (birthdayDayGuess < currentBirthdayDay && birthdayDayGuess > 0) {
						System.out.println("The day you guessed is too low\n");
					}
					else {
						System.out.println("The day you guessed is too high\n");
					}
				}
				else {
					switch (birthdayMonthGuess) {
					
					case "January" :
						System.out.println("Your guess is too low");
						break;
						
					case "February" :
						if (randomNumber > 1) {
							System.out.println("Your guess is too low");
						}
						else {
							System.out.println("Your guess is too high");
						}
						break;
						
					case "March" :
						if (randomNumber > 2) {
							System.out.println("Your guess is too low");
						}
						else {
							System.out.println("Your guess is too high");
						}
						break;
						
					case "April" :
						if (randomNumber > 3) {
							System.out.println("Your guess is too low");
						}
						else {
							System.out.println("Your guess is too high");
						}
						break;
						
					case "May" :
						if (randomNumber > 4) {
							System.out.println("Your guess is too low");
						}
						else {
							System.out.println("Your guess is too high");
						}
						break;
						
					case "June" :
						if (randomNumber > 5) {
							System.out.println("Your guess is too low");
						}
						else {
							System.out.println("Your guess is too high");
						}
						break;
						
					case "July" :
						if (randomNumber > 6) {
							System.out.println("Your guess is too low");
						}
						else {
							System.out.println("Your guess is too high");
						}
						break;
						
					case "August" :
						if (randomNumber > 7) {
							System.out.println("Your guess is too low");
						}
						else {
							System.out.println("Your guess is too high");
						}
						break;
						
					case "September" :
						if (randomNumber > 8) {
							System.out.println("Your guess is too low");
						}
						else {
							System.out.println("Your guess is too high");
						}
						break;
						
					case "October" :
						if (randomNumber > 9) {
							System.out.println("Your guess is too low");
						}
						else {
							System.out.println("Your guess is too high");
						}
						break;
						
					case "November" :
						if (randomNumber > 10) {
							System.out.println("Your guess is too low");
						}
						else {
							System.out.println("Your guess is too high");
						}
						break;
						
					case "December" :
						System.out.println("Your guess is too high");
						break;
						
					}
					
					
				}
			}
			
			
		}
		System.out.println("Out of guesses! The correct birthday was: " + currentBirthdayMonth + " " + currentBirthdayDay);
	}
}
