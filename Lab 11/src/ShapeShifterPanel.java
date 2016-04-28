import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

import javax.swing.border.*;

public class ShapeShifterPanel extends JPanel
{
	private JPanel a, b, c, d, e;
	private JButton Circle, Square, Rectangle, Oval;
	private JRadioButton translate, resize;
	private JCheckBox fill, coordinate;
	private ImageIcon circular = new ImageIcon("myCircle.gif");
	private ImageIcon squarish = new ImageIcon("mySquare.gif");
	private ImageIcon ovalular = new ImageIcon("myOval.gif");
	private ImageIcon rectangularish = new ImageIcon("myRectangle.gif");
	private ArrayList <shape> shapes = new ArrayList<shape>();
	private shape saved = null;
	private boolean coordination = false;
	private boolean filling = false;
	
	public ShapeShifterPanel()
	{
		ButtonListener listener = new ButtonListener();
		
		Circle = new JButton(circular);
		Circle.addActionListener(listener);
		
		Square = new JButton(squarish);
		Square.addActionListener(listener);
		
		Oval = new JButton(ovalular);
		Oval.addActionListener(listener);
		
		Rectangle = new JButton(rectangularish);
		Rectangle.addActionListener(listener);
		

		StyleListener items = new StyleListener();
		
		fill = new JCheckBox("fill");
		fill.setBackground(Color.cyan);
		fill.addItemListener(items);
		
		coordinate = new JCheckBox("Coordinates");
		coordinate.setBackground(Color.cyan);
		coordinate.addItemListener(items);

		translate = new JRadioButton("translate");
		translate.setBackground(Color.cyan);
		resize = new JRadioButton("resize");
		resize.setBackground(Color.cyan);
		
		ButtonGroup group = new ButtonGroup();
		group.add(translate);
		group.add(resize);
		
		translate.addActionListener(listener);
		resize.addActionListener(listener);
		
		
		setLayout(new BorderLayout());
		a = new JPanel();
		a.setPreferredSize(new Dimension(300, 75));
		TitledBorder tb = BorderFactory.createTitledBorder("Draw");
		tb.setTitleJustification(TitledBorder.LEFT);
		a.setBorder(tb);
		a.setBackground(Color.cyan);
		a.add(Circle);
		a.add(Square);
		a.add(Rectangle);
		a.add(Oval);
		
		
		b = new JPanel();
		b.setPreferredSize(new Dimension(100,75));
		b.setBorder(BorderFactory.createRaisedBevelBorder());
		b.setBackground(Color.cyan);
		b.setLayout(new GridLayout(2,1));
		b.add(fill);
		b.add(coordinate, BorderLayout.WEST);
		
		c = new JPanel();
		c.setPreferredSize(new Dimension(100,100));
		TitledBorder b1 = BorderFactory.createTitledBorder("Manipulate");
		b1.setTitleJustification(TitledBorder.RIGHT);
		Border b2 = BorderFactory.createLoweredBevelBorder();
		c.setBorder(BorderFactory.createCompoundBorder(b1, b2));
		c.setBackground(Color.cyan);
		c.setLayout(new GridLayout(2,1));
		c.add(translate);
		c.add(resize);
		
		d = new JPanel();
		d.setPreferredSize(new Dimension(600,125));
		d.setBackground(Color.cyan);
		d.add(a);
		d.add(b);
		d.add(c);
		
		e = new artPanel();
		e.setLayout(new BorderLayout());
		e.setPreferredSize(new Dimension(600,650));
		e.setBackground(Color.black);
		e.add(d, BorderLayout.NORTH);
		e.addMouseListener(new ShapeListener());
		e.addMouseMotionListener(new ShapeListener());

		
		add(e);
	}
	
	private class artPanel extends JPanel
	{		
		public void paintComponent (Graphics page)
		{
			super.paintComponent(page);
			
			Sort(shapes);	
			
			for(int i = shapes.size()-1; i >= 0; i--) //go through ArrayList backwards
			{
				shapes.get(i).draw(page, filling, coordination);	
			}
		}
		public void Sort(ArrayList<shape> list)
		{	
			for(int index = 0; index < list.size() - 1; index++)
			{
				int min = index;
				for(int scan = index +1; scan < list.size(); scan++)
				{
					if(list.get(scan).yc < list.get(min).yc)
					{
							min = scan;
						
					}
				}
				
				if(index != min)
				{
					list.add(index, list.remove(min));
					list.add(min, list.remove(index+1));
				}				
			
			}			 
		}
		
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (event.getSource() == Circle)
			{
				shape cool = new circle();
				
				shapes.add(cool);
				repaint();
				
			}
			if (event.getSource() == Square)
			{
				shape cool = new square();
				
				shapes.add(cool);
				repaint();
			}
			if(event.getSource() == Rectangle)
			{
				shape cool = new rectangle();
				
				shapes.add(cool);
				repaint();
			}
			if(event.getSource() == Oval)
			{
				shape cool = new oval();
				
				shapes.add(cool);	
				repaint();
			}	
				
		}
	}
	
	private class StyleListener implements ItemListener
	{
		public void itemStateChanged (ItemEvent event)
		{			
			if(fill.isSelected())
			{
				filling = true;
				repaint();
			}
			if(!fill.isSelected())
			{
				filling = false;
				repaint();
			}
			if(coordinate.isSelected())
			{
				coordination = true;
				repaint();
			}
			if(!coordinate.isSelected())
			{
				coordination = false;
				repaint();
			}
				
		}
	}
	
	private class ShapeListener implements MouseListener, MouseMotionListener
	{
		public void mousePressed (MouseEvent event) 
		{
			Point p = event.getPoint();
			saved = null;
			for(int i = 0; i < shapes.size(); i++)
			{
				if(shapes.get(i).contains(p) && saved == null)
				{
					saved = shapes.get(i);
				}
			}
			
		}
		
		public void mouseDragged (MouseEvent event) 
		{
				if(resize.isSelected() && saved != null)
					saved.resize(event.getPoint());
				
				if(translate.isSelected() && saved != null)
					saved.translate(event.getPoint());

				repaint();
			
		}
		public void mouseMoved (MouseEvent event) {}
		public void mouseClicked (MouseEvent event) {}
		public void mouseReleased (MouseEvent event) {}
		public void mouseEntered (MouseEvent event) {}
		public void mouseExited (MouseEvent event) {}
		
	}

}
