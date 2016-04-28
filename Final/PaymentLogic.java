import org.omg.CORBA.PRIVATE_MEMBER;


public class PaymentLogic {

	private Purchase purchase;
	private boolean isMinimumPayment;
	private Double specificAmount;
	private Double totalAmount;
	private PaymentType paymentType;
	private PaymentMethod paymentMethod;
	public Double balance;
	public Double minimumPayment;
	private PurchaseOptions purchaseOptions;
	
	public PaymentLogic() {
		
	}


	
	public PaymentLogic(Purchase purchase, PurchaseOptions purchaseOptions, boolean isMinimumPayment,
			PaymentType paymentType, PaymentMethod paymentMethod) {
		this.purchase = purchase;
		balance = this.purchase.balance;
		this.isMinimumPayment =isMinimumPayment;
		this.paymentMethod =paymentMethod;
		this.paymentType = paymentType;
		this.purchaseOptions = purchaseOptions;
	}
	
	public void computeMinimumPayment()
	{
		if(purchaseOptions instanceof PurchaseOptionsOneMonth)
		{
			
			minimumPayment = purchase.balance + 5;	
		}else if(purchaseOptions instanceof PurchaseOptionsSixMonth)
		{
			
			minimumPayment = purchase.balance*0.125 + 5;				
		}else if(purchaseOptions instanceof PurchaseOptionsTwelveMonth)
		{
			minimumPayment = purchase.balance*0.0833 + balance*0.01 + 5;	
		}else if(purchaseOptions instanceof PurchaseOptionsRevolving)
		{
			minimumPayment = 0.05*balance + 0.02*balance + 5;	
		}
		
	}
	
	public void  computeFee()
	{
		if(paymentMethod instanceof PaymentMethodCredit)
		{
			balance = balance + 0.025*minimumPayment;	
		}
		
	}
	
	public void computeBalance()
	{
		balance = balance - minimumPayment;
	}


	public static void main(String[] args) {
		

	}

}