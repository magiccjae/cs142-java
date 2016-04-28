
public class Fightsong {
	
	public static void main (String[] args) {

	{
		String fightsong = (
				"\t\t\tBYU Fight Song"+
				
				"\n\nRise all loyal cougars and hurl your challenge to the foe. " +
				"\nYou will fight, day or night, rain or snow. "+"\nLoyal, strong, and true Wear the white and blue. "
				+"\nWhile we sing, get set to spring. "+"Come on Cougars it's up to you. Oh!"

				+"\n\nRise and shout, the Cougars are out"
				+"along the trail to fame and glory. "
				+"\nRise and shout, our cheers will ring out "
				+"As you unfold your vict'ry story. "
				
				+"\n\nOn you go to vanquish the foe for Alma Mater's sons and daughters. "
				+"\nAs we join in song, in praise of you, our faith is strong. "
				+"\nWe'll raise our colors high in the blue "
				+"And cheer our Cougars of BYU." 
				);
		
		int b = fightsong.indexOf("b");
		int y = fightsong.indexOf("y");
		int u = fightsong.indexOf("u");
		
	    System.out.println(fightsong+"\n");
		
		System.out.println("The index of b: " +b);
		System.out.println("The index of y: " +y);
		System.out.println("The index of y: " +u);
		
		
		int length = fightsong.length();
		System.out.println("\nThe length of the BYU fight song: " +length);
		
		String Uppercase = fightsong.toUpperCase();
	    System.out.println("\n" +Uppercase);
	    
	    String replace = fightsong.replace('b', 'o');
	    String replace1 = replace.replace('y', 'p');
	    String replace2 = replace1.replace('B', 'O');
	    String replace3 = replace2.replace('Y', 'P');
	    System.out.println("\n" +replace3);
	    
	    int opu = replace3.indexOf("OPU");
	    System.out.println("\nThe index of OPU: " +opu);
	    
	}
	}
}
	
