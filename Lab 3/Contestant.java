import java.util.Random;

public class Contestant {

	private String name;
	private int skill;
	private int turn;
	private int piece = 12;
	private int totaltime;
		
	public Contestant(String n, int s, int t)
	{	
		name = n;
		skill = s;
		turn = t;
	}
	
	public int getClockTime()
	{
		return totaltime;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getNumPieces()
	{
		return piece;
	}
	
	public int getSkillValue()
	{
		return skill;
	}
	
	public void initializeGameClock(int seconds)
	{
		totaltime = seconds;
	}
	
	public void losePieces(int numLost)
	{	
		piece = piece-numLost;
	}
	
	public int takeTurn()
	{
		int second;
		Random maker = new Random();
		second = maker.nextInt(turn)+1;
		totaltime -= second;
		return second;
	}
	
	
}
