
public class PersonList {

	private PersonNode list;
	private PersonNode last;

	public PersonList()
	{
		list = null;
		last = null;
	}
		
	public void printOut()
	{
		PersonNode current = list;
				
		while(current != null)
		{
			System.out.println(current.person.toString());
			current = current.next;
		}
	}
	
	// to add newcomer to a list, but not to add the same one to the list
	public boolean add(Person per)
	{
		if(list == null)
		{
			PersonNode newNode = new PersonNode(per);
			last = list = newNode;
			newNode.next = null;
			newNode.prev = null;
			return true;
		}
		
		else
		{
			PersonNode current = list;
			
			if(current.person.equals(per))
			{
				return false;
			}
			
			else
			{
				while(current != null)
				{
					if(current.person.equals(per))
					{
						return false;
					}
					
					current = current.next;
					
				}
				
				PersonNode newNode = new PersonNode(per);
				last.next = newNode;
				newNode.prev = last;
				last = newNode;
				last.next = null;
				
				return true;
			}
		}
	}
	
	// to remove
	public boolean remove(Person per)
	{		
		if(list == null)
		{
			return false;
		}
		else
		{
			PersonNode current = list;
			
			while(current.next != null)
			{				
				if(current.person.equals(per))
				{
					if(current.prev != null)
					{
						current.prev.next = current.next;
						current.next.prev = current.prev;
						current.next = null;
						current.prev = null;
					}else
					{
						current = current.next;
						current.prev = null;
						list = current;
					}		
					return true;
				}
				current = current.next;
			}
			
			if(current.person.equals(per))
			{
				current.prev.next = current.next;
				current.prev = null;
				return true;
			}
			return false;
		}
	}
	
	// method that tells how many people in list
	public void getSize()
	{
		PersonNode current = list;
		int count = 0;
		while(current != null)
		{
			current = current.next;
			count ++;
		}
		
		System.out.println(count);
	}
	
	private PersonNode getList()
	{
		return list;
	}
	
	// method to figure out people in both lists
	public void Intersect(PersonList pl)
	{
		PersonNode current = list;
		String temp1, temp2;

		while(current != null)
		{
			temp1 = current.person.toString();
			PersonNode compare = pl.getList();
		
			while(compare != null)
			{
				temp2 = compare.person.toString();
				if(temp1.equals(temp2))
				{
					System.out.println(temp1);
				}
				compare = compare.next;
			}
			current = current.next;
			
		}
	}
	
	// method to show all people in lists
	public void Unisect(PersonList pl)
	{
		PersonNode current = list;
		PersonList uni = new PersonList();
		
		while(current != null)
		{
			uni.add(current.person);
			
			current = current.next;
		}
		current = pl.getList();
		
		while(current != null)
		{
			uni.add(current.person);
			
			current = current.next;
		}
		uni.printOut();
	}
	
	public void oneside(PersonList pl)
	{
		PersonNode current = list;
		PersonList one = new PersonList();
		
		while(current != null)
		{
			one.add(current.person);
			
			current = current.next;
		}
		current = pl.getList();
		
		while(current != null)
		{
			one.remove(current.person);
			
			current = current.next;
		}
		one.printOut();
	}
	
	// to clear lists
	public void clear()
	{
		list = null;
		last = null;
	}
	
	// to make double linked list
	private class PersonNode
	{
		public Person person;
		public PersonNode next;
		public PersonNode prev;

		public PersonNode(Person per)
		{
			person = per;
			next = null;
			prev = null;
		}
	}
}