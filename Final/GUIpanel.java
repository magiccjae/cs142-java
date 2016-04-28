import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;


public class GUIpanel extends JPanel {

	private JPanel panel1, panel2, panel3;
	private JLabel label1, label2, label3, label4, label5;
	private JTextField name1, amount, name2, name3, amount1;
	private JRadioButton radio_one, radio_six, radio_twelve, radio_revolving, radio_minimum;
	private JRadioButton radio_specific, radio_cash, radio_check, radio_credit;
	private JButton add, view, pay, advance;
	private JTextArea info;
	private double fee;
	private Database db;
	private boolean isMinimumPayment;
	private PaymentType paymentType;
	private PaymentMethod paymentMethod;
	
	private PurchaseOptions purchaseOption;
	private Double balance;
	private Double minimumPayment;
	private PaymentLogic paymentLogic;
	public GUIpanel()
	{
		db = new Database();
		
		setPreferredSize(new Dimension(1250, 300));
		
		
		//panel1
		panel1 = new JPanel();
		
		label1 = new JLabel("New Purchaser Name");
		name1 = new JTextField(15);
		
		label2 = new JLabel("New Purchase Amount");
		amount = new JTextField(10);
		
		
		
		RBListener rbListener = new RBListener();
		radio_one = new JRadioButton("1 Month Account");
		radio_one.addActionListener(rbListener);
			
		radio_six = new JRadioButton("6 Month Account");
		radio_six.addActionListener(rbListener);
		
		radio_twelve = new JRadioButton("12 Month Account");
		radio_twelve.addActionListener(rbListener);
		
		radio_revolving = new JRadioButton("Revolving Account");
		radio_revolving.addActionListener(rbListener);
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(radio_one);
		group.add(radio_six);
		group.add(radio_twelve);
		group.add(radio_revolving);
		
		add = new JButton("Add Purchase");
		add.addActionListener(new AddListener());
		panel1.add(label1);
		panel1.add(name1);
		panel1.add(label2);
		panel1.add(amount);
		panel1.add(radio_one);
		panel1.add(radio_six);
		panel1.add(radio_twelve);
		panel1.add(radio_revolving);
		panel1.add(add);
		
		add(panel1);
		
		
		
		//panel2
		panel2 = new JPanel();
		
		label3 = new JLabel("Account Name to View");
		name2 = new JTextField(15);
		view = new JButton("View Purchase Information");
		view.addActionListener(new ViewListener());
		
		info = new JTextArea("", 7, 35);
		JScrollPane scrollingArea = new JScrollPane(info);
		
		
		
		
		panel2.add(label3);
		panel2.add(name2);
		panel2.add(view);
		panel2.add(scrollingArea);
		//panel2.add(info);
		
		add(panel2);
		
		
		
		//panel3
		
		MakePaymentListener makePaymentListener = new MakePaymentListener();
		
		panel3 = new JPanel();
		
		label4 = new JLabel("Purchaser Name");
		name3 = new JTextField(15);
		
		PaymentTypeListener paymentTypeListener = new PaymentTypeListener();
		
		radio_minimum = new JRadioButton("Minimun Payment");
		radio_minimum.addActionListener(paymentTypeListener);
		radio_specific = new JRadioButton("Specific Payment");
		radio_specific.addActionListener(paymentTypeListener);
		ButtonGroup group1 = new ButtonGroup();
		group1.add(radio_minimum);
		group1.add(radio_specific);
		
		label5 = new JLabel("Specific Payment Amount");
		amount1 = new JTextField(10);
		amount1.addActionListener(paymentTypeListener);
		
		radio_cash = new JRadioButton("Cash");
		radio_cash.addActionListener(paymentTypeListener);
		radio_check = new JRadioButton("Check");
		radio_check.addActionListener(paymentTypeListener);
		radio_credit = new JRadioButton("Credit");
		radio_credit.addActionListener(paymentTypeListener);
		ButtonGroup group2 = new ButtonGroup();
		group2.add(radio_cash);
		group2.add(radio_check);
		group2.add(radio_credit);
		pay = new JButton("Make Payment");
		pay.addActionListener(makePaymentListener);
		
		advance = new JButton("Advance Month");
		advance.addActionListener(new AdvanceMonthListener());
		panel3.add(label4);
		panel3.add(name3);
		panel3.add(radio_minimum);
		panel3.add(radio_specific);
		panel3.add(label5);
		panel3.add(amount1);
		panel3.add(radio_cash);
		panel3.add(radio_check);
		panel3.add(radio_credit);
		panel3.add(pay);
		panel3.add(advance);
		
		add(panel3);
		
		
	}
	
	
	//event occurred by choosing purchaseOption
	private class RBListener implements ActionListener
	{		
		public void actionPerformed(ActionEvent event) {
			Object source = event.getSource();
			
			if(source== radio_one)
			{				
				purchaseOption = new PurchaseOptionsOneMonth();
			}else if(source== radio_six)
			{
				purchaseOption = new PurchaseOptionsSixMonth();
			}else if(source== radio_twelve)
			{
				purchaseOption = new PurchaseOptionsTwelveMonth();
			}else if(source == radio_revolving) 
			{
				purchaseOption = new PurchaseOptionsRevolving();
			}
		}
		
	}

