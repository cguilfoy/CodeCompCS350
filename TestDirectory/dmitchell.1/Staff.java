package Projects;

/**
 * A staff member working for the company.
 */
public class Staff implements Comparable<Staff> {
    private String theSurname;
    private String theGivenName;

    /**
     * Create a staff member with empty name fields.
     */
    public Staff () {
        theSurname = "";
        theGivenName = "";
    }

    /**
     * Create a staff member.
     * @param surname surname of the staff member
     * @param givenName given name of the staff member
     */
    public Staff (String surname, String givenName) {
        theSurname = surname;
        theGivenName = givenName;
    }


    /**
     * Get the surname (a.k.a. family name or last name)
     * @return the surname
     */
    public String getSurname()        {return theSurname;}

    /**
     * Change the surname.
     * @param surname new surname string
     */
    public void setSurname(String surname) {theSurname = surname;}

    /**
     * Get the given name (a.k.a. first name) of the staff member.
     * @return the given name
     */
    public String getGivenName()          {return theGivenName;}

    /**
     * Change the given name.
     * @param givenName the new given name string
     */
    public void putGivenName(String givenName) {theGivenName = givenName;}

    /**
     * Compare two staff
     * @param obj another staff member
     * @return true iff the two staff have identical names.
     */
    public boolean equals (Object obj) {
        if (obj instanceof Staff) {
            Staff r = (Staff)obj;
            return theSurname.equals(r.theSurname)
                    && theGivenName.equals(r.theGivenName);
        }
        else
            return false;
    }

    /**
     * Compare two staff
     * @param r another staff member
     * @return some value less than zero  iff the this staff member's name
     *    should precede the other in sorted listings, zero iff the two are
     *    equal, greater than zero if this this staff member's name
     *    should follow the other in sorted listings.
     */
    public int compareTo(Staff r) {
        if (theSurname.equals(r.theSurname))
            return theGivenName.compareTo(r.theGivenName);
        else
            return theSurname.compareTo(r.theSurname);
    }

    /**
     * Compute a hash code for this object.
     * @return the hash code
     */
    public int hashCode() {
        return 43 * theSurname.hashCode() + theGivenName.hashCode();
    }


    /**
     * Render a staff member name into a printable form.
     * @return a string representation of this object
     */
    public String toString () {
        StringBuffer buf = new StringBuffer();
        buf.append(theSurname);
        if (theGivenName.length() > 0) {
            buf.append(", ");
            buf.append (theGivenName);
        }
        return buf.toString();
    }

}

