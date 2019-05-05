/* ClassLab4
 * Written by Chris Guilfoy
 * 
 * This class will ask the user to enter a number, and then create that amount of random
 * people and add them to an ArrayList. It will also print out each persons stats, and 
 * print out the total stats of the entire population.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ClassLab4 {
	
	//Creates a variable to control the while loop, a variable to hold the number of people to be created
	//and an array to hold a predetermined list of names
	public static int numPeopleCounter = 0;
	public static int numPeople = 0;
	public static String [] nameBank = {"Steve", "Bob", "Amy", "Carol", "Jessica", "Harold", "James", "George",
		"Peter", "Rick", "Angela", "Sue", "Piper", "Samantha", "Bartholomew", "Ragnar", "Eric", "Winifred", "Becca", "Jorge" };
	static Scanner scanner = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		
		//The user is asked to enter an amount of people
		System.out.println("Please enter the number of people. ");
		
		//Entered number is scanned into numPeople
		
		
		while (numPeopleCounter == 0) {
			numPeople = scanner.nextInt();
			
			if (numPeople < 1) {
				System.out.println("Please enter a number greater than 0. ");
			}
			else {
				numPeopleCounter = 1;
			}
		}
		
		//Creates a random number generator
		Random rand = new Random();
		
		//Creats the ArrayList to hold the BodyMassIndex objects
		List<BodyMassIndex> peopleList = new ArrayList<BodyMassIndex>();
		
		/* Loop that will run based on how many people were entered by the user. The loop will
		 * create a new person with a randomized name, age, height, and weight and then added them to
		 * the ArrayList. It will then calculate their BMI and categorize them as obese, overweight,
		 * normal or underweight. It then prints out their information and moves on to the next person.
		 */
		for (int i = 0; i < numPeople; i++){
			BodyMassIndex Person = new BodyMassIndex(nameBank[rand.nextInt(20)], rand.nextInt(50) + 18, 
					rand.nextInt(200) + 80, rand.nextInt(30) + 50);
			peopleList.add(Person);
			
			if (Person.getBMI() < 18.5) {
				BodyMassIndex.numberOfUnderweight = BodyMassIndex.numberOfUnderweight + 1;
			}
			else if (Person.getBMI() >= 18.5 && Person.getBMI() < 25.0) {
				BodyMassIndex.numberOfNormal = BodyMassIndex.numberOfNormal + 1;
			}
			else if (Person.getBMI() >= 25.0 && Person.getBMI() < 30.0) {
				BodyMassIndex.numberOfOverweight = BodyMassIndex.numberOfOverweight + 1;
			}
			else if (Person.getBMI() >= 30.0) {
				BodyMassIndex.numberOfObese = BodyMassIndex.numberOfObese + 1;
			}
			
			System.out.println(Person.toString());
		}
		
		//Prints out the current statistics of the population
		System.out.println("There are currently " + BodyMassIndex.getNumObese() + " obese people, " + BodyMassIndex.getNumOverweight() + " overweight people, "
				 + BodyMassIndex.getNumNormal() + " normal people, and " + BodyMassIndex.getNumUnderweight() + " underweight people.");
	}
}
