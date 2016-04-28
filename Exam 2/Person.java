
public class Person{
	
	private String firstname;
	private String lastname;
	private boolean helmet;
	private String hashelmet;
	
	// constructor
	public Person(String fn, String ln, boolean hm)
	{
		firstname = fn;
		lastname = ln;
		helmet = hm;
	}
	// to figure out whether same person is already in the list or not
	public boolean equals(Person p)
	{	
		if(firstname.equals(p.firstname) && lastname.equals(p.lastname)&&(helmet == p.helmet))
		{	
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		if(helmet == true)
		{
			hashelmet = "";
		}
		else
		{
			hashelmet = ", with no helmet";
		}
		
		return firstname + " " + lastname + hashelmet;
	}
}