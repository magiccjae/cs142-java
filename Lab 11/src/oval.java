import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class oval extends shape
{
	public oval()
	{
		super();
	}
	
	public void draw (Graphics page, boolean filling, boolean coordination)
	{
		page.setColor(c);
		if(filling)
			page.fillOval(x,y,w,h);
		else
			page.drawOval(x, y, w, h);
		if(coordination)
		{
			page.setColor(Color.white);
			String cool = xc + ", " + yc;
			page.drawString(cool, xc, yc);	

		}
		
	} 
	
	public boolean contains (Point p)
	{
		double xd = p.getX() - xc;
		double yd = p.getY() - yc;
		if(Math.pow((xd/w), 2) + Math.pow((yd/h), 2) <= .25)
			return true;
		else
			return false;
		
	}
	
	
}
