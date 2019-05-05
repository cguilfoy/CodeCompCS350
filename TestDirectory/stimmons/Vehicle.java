/* Vehicle Class
   Anderson, Franceschi
*/

public abstract class Vehicle
{
  private String owner;
  private int wheels;

  /**
  * Overloaded constructor:<BR>
  * Allows client to set beginning values for owner and wheels
  * This constructor takes two parameters<BR>
  * Calls mutator methods
  * @param newOwner the owner of the vehicle
  * @param newWheels the number of wheels of the vehicle
  */
  public Vehicle( String newOwner, int newWheels )
  {
    setOwner( newOwner );
    setWheels( newWheels );
  }

  /** getOwner method
  * @return a String, the name of the owner of the vehicle
  */
  public String getOwner( )
  {
    return owner;
  }

  /** getWheels method
  * @return an int, the number of wheels of the vehicle
  */
  public int getWheels( )
  {
    return wheels;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of owner
  * @param newOwner the new owner for the vehicle
  */
  public void setOwner( String newOwner )
  {
    owner = newOwner;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of wheels
  * @param newWheels the new wheels for the vehicle
  *        if newWheels is negative, then wheels is not changed
  */
  public void setWheels( int newWheels )
  {
    if ( newWheels >= 0 )
      wheels = newWheels;
    else
      System.err.println( "The number of wheels of a vehicle cannot be negative - value unchanged" );
  }

  /**
  * @return a string representation of the vehicle
  */
  public String toString( )
  {
    return( "Owner: " + owner + "; number of wheels: " + wheels );
  }

  /**
  * equals method
  * Compares two Vehicle objects for the same field value
  * @param o another Vehicle object
  * @return a boolean, true if this object
  * has the same field value as the parameter v
  */
  public boolean equals( Object o )
  {
	if ( ! ( o instanceof Vehicle ) )
	   return false;
	else
	{
	   Vehicle v = (Vehicle) o;
       return ( owner.equalsIgnoreCase( v.owner )
                && wheels == v.wheels );
	}
  }
}