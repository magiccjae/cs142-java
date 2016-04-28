import java.awt.Point;


public class square extends rectangle
{
	public square()
	{
		super();
		w = h;
		xc = x + (w/2);
	}
	
	public void resize(Point p)
	{
		h = Math.abs(yc - (int)p.getY());
		w = h;
		x = xc - (w/2);
		y = yc - (h/2);
		
	}

	//don't need a draw method because all that would be in the method would be super.draw();
}
