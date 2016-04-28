
public class PaymentTypeSpecific  extends PaymentType{

	public PaymentTypeSpecific(Double specificAmount)
	{
		super.isMinimumPayment =true;
		super.specificAmount = specificAmount;
		
	}
}
