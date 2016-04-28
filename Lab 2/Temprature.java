import java.util.Scanner;

public class Temprature 
{

	public static void main (String[]arg)
	{		
	Scanner scan = new Scanner(System.in);
		
	System.out.print("Enter a temprature in degrees Fahrenheit as a double: ");
	
	double Fahrenheit = scan.nextDouble();
	
	System.out.println("The temperature in degrees Fahrenheit as an int: "+(int)Fahrenheit+"");
	
	double Celsius = (Fahrenheit-32)*5.0/9.0;
	
	System.out.println("The temperature in degrees Celsius as a double: "+Celsius+"");
	
	System.out.println("The temperature in degrees Celsius as an int: "+(int)Celsius+"");
	
	}
	
	
}