public class Gladiators {
	
	private String player;
	private int value, victory;
	private Gladiators challenger;
	
	public Gladiators(String name, int skill)
	{
		
		player = name;
		value = skill;
		victory = 0;
		challenger = null;
		
	}
	
	public String getName()
	{
		return player;
	}
	
	public int getSkill()
	{
		return value;
	}
	
	public int getVictory()
	{
		return victory;
	}
	
	public Gladiators getChallenger()
	{
		return challenger;
	}
	
	public void Gladiators()
	{
		
	}
}
