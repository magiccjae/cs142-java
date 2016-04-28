import java.util.Scanner;

public class Binary 
{

	public static void main (String[]args)

	{
	Scanner scan = new Scanner(System.in);

System.out.print("Enter a number between 0-31: ");

int number = scan.nextInt();

System.out.println("Based-ten number is \'"+number+"\'");

int digit1 = number/16;

number = number%16;

int digit2 = number/8;

number = number%8;

int digit3 = number/4;

number = number%4;

int digit4 = number/2;

number = number%2;

int digit5 = number;

System.out.print("Binary number is '"+digit1+digit2+digit3+digit4+digit5+"'");

	}
}
