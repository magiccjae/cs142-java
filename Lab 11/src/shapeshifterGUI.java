import javax.swing.JFrame;

public class shapeshifterGUI 
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame ("Shape Shifter");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new ShapeShifterPanel());
	
		frame.pack();
		frame.setVisible(true);
	}
}

//Boreder Demo for borders
//Quoteoptionpanel - JRadioButtons
//Styleoptions - JCheckBoxes
