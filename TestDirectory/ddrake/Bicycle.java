/* Bicycle Class
   Anderson, Franceschi
*/

public class Bicycle extends Vehicle
{
  /**
  * Overloaded constructor:<BR>
  * Allows client to set beginning value for owner and wheels
  * This constructor takes two parameters<BR>
  * Calls super constructor
  * @param newOwner the new owner for the bicycle
  * @param newWheels the new number of wheels for the bicycle
  */
  public Bicycle( String newOwner, int newWheels )
  {
    super( newOwner, newWheels );
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