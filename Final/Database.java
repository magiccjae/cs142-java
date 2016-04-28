
import java.util.*;
public class Database {

	//to save a person with more than one account
	public Map<String,List<Purchase>> record;
	
	public Database()
	{
		record =  new HashMap<String,List<Purchase>>();
	}
	
}