
public class Calculator {

	public int yearswork;
	public int salary;
	public double total;
	public int uncle;
	public int aunt;
	public double beforedie;
	public double afterdie;
	public int sel2;
	
	public Calculator()
	{
		yearswork =0;
		salary = 0;
		total = 0;
		uncle = 0;
		aunt = 0;
		beforedie = 0;
		afterdie = 0;
	}
	
	public double LPO1()
	{	
		beforedie = yearswork*(salary*.015)*.88*(uncle);
		
		afterdie = yearswork*(salary*.015)*.88*(aunt-uncle);
			
		total = beforedie + afterdie;
		
		return total;
		
	}
	
	public double LPO2()
	{
		beforedie = yearswork*(salary*.015)*.91*(uncle);
		
		afterdie = yearswork*(salary*.015)*.91*(aunt-uncle)*.75;
		
		total = beforedie + afterdie;
		
		return total;
	}

	public double LPO3()
	{
		beforedie = yearswork*(salary*.015)*.95*uncle;
		
		afterdie = yearswork*(salary*.015)*.95*(aunt-uncle)*.50;

		total = beforedie + afterdie;	
		
		return total;
	}

	public double IPO1()
	{
			
		for(int i = 0; i <= uncle; i++)
		{
			beforedie += yearswork*(salary*.015)*.58 + beforedie*.04;
		}
		for(int i = 0; i <=(aunt-uncle); i++)
		{
			afterdie += beforedie*.04;
		}		
		
		total = beforedie + afterdie;
		
		return total;
	}
	
	public double IPO2()
	{
		for(int i = 0; i <= uncle; i++)
		{
			beforedie += yearswork*(salary*.015)*.61 + beforedie*.04;
		}
		for(int i = 0; i <=(aunt-uncle); i++)
		{
			afterdie += (afterdie + yearswork*(salary*.015)*.61)*.75*.04;
		}		
		
		total = beforedie + afterdie;
		
		return total;
		
	}

	public double IPO3()
	{
		for(int i = 0; i <= uncle; i++)
		{
			beforedie += yearswork*(salary*.015)*.64 + beforedie*.04;
		}
		for(int i = 0; i <=(aunt-uncle); i++)
		{
			afterdie += (afterdie + yearswork*(salary*.015)*.61)*.50*.04;
		}		
		
		total = beforedie + afterdie;
		
		return total;
	}

	
	
}
