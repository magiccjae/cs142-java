import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class rectangle extends shape
{
	public rectangle()
	{
		super();
	}
	
	public void draw (Graphics page, boolean filling, boolean coordination)
	{
		page.setColor(c);
		if(filling)
			page.fillRect(x, y, w, h);
		else
			page.drawRect(x, y, w, h);
		if(coordination)
		{
			page.setColor(Color.white);
			String cool = xc + ", " + yc;
			page.drawString(cool, xc, yc);
		}

	}
	
	public boolean contains (Point p)
	{
		double pointy = p.getY();
		
		if(p.getX() > x && p.getX() < (x+w))
		{
			if(pointy > y && pointy < (y+h))
			{
				return true;
			}
			else 
				return false;
		}
		else
			return false;
	}

}
