




//Name : JaeHun Lee

//ID # : 95-225-6535

//       CS 142 Winter 2010 Mid-term 1


import java.util.Scanner;

public class Driver {	

	Calculator cal;
	
	int yearswork;
	int salary;
	int uncle;
	int aunt;
	String sel1;
	int sel2;
	String sel3;
	double money;
	double temp1,temp2,temp3, temp4, temp5, temp6;
	
	//constructor
	
	public Driver()
	{
		cal = new Calculator();
	}
	
	public void execute()
	{
		do
		{
						
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Welcome to the Retirement Calculator");
			
			System.out.println("Enter years your husband has worked :");
			yearswork = scan.nextInt();		
			
			System.out.println("Final year's salary: ");
			salary = scan.nextInt();
			
			System.out.println("Years your husband will live after his retirement: ");
			uncle = scan.nextInt();
			do
			{
			System.out.println("Years you will live after your husband's retirement: ");
			aunt = scan.nextInt();
			
				if(uncle > aunt)
				{
					System.out.println("Error: you must live longer than your husband!");
				}
			
			} while (uncle > aunt);
			
	
			cal.yearswork = yearswork;
			cal.salary = salary;
			cal.uncle = uncle;
			cal.aunt = aunt;
			
			do{
			System.out.println("Select your retirement option, L or I(L=Level Payment, I=Increasing Payment): ");
			sel1 = scan.next();
				if (sel1.equals("L")||sel1.equals("I"))
				{
				}
				else
				{
					System.out.println("Either L or I, please...");
				}
			} while(!sel1.equals("L")&&!sel1.equals("I"));
			
			do{
			System.out.println("Percentage you receives after your husband's death(50, 75, or 100)?");
			sel2 = scan.nextInt();		
			cal.sel2 = sel2;
				if (sel2 == 50 || sel2 == 75 || sel2 == 100)
				{	if (sel1.equals("L"))
					{
						temp1 = cal.LPO1();
						temp2 = cal.LPO2();
						temp3 = cal.LPO3();
					}
					if (sel1.equals("I"))
					{
						temp4 = cal.IPO1();
						temp5 = cal.IPO2();
						temp6 = cal.IPO3();
					}
				}
				else
				{
						System.out.println("Please Choose 50 or 75 or 100");
				}
			} while(sel2 != 50 && sel2 != 75 && sel2 != 100);
			
			//Getting the corresponding answer
			if(sel1.equals("L") && sel2 == 100)
			{
				money = temp1;
			}
			if(sel1.equals("L") && sel2 == 75)
			{
				money = temp2;
			}
			if(sel1.equals("L") && sel2 == 50)
			{
				money = temp3;
			}
			if(sel1.equals("I") && sel2 == 100)
			{
				money = temp4;
			}
			if(sel1.equals("I") && sel2 == 75)
			{
				money = temp5;
			}
			if(sel1.equals("I") && sel2 == 50)
			{
				money = temp6;
			}

			
			System.out.println("You will receive a total of: $ " + money);
			
			System.out.println("Would you like to make a new calculation?(y/n): ");
			sel3 = scan.next();
			
		} while(sel3.equals("y"));
		
		System.out.println("Thank you, Live well!!");
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Driver activate = new Driver();
		activate.execute();
		
		
		
	}

}
