import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Colosseum extends JPanel {
	
	private ArrayList <Gladiators> challenger;
	
	private GladiatorList queue;
	
	private Gladiators Ronaldo, Messi, Essien, Lampard, Zidane;
		
	private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9, extrapanel;
	private JLabel label1, label2, label3, label4, label5, numgladiators, namegladiator, skillgladiator, numvictories, currentchallenger, matchtitle, matchnumber, matchcurrent, matchresult;
	private JTextField name, skill, number, you, challenge;
	private JButton add, view, setup, fight;
	
	private int size = 5;
	
	private int count = 0;
	
	public Colosseum(){
	
		
	// constructor
	queue = new GladiatorList();
	
	challenger = new ArrayList<Gladiators>();
	Ronaldo = new Gladiators("Ronaldo", 9);
	Messi = new Gladiators("Messi", 10);
	Essien = new Gladiators("Essien", 5);
	Lampard = new Gladiators("Lampard", 8);
	Zidane = new Gladiators("Zidane", 5);
	
	challenger.add(Ronaldo);
	challenger.add(Messi);
	challenger.add(Essien);
	challenger.add(Lampard);
	challenger.add(Zidane);
	
		
	setPreferredSize(new Dimension(600, 600));
	
	
	// Welcome
	
	panel1 = new JPanel();
	panel1.setBackground(Color.ORANGE);
	panel1.setPreferredSize(new Dimension(600, 50));

	label1 = new JLabel("Welcome to the Colosseum", SwingConstants.CENTER);
	
	panel1.add(label1);
	
	
	// Gladiator Check In
	
	panel2 = new JPanel();
	panel2.setBackground(Color.ORANGE);
	panel2.setPreferredSize(new Dimension(600, 50));
	
	label2 = new JLabel("Gladiator Check In");
	panel2.add(label2);

	
	panel3 = new JPanel();
	panel3.setBackground(Color.orange);
	panel3.setPreferredSize(new Dimension(600, 50));

	name = new JTextField(10);
	skill = new JTextField(5);
	add = new JButton("Add Gladiator");
	
	panel3.add(new JLabel("Name: "));
	panel3.add(name);
	panel3.add(new JLabel("Skill: "));
	panel3.add(skill);
	panel3.add(add);
	
	
	// View Gladiators
	
	panel4 = new JPanel();
	panel4.setBackground(Color.orange);
	panel4.setPreferredSize(new Dimension(600, 50));
	
	label3 = new JLabel("View Gladiators");
	panel4.add(label3);

	
	panel5 = new JPanel();
	panel5.setBackground(Color.orange);
	panel5.setPreferredSize(new Dimension(600, 50));
	
	number = new JTextField(5);
	view = new JButton("View Gladiator");
	
	numgladiators = new JLabel("# of gladiators: " + size);
	panel5.add(number);
	panel5.add(view);
	panel5.add(numgladiators);
	
	
	extrapanel = new JPanel();
	extrapanel.setBackground(Color.orange);
	extrapanel.setPreferredSize(new Dimension(600, 50));

	
	namegladiator = new JLabel("Name: ");
	skillgladiator = new JLabel("Skill: ");
	numvictories = new JLabel("# of Victories: ");
	currentchallenger = new JLabel("Currently challenging nobody");
	
	extrapanel.add(namegladiator);
	extrapanel.add(skillgladiator);
	extrapanel.add(numvictories);
	extrapanel.add(currentchallenger);
	

	// Set up matches
	
	panel6 = new JPanel();
	panel6.setBackground(Color.orange);
	panel6.setPreferredSize(new Dimension(600, 50));
	
	label4 = new JLabel("Set Up Matches");
	panel6.add(label4);
	
	panel7 = new JPanel();
	panel7.setBackground(Color.orange);
	panel7.setPreferredSize(new Dimension(600, 70));
	
	you = new JTextField(5);
	challenge = new JTextField(5);
	setup = new JButton("Set Up Match");
	
	matchtitle = new JLabel("The match was created between --- and --- ");
	
	panel7.add(new JLabel("You are contestant#: "));
	panel7.add(you);
	panel7.add(new JLabel("Challenge contestant#: "));
	panel7.add(challenge);
	panel7.add(setup);
	panel7.add(matchtitle);
	
	
	// Battle Arena

	panel8 = new JPanel();
	panel8.setBackground(Color.orange);
	panel8.setPreferredSize(new Dimension(600, 50));
	
	label5 = new JLabel("Battle Arena");
	panel8.add(label5);
	
	panel9 = new JPanel();
	panel9.setBackground(Color.orange);
	panel9.setPreferredSize(new Dimension(600, 50));
	
	matchnumber = new JLabel("Current # of Matches: " );
	matchcurrent = new JLabel("Current Match: ");
	matchresult = new JLabel("--- beat --- with a score of ");
	

	fight = new JButton("FIght Battle");
	
	panel9.add(matchnumber);
	panel9.add(matchcurrent);
	panel9.add(fight);
	panel9.add(matchresult);
	
	
	add(panel1);
	add(panel2);
	add(panel3);
	add(panel4);
	add(panel5);
	add(extrapanel);
	add(panel6);
	add(panel7);
	add(panel8);
	add(panel9);
	
	add.addActionListener(new ButtonListener());
	view.addActionListener(new ButtonListener());
	setup.addActionListener(new ButtonListener());
	
	}
	
	private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource() == add)
			{
				String newplayer = name.getText();
				String newskill = skill.getText();
				int realskill = Integer.parseInt(newskill);
				
				Gladiators newchallenger = new Gladiators(newplayer, realskill);
				challenger.add(newchallenger);
				
				size ++;
				numgladiators.setText("# of gladiators: " + size);
				
			}
			
			if(event.getSource() == view)
			{
				int index = Integer.parseInt(number.getText());
				Gladiators order = challenger.get(index-1);
				namegladiator.setText("Name: " + order.getName());
				skillgladiator.setText("Skill: " + order.getSkill());
				numvictories.setText("# of Victories: " + order.getVictory());		
				currentchallenger.setText("Currently challenging " + order.getChallenger());
				
			}
			
			if(event.getSource() == setup)
			{
				count ++;
				
				int indexYou = Integer.parseInt(you.getText());
				int indexChallenge = Integer.parseInt(challenge.getText());
				Gladiators orderYou = challenger.get(indexYou-1);
				Gladiators orderChallenge = challenger.get(indexChallenge-1);
				
				queue.add(orderYou);
				
				
				matchtitle.setText("The match was created between " + orderYou.getName() + " and " + orderChallenge.getName());
				matchnumber.setText("Current # of Matches: " + count);

			}
			
			if(event.getSource() == fight)
			{
				

			}
		}
		
	}
	
}
