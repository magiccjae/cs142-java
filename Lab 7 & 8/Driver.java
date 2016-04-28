import javax.swing.JFrame;


public class Driver {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Colosseum");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Colosseum panel = new Colosseum();
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);


	}

}
