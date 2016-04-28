//Name: JaeHun Lee
//ID: 952256535
//E-mail: nagneeve@hotmail.com
//CS142 Winter '10 FinalExam

import javax.swing.JFrame;


public class Driver {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Lee's Buying Rings");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GUIpanel panel = new GUIpanel();
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);

	}

}
