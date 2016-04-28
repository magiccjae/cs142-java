import java.util.Random;


public class CreditCardAccountMine implements CreditCard
{
	Random random = new Random();
	
	private double balance;
	private double interest;
	private String account;
	private boolean active;
	
	public int count;

	public CreditCardAccountMine(String name1)
	{
		balance = 0;
		interest = 0.2;
		account = name1;
		active = true;
	}
	
	public CreditCardAccountMine(String name2, double balance1, double interest1)
	{
		account = name2;
		balance = balance1;
		interest = interest1/100;
		active = true;
	}
	
	public CreditCardAccountMine(double balance2, double interest2)
	{
		balance = balance2;
		interest = interest2/100;
		account = ("");
		active = true;
		
		for (int i=1; i<=16; i++)
		{
			count++;
			
			int digit = random.nextInt(10);
			
			account += digit;
			
			if(count%4 == 0 && count != 16)
			{
				account += (" ");
			}
		}
	}
	
	/*
	 *	-Make a purchase on the credit card according to the purchase amount
	 *	-Do not allow negative purchases
	 *	-Do not allow purchases on a closed account
	 *	-Return true if a purchase is made
	 */
	public boolean makeAPurchase(double purchaseAmount)
	{	
		if (purchaseAmount >= 0 && active == true)
		{
			balance += purchaseAmount; 
			
			return true;
		}
		else
		{
			return false;
		}
	}
	/*
	 *	-Make a payment on the credit card according to the payment amount
	 *	-Do not allow negative payments
	 *	-Do not allow a payment larger than the credit card debt
	 *	-Do not allow a payment on a closed account
	 *	-Add on the monthly interest after a payment is made
	 *	-Return true if a payment is made
	 */
	public boolean makeAPayment(double paymentAmount)
	{
		if(paymentAmount >= 0 && paymentAmount <= balance && active == true)
		{
			balance -= paymentAmount;
			balance += balance*interest/12;
			
			return true;
		}
		else
		{
			return false;
		}
	}
	/*
	 *	-Make a default payment on the credit card:
	 * 		-if credit card debt is less than $20 then pay off remaining debt
	 * 		-if credit card debt is greater than $20 make a payment of $20 or 2% of the credit card balance, whichever is greater
	 * 	-Do not allow a payment on a closed account
	 * 	-Add on the monthly interest after a payment is made
	 * 	-Return true if a payment is made
	 */
	public boolean makeAPayment()
	{
		if(active == true)
		{
			if(balance < 20)
			{
				balance = 0;
			}
			else
			{
				if(balance*.02 <= 20)
				{
					balance -= 20;
				}
				else
				{
					balance -= balance*.02;
				}
			}
			balance += balance*interest/12;
			return true;
		}
		else
		{
			return false;
		}
	}

	/*
	 *	-Transfer the credit card balance from the current account to the account given
	 *	-Do not allow the transfer if either account is closed
	 *	-Close account if balance is transferred
	 *	-Return true if money is transferred
	 */
	public boolean transferBalanceTo(CreditCard otherAccount)
	{
		if(active == true && otherAccount.isActive())
		{
			otherAccount.makeAPurchase(balance);
			balance = 0;
			active = false;
			return true;
		}
		else
		{
			return false;
		}
	}

	/*
	 * 	-Close current account if balance is 0
	 */
	public void close()
	{
		if(balance == 0)
		{
			active = false;
		}
	}

	/*
	 * 	-Return whether the current account is active or not
	 */
	public boolean isActive()
	{
		if(active == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/*
	 *	-Return the name of the account
	 */
	public String getAccountName()
	{
		return account;
	}

	/*
	 * 	-Return the credit card balance of the current account
	 */
	public double getCurrentBalance()
	{
		return balance;
	}

	/**
	 * 	-Return a string that includes the following
	 * 		-the name of the credit card account
	 * 		-the credit card debt of the current account
	 * 		-the annual interest rate of the current account
	 */
	public String toString()
	{
		return account + "\n" + balance + "\n" + interest;
	}

}

