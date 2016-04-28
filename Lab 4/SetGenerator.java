
public class SetGenerator {

	
	public void complementSet1()
	{
		int count = 0;
		for(int i=0; i <=31; i+=2)
		{	
			count++;
			System.out.print(i+"\t");
			if (count %4  == 0)
			System.out.println();
		}
	}
	
	public void complementSet2()
	{
		int count = 0;
		for(int i = 0; i <=31;i++)
		{
			if(i%4 == 0 ||i%4 == 1)
			{
				count++;
				if(count%4 == 0)
				{
					System.out.print(i + "\n");
				}
				else
				{
					System.out.print(i  + "\t");
				}
			}
			else
			{
					// skip
			}
		}
	}
	
	public void complementSet3()
	{
		int count = 0;
		for(int i = 0; i <=31;i++)
		{
			if(i%8 == 0 ||i%8 == 1||i%8 == 2||i%8 == 3)
			{
				count++;
				if(count%4 == 0)
				{
					System.out.print(i + "\n");
				}
				else
				{
					System.out.print(i  + "\t");
				}
			}
			else
			{
				// skip
			}
		}
	}
	
	public void complementSet4()
	{
		int count = 0;
		for(int i = 0; i <=31;i++)
		{
			if(i%16 == 0 ||i%16 == 1 ||i%16 == 2 ||i%16 == 3 ||i%16 == 4 ||i%16 == 5 ||i%16 == 6 ||i%16 == 7 )
			{
				count++;
				if(count%4 == 0)
				{
					System.out.print(i + "\n");
				}
				else
				{
					System.out.print(i  + "\t");
				}
			}
			else
			{
				// skip
			}
		}
	}
	
	public void complementSet5()
	{
		for(int i=0; i <=15; i++)
		{			
			System.out.print(i+"\t");
			if (i % 4 == 3)
			System.out.println();
		}
	}

	//set1
	public void set1()
	{
		for(int i=1; i <=31; i+=2)
		{			
			System.out.print(i+"\t");
			if (i % 8 == 7)
			System.out.println();
		}
	}

	//set2
	public void set2()
	{		
		int count = 0;
		for(int i = 0; i <=31;i++)
		{
			if(i%4 == 0 ||i%4 == 1)
			{
			// skip
			}
			else
			{
				count++;
				if(count%4 == 0)
				{
					System.out.print(i + "\n");
				}
				else
				{
					System.out.print(i  + "\t");
				}
			}
		}	
	}	
		

	public void set3()
	{
				
		int count = 0;
		for(int i = 0; i <=31;i++)
		{
			if(i%8 == 0 ||i%8 == 1||i%8 == 2||i%8 == 3)
			{
				// skip
			}
			else
			{
				count++;
				if(count%4 == 0)
				{
					System.out.print(i + "\n");
				}
				else
				{
					System.out.print(i  + "\t");
				}
			}
		}
	}

	public void set4()
	{
		
		int count = 0;
		for(int i = 0; i <=31;i++)
		{
			if(i%16 == 0 ||i%16 == 1 ||i%16 == 2 ||i%16 == 3 ||i%16 == 4 ||i%16 == 5 ||i%16 == 6 ||i%16 == 7 )
			{
				// skip
			}
			else
			{
				count++;
				if(count%4 == 0)
				{
					System.out.print(i + "\n");
				}
				else
				{
					System.out.print(i  + "\t");
				}
			}
		}
	}
	
	public void set5()
	{
		
		for(int i=16; i <=31; i++)
		{			
			System.out.print(i+"\t");
			if (i % 4 == 3)
			System.out.println();
		}
	}
	
}