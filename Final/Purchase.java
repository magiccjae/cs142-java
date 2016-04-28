
//enum PurchaseOption
//{onemonth,sixmonth,twelvemonth,revolving}

public class Purchase {
	
	public String personName;
	public Double balance;
	
	public PaymentType paymentType;
	
	public PurchaseOptions option;
	public Double minimumPayment;
	

	public Purchase() {
		
	}
	
	
	
	public String toString() {
		
		String output ="";
		
		if(balance < 0)
			balance = 0d;
		// to show an information in the TextArea
		output = "Purchaser:" + personName + "     Balacne:$" +balance + "\n";
		output += "Purchase Amount: $" + balance + "\n";
		output += "Minimum Payment Due:$" + minimumPayment + "\n";
		output += "Purchase Type:";
		
		output += option.period;		

		output += "\n";
		
		/*
		Purchaser: steve     Balance: £Ü725
		Purchase Amount: £Ü6,000   Payments This Month: £Ü2,265
		Minimum Payment Due: £Ü755
		Purchase Type: 6 month
		*/
		return output;
	}


	public static void main(String[] args) {
		

	}

}
