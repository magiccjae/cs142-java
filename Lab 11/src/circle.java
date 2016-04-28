import java.awt.Point;


public class circle extends oval
{
	public circle()
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

}

/* things to tell the others
 * 	
 * 		xc != yc;   just recalculate xc
 * 		it is y + h or y + (h/2)
 * 
 * 		when using the getY() you have to compensate for the panel on top.
 * 			so on mine the top panel was 150 pixels and so I had to subtract 150 from the p.getY
 * 			because p.getY tells you where on the entire GUI are you
 * 
 * 
 */