	//event occurred by clicking Add button
	private class AddListener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent event) {
			
			Object source = event.getSource();
			
			Purchase purchase = new Purchase();
			
			if(source == add)
			{	
				//to get informations from textfields and radiobutton
				purchase.personName = name1.getText();
				
				 Pattern p = Pattern.compile("[a-zA-Z]");
				 Matcher m = p.matcher(purchase.personName);
				 boolean b = m.matches();
				 
				 if(!m.matches())
				 {
					 System.out.println("Error! Name should only contain alphabets");
					 System.exit(-1);
				 }
				
				
				try{
					purchase.balance = Double.valueOf(amount.getText());
				}catch(NumberFormatException exception)
				{
					System.out.println("Error! Balance is should be numbers");
					
				}
				purchase.option = purchaseOption;
				
				Map<String,List<Purchase>> database = db.record;
				
				List<Purchase> purchaseList = database.get(purchase.personName);
				
				if(purchaseList == null)
				{
					purchaseList = new ArrayList<Purchase>();					
				}
				purchaseList.add(purchase);
				database.put(purchase.personName, purchaseList);
				
				
				
			}	
			
		}
		
	}
	
	//event occurred by clicking View button
	private class ViewListener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent event) {
			
			String queryName = name2.getText();
			
			 Pattern p = Pattern.compile("[a-zA-Z]");
			 Matcher m = p.matcher(queryName);
			 boolean b = m.matches();
			 
			 if(!m.matches())
			 {
				 System.out.println("Error! Name should only contain alphabets");
				 System.exit(-1);
			 }
			
			
			
			List<Purchase> purchaseList = db.record.get(queryName);
			//info = new JTextArea("",5,35);
			
			if(purchaseList == null)
			{
				System.out.println("Error!. That person is not in the record!");
				
			}else
			{
			
				for(Purchase purchase:purchaseList)
				{
					
					paymentLogic = new PaymentLogic(purchase,purchaseOption,isMinimumPayment,paymentType,paymentMethod);
					//paymentLogic.compute();
					paymentLogic.computeMinimumPayment();
					minimumPayment = paymentLogic.minimumPayment;
					purchase.minimumPayment = minimumPayment;
					info.append(purchase.toString());
					info.append("-------------------------------------------------\n");
				}
			}
			
		}		
	}
	
	//event occurred by choosing payment type
	private class PaymentTypeListener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent event) {
			Object source = event.getSource();
			
			if(source == radio_minimum)
			{
				paymentType = new PaymentTypeMiniPay(null);
			}else if(source == radio_specific)
			{
				Double specificAmount = -1d;
				try{
					specificAmount  = Double.valueOf(amount1.getText());
					if(specificAmount <= 0)
					{
						System.out.println("Error! Amount should be >= 0");
					}else
					{
						paymentType = new PaymentTypeMiniPay(specificAmount);
					}
				}catch(NumberFormatException e)
				{
					System.out.println("Error! Specific amount should be number");
				}
								
				
			}
			
			if(source == radio_cash)
			{
				paymentMethod = new PaymentMethodCash();
				
			}else if(source == radio_check)
			{
				paymentMethod = new PaymentMethodCheck();
				
			}else if(source == radio_credit)
			{
				paymentMethod = new PaymentMethodCredit();
			}
			
		}
		
	}
	
	//event occurred by clicking makepayment button
	private class MakePaymentListener implements ActionListener
	{		
		public void actionPerformed(ActionEvent event) {
			
			Object source = event.getSource();
			
			String updateName = name3.getText();
			
			 Pattern p = Pattern.compile("[a-zA-Z]");
			 Matcher m = p.matcher(updateName);
			 boolean b = m.matches();
			 
			 if(!m.matches())
			 {
				 System.out.println("Error! Name should only contain alphabets");
				 System.exit(-1);
			 }
			
			
			List<Purchase> purchaseList = db.record.get(updateName);
			// update each purchase (or transaction)
		
			if(purchaseList == null)
			{
				System.out.println("Error!. That person is not in the record!");
				
			}else
			{
			
				for(Purchase purchase: purchaseList)
				{
				
					
					paymentLogic.computeBalance();
					
					balance = paymentLogic.balance;
					minimumPayment = paymentLogic.minimumPayment;
					System.out.println("balance:" + balance);
					purchase.balance = balance;
					purchase.minimumPayment = minimumPayment;
					
				//	info.append(purchase.toString());
				//	info.append("-------------------------------------------------\n");
				}
			}
			
			
		}
		
	}
	

	
	//event occurred by clicking advance month button
	private class AdvanceMonthListener implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
	
	
	
	
}
