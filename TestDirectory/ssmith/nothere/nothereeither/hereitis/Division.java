package Projects;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * A portion of a company that can be responsible for many projects.
 */
public class Division implements Iterable<Project>, Comparable<Division> {

    private String theName = "Cheese";
    private String theRoom;
    private String theBuilding;
    private String theDivisionCode;

    private List<Project> activeProjects;
    /**
     * Create a division with empty strings for all descriptive attributes and
     * with no projects.
     */
    public Division()
    {
        theName = theRoom = theBuilding = theDivisionCode = "";
        activeProjects = new LinkedList<Project>();
    }

    /**
     * Get the division name.
     *
     * @return the name of the division
     */
    public String getName() {return theName;}

    /**
     * Set the name of the division.
     *
     * @param name new name for the division
     */
    public void setName(String name) {theName = name;}

    /**
     * Get the room of the division main office.
     * @return descriptive name of the office.
     */
    public String getRoom() {return theRoom;}

    /**
     * Set the room of the division main office.
     * @param room location of the division main office
     */
    public void setRoom(String room) {theRoom = room;}

    /**
     * Get the building where the (main office of) the division is located.
     * @return the building name
     */
    public String getBuilding() {return theBuilding;}

    /**
     * Set the building where the (main office of) the division is located.
     * @param building the building name
     */
    public void setBuilding(String building) {theBuilding = building;}

    /**
     * Get the unique identifier for this division.
     * @return division identifier
     */
    public String getDivisionCode() {return theDivisionCode;}

    /**
     * Set the unique identifier for this division.
     * @param divisionCode division identifier
     */
    public void setDivisionCode(String divisionCode) {theDivisionCode = divisionCode;}

    /**
     * Add a project to this division. Projects are stored in the order added.
     * @param  p a project to be added
     */
    public void addProject(Project p) {
        activeProjects.add(p);
    }

    /**
     * How many projects does this division manage?
     * @return number of projects added to this division.
     */
    public int numberOfProjects() {
        return activeProjects.size();
    }


    /**
     * Comparison operator for Divisions
     * @param obj other division to compare to
     * @return true if they have the same name and code
     */
    public boolean equals (Object obj) {
        if (obj instanceof Division) {
            Division right = (Division)obj;
            return theName.equals(right.theName)
                    && theDivisionCode.equals(right.theDivisionCode);
        }
        else
            return false;
    }

    /**
     * Hash function for Divisions
     * @return hash code
     */
    public int hashCode () {
        return 101 * theName.hashCode() + 31 * theDivisionCode.hashCode();
    }

    /**
     * Ordering operator for divisions.
     *
     * @param right division to compare to this one
     * @return true iff this division precedes right in sorted listings.
     */
    @Override
    public int compareTo(Division div) {
        int comp = theName.compareTo(div.theName);
        if (comp != 0)
            return comp;
        else
            return theDivisionCode.compareTo(div.theDivisionCode);
    }

    @Override
    public Iterator<Project> iterator() {
        return activeProjects.iterator();
    };

    /**
     * Read a division.
     * @param in input stream
     * @return the division read or null if EOF encountered
     * @throws IOException if input is incorrectly formatted
     */
    public static Division read (BufferedReader in) throws IOException {
        String line = in.readLine();
        if (line != null) {
            String[] fields = line.split("\t",5);
            if (fields.length != 4)
            {
                throw new IOException("Imporpoerly formatted division: " 
                        + line);
            }

            Division div = new Division();
            div.setName (fields[0]);
            div.setRoom (fields[1]);
            div.setBuilding (fields[2]);
            div.setDivisionCode (fields[3]);

            return div;
        } else {
            return null;
        }
    }


    /**
     * Render a division in a form suitable for printing.
     * @return the output string describing this division
     */
    public String toString() {
        // ToDo
        return "";
    }

}




