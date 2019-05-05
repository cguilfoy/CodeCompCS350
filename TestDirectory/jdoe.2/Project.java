package Projects;

import java.util.Iterator;

public class Project implements Iterable<Staff>, Comparable<Project>, Cloneable {

    private String theTitle;
    private String theProjectID;
    private String theBudgetCode;
    private Division theDivision;

    private int numStaff;
    private LLNode first;  ///< Head of linked list of staff members.


    /**
     * Create a new project with empty descriptive (string) attributes and
     * no staff.
     */
    public Project()
    {
        theTitle = theProjectID = theBudgetCode = "";
        theDivision = null;
        numStaff = 0;
        first = null;
    }
    
    
    // Attributes of Project
    
    // Functions/constructors added by cguilfoy start **************************
    
    //Not sure if I needed a copy constructor since it wasn't listed
    //in the Class Designer's checklist for Java lecture but I added one anyway
    //Maybe this is redundant in Java
    
    public Project (Project p)
    {
    	Project holder = (Project) p;
    	
    	holder.theTitle = p.theTitle;
    	holder.theProjectID = p.theProjectID;
    	holder.theBudgetCode = p.theBudgetCode;
    	holder.theDivision = p.theDivision;
    	holder.numStaff = p.numStaff;
    	
    	first = null;
    	
    	if (p.first != null)
    	{
    		LLNode firstHolder = p.first;
    		
    		first = new LLNode(firstHolder.data, null);
    		
    		LLNode currentLeft = first;
    		LLNode currentRight = p.first;
    		
    		while (currentRight.next != null)
    		{
    			currentRight = currentRight.next;
    			LLNode newNode = new LLNode(currentRight.data, null);
    			currentLeft.next = newNode;
    			currentLeft = currentLeft.next;
    		}
    	}
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
    
    //Clone method similar to C++ assignment overload
    
    public Object clone()
    {
    	Project p = new Project();
    	
    	p.theTitle = theTitle;
    	p.theBudgetCode = theBudgetCode;
    	p.theProjectID = theProjectID;
    	p.theDivision = theDivision;
    	p.numStaff = numStaff;
    	p.first = null;
    	
    	if (first != null)
    	{
    		LLNode firstHolder = first;
    		
    		p.first = new LLNode(firstHolder.data, null);
    		
    		LLNode currentLeft = p.first;
    		LLNode currentRight = first;
    		
    		while (currentRight.next != null)
    		{
    			currentRight = currentRight.next;
    			LLNode newNode = new LLNode(currentRight.data, null);
    			currentLeft.next = newNode;
    			currentLeft = currentLeft.next;
    		}
    	}
    	
    	return p;
    	
    }
    
    public int numberOfStaff()
    {
    	return numStaff;
    }
    
    public void addStaff(Staff staff)
    {
    	LLNode prev = null;
    	LLNode current = first;
    	
    	while (current != null && current.data.compareTo(staff) < 0)
    	{
    		prev = current;
    		current = current.next;
    	}
    	
    	if (prev == null)
    	{
    		first = new LLNode(staff, first);
    	}
    	else
    	{
    		prev.next = new LLNode(staff, current);
    	}
    	
    	numStaff++;
    }
    
    //Used the staff.java equals method as a reference
    
    public boolean equals (Object obj) {
        if (obj instanceof Project) {
            Project p = (Project)obj;
            return theProjectID.equals(p.theProjectID);
        }
        else
            return false;
    }
    
    //Used the staff.java toString method as a reference, 
    //specifically used the buf StringBuffer which made it easier
    
    public String toString () {
        StringBuffer buf = new StringBuffer();
        buf.append("The title " + theTitle + " ");
        buf.append("the project ID " + theProjectID + " ");
        buf.append("the budget code " + theBudgetCode + " ");
        buf.append("the division " + theDivision.toString() + " ");
        buf.append("Number of Staff " + numStaff + " ");
        buf.append("List of staff ");
        
        LLNode current = first;
        
        while (current != null)
        {
        	buf.append(current.data.getSurname() + ", " + current.data.getGivenName() + " ");
        	current = current.next;
        }
        
        return buf.toString();
    }
    
    //Functions/constructors added by cguilfoy end *******************************

    /**
     * Get the title of the project.
     * @return the title
     */
    public String getTitle()     {return theTitle;}

    /**
     * Change the title of a project.
     * @param title the new title
     */
    public void setTitle(String title) {theTitle = title;}

    /**
     * The division to which this project belongs. Each project belongs
     * to one division (hence, the division data are pointers to
     * shared Division objects), but a division may have many projects.
     *
     * @return the division
     */
    public Division getDivision()    {return theDivision;}

    /**
     * Change the division to which this project belongs.
     *
     * @param div the division
     */
    public void setDivision(Division div)  {theDivision = div;}


    /**
     * Get the project ID. The project ID is a unique identifier for a project.
     * @return the project ID
     */
    public String getProjectID()     {return theProjectID;}

    /**
     * Change the project ID.
     * @param projectID the new project identifier.
     */
    public void setProjectID(String projectID)  {theProjectID = projectID;}

    /**
     * Get the budget code. Budget codes indicate to whom this project is charged.
     * @return the budget code.
     */
    public String getBudgetCode()    {return theBudgetCode;}

    /**
     * Set the budget code. Budget codes indicate to whom this project is charged.
     * @param code the budget code.
     */
    public void setBudgetCode(String code) {theBudgetCode = code;}


    // Operations on Project


    /**
     * Hash function for Projects
     * @return hash code
     */
    public int hashCode () {
        return theProjectID.hashCode();
    }

    /**
     * Ordering operator for divisions.
     *
     * @param right division to compare to this one
     * @return true iff this division precedes right in sorted listings.
     */
    @Override
    public int compareTo(Project p) {
        return theProjectID.compareTo(p.theProjectID);
    }


    private class LLNode {
        Staff data;
        LLNode next;

        public LLNode(Staff staff, LLNode nxt) {
            data = staff;
            next = nxt;
        }
    }


    @Override
    public Iterator<Staff> iterator() {
        return new StaffIterator(this);
    }

    private class StaffIterator implements Iterator<Staff> {
        private LLNode position;

        public StaffIterator(Project project) {
            position = project.first;
        }

        @Override
        public boolean hasNext() {
            return position != null;
        }

        @Override
        public Staff next() {
            Staff staff = position.data;
            position = position.next;
            return staff;
        }

    }

}
