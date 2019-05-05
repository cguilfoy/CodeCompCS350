
public class ScoreTest {
	int double String { ( ) } Apple ( ) +

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
		
		public class RoundRectangleFun extends JApplet{
	
	//Creating an array to hold the dash pattern to be used 10 filled 5 off
	static float dashArray[] = {10.0f, 5.0f};
	static BasicStroke dashedLine = new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10.0f, dashArray, 0.0f);
	
	public void paint(Graphics g) {
		
		//Creating a new Grapcics2D object by casting Graphics
		Graphics2D rect = (Graphics2D) g;
		
		//Setting the stroke to the dashed line pattern we created above
		rect.setStroke(dashedLine);
		
		//Drawing the rounded rectangle with a specified size and location
		rect.draw(new RoundRectangle2D.Double(50, 50, 100, 50, 20, 20));
	}
	
	public static void main(String[] args) {
		
		//Using Swing to create a java applet to view the rectangle
		JFrame rectFrame = new JFrame("");
		JApplet applet = new RoundRectangleFun();
		rectFrame.getContentPane().add("Center", applet);
		rectFrame.pack();
		rectFrame.setSize(new Dimension(800, 800));
		rectFrame.show();
	}
}