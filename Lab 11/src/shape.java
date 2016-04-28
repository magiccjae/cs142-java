import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public abstract class shape 
{
	protected int x, y, w, h, xc, yc;
	protected Color c;		
	
	public shape()
	{

		Random generator = new Random();
		x = generator.nextInt(475);
		y = generator.nextInt(275) + 227;
		w = generator.nextInt(100) + 25;
		h = generator.nextInt(100) + 25;
		xc = x + (w/2);
		yc = y + (h/2);	
		int r = generator.nextInt(256);
		int g = generator.nextInt(256);
		int b = generator.nextInt(256);
		
		c = new Color(r, g, b);
	}
		
	public abstract void draw(Graphics page, boolean filling, boolean coordination);
	
	public abstract boolean contains(Point p);
	
	public void translate(Point p)
	{
		xc = (int)p.getX();
		yc = (int)p.getY();
		x = xc - (w/2);
		y = yc - (w/2);
	}
	
	public void resize(Point p)
	{
		w = 2*Math.abs((int)p.getX() - xc);
		h = 2*Math.abs(((int)p.getY()) - yc);
		x = xc - (w/2);
		y = yc - (h/2);
		
	}		
}