/* BodyMassIndex
 * 
 * This class will create a person and assign them a name, age, weight, and height. It will also 
 * establish the persons BMI, and count how many people in a given population are Obese, Overweight
 * Normal, or Underweight.
 */

public class BodyMassIndex {

	//Creation of variables to hold a persons vitals
	String name = "";
	int age = 0;
	double weight = 0.0;
	double height = 0.0;
	
	//3 permanent doubles that determine BMI thresholds
	static final double OBESE_BMI = 30.0;
	static final double OVERWEIGHT_BMI = 25.0;
	static final double NORMAL_BMI = 18.5;
	
	//static variables to keep track of how many people are Obese, Overweight, Normal, or Underweight
	static int numberOfObese = 0;
	static int numberOfOverweight = 0;
	static int numberOfNormal = 0;
	static int numberOfUnderweight = 0;
	static int totalNumberOfPeople = 0;
	
	//constructor for the class requiring a name, age, weight, and height parameters
	public BodyMassIndex (String newName, int newAge, double newWeight, double newHeight) {
		this.name = newName;
		this.age = newAge;
		this.weight = newWeight;
		this.height = newHeight;
	}
	
	//returns the persons name
	public String getName() {
		return name;
	}
	
	//returns the persons age
	public int getAge() {
		return age;
	}
	
	//returns the persons weight
	public double getWeight() {
		return weight;
	}
	
	//returns the persons height
	public double getHeight() {
		return height;
	}
	
	//returns the number of people who are obese
	public static int getNumObese() {
		return numberOfObese;
	}
	
	//return the number of people who are overweight
	public static int getNumOverweight() {
		return numberOfOverweight;
	}
	
	//returns the number of people who are normal
	public static int getNumNormal() {
		return numberOfNormal;
	}
	
	//returns the number of people who are underweight
	public static int getNumUnderweight() {
		return numberOfUnderweight;
	}
	
	//returns the total number of people
	public static int getTotalPeople() {
		return totalNumberOfPeople;
	}
	
	//calculates and returns the BMI of the current person
	public double getBMI() {
		double BMI = 0.0;
		BMI = (weight * 703) / (height * height);
		return BMI;
	}
	
	//prints out the current persons calculated BMI
	public String getStatus() {
		String status = ("This person's BMI is " + Double.toString(getBMI()));
		return status;
	}
	
	//prints out a selected persons vitals including name, age, height, and weight
	public String toString() {
		String status = ("This person's name is " + getName() + ". They are " + getAge()
			 + " years old, weigh " + getWeight() + " pounds and is " + getHeight() + " inches tall.");
		return status;
	}
	
	/* Main method that will create a new person name Pete and assign him some vitals
	 *It will then print out his vitals to the console, and report on the current population
	 *statistics.
	 */
	
	public static void main(String[] args) {
		BodyMassIndex newPerson = new BodyMassIndex("Pete", 24, 215.0, 69.0);
		System.out.println(newPerson.toString());
		System.out.println("There are currently " + getNumObese() + " obese people, " + getNumOverweight() + " overweight people, "
				 + getNumNormal() + " normal people, and " + getNumUnderweight() + " underweight people.");
		
	}
}
