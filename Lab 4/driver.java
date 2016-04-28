import java.util.Random;
import java.util.Scanner;

public class driver {
	SetGenerator sg;
	String ans1;
	Scanner scan;
	int result;
	int sel1, sel2, sel3, sel4, sel5;
	Random random;
	public driver() {
		sg = new SetGenerator();
		scan = new Scanner(System.in);
		random = new Random();
	}
	
	public void execute()
	{
		do{
			System.out.println();
			System.out.println("Think of a number between 0-31, and answer me!");
			
			
			//set1
			sel1 = random.nextInt(2);
			
			if(sel1 == 0) // if selection is 0 then show original, otherwise, show complement
			{
				//normal set
				sg.set1();
				System.out.println("\nIs your number in this set?(yes or no): ");
				ans1 = scan.next();
				
				if (ans1.equals("yes"))
				{
					result = 1;
				}
			}
			else
			{
				//complement set
				sg.complementSet1();
				System.out.println("\nIs your number in this set?(yes or no): ");
				ans1 = scan.next();
				
				if (ans1.equals("no"))
				{
					result = 1;
				}
			}
			
			//set2
			sel2 = random.nextInt(2);
			
			if(sel2 == 0)
			{
				//normal set
				sg.set2();
				System.out.println("\nIs your number in this set?(yes or no): ");
				ans1 = scan.next();
				if (ans1.equals("yes"))
				{
					result += 2;
				}
			}	
			else
			{
				sg.complementSet2();
				System.out.println("\nIs your number in this set?(yes or no): ");
				ans1 = scan.next();
				
				if (ans1.equals("no"))
				{
					result +=2;
				}
				
			}
				
				
			//set3
			sel3 = random.nextInt(2);	
				
			if(sel3 == 0)
			{
				//normal set
				sg.set3();
				System.out.println("\nis your number in this set?(yes or no): ");
				ans1 = scan.next();
				if (ans1.equals("yes"))
				{
					result += 4;
				}
			}
			else
			{
				sg.complementSet3();
				System.out.println("\nIs your number in this set?(yes or no): ");
				ans1 = scan.next();
				
				if (ans1.equals("no"))
				{
					result +=4;
				}
			}
				
				
				
				
			//set4
			
			sel4 = random.nextInt(2);
			
			if(sel4 == 0)
			{	
				//normal set
				sg.set4();
				System.out.println("\nis your number in this set?(yes or no): ");
				ans1 = scan.next();
				if (ans1.equals("yes"))
				{
					result += 8;
				}
			}
			else
			{
				sg.complementSet4();
				System.out.println("\nIs your number in this set?(yes or no): ");
				ans1 = scan.next();
				
				if (ans1.equals("no"))
				{
					result +=8;
				}
			}
			

			//set5
			
			sel5 = random.nextInt(2);
			
			if(sel5 == 0)
			{
				//normal set
				sg.set5();
				System.out.println("\nis your number in this set?(yes or no): ");
				ans1 = scan.next();
				if (ans1.equals("yes"))
				{
					result += 16;
				}
			}
			else
			{
				sg.complementSet5();
				System.out.println("\nIs your number in this set?(yes or no): ");
				ans1 = scan.next();
				
				if (ans1.equals("no"))
				{
					result +=16;
				}
			}
			
			System.out.println("\nWell...\nYour number is " + result);
			
			result=0;
			
			System.out.println("\nDo you want to replay?");
			ans1 = scan.next();
		}
		while(ans1.equals("yes"));
	}

	public static void main(String[] args) {
		driver mydriver = new driver();
		mydriver.execute();
		System.out.println("Thank you, bye");

	}

}
