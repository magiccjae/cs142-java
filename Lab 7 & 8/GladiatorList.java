
public class GladiatorList {
	
	private GladiatorNode list;
	
	public GladiatorList()
	{
		list = null;
	}
	
	public void add (Gladiators glad)
	{
		GladiatorNode node = new GladiatorNode(glad);
		GladiatorNode front;
		
		if(list == null)
		{
			list = node;
		}
		else
		{
			front = list;
			while(front.next != null)
			{
				front = front.next;
			}
			front.next = node;
		}
	}
	
	public void remove()
	{	
		if(list != null)
		{
			list = list.next;
		}
	}
	
	private class GladiatorNode
	{
		public Gladiators gladiator;
		public GladiatorNode next;
		
		public GladiatorNode(Gladiators glad)
		{
			gladiator = glad;
			next = null;
		}
	}

}
