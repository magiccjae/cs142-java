import java.util.Scanner;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter player one's name: ");
		String yourName = scan.next();
				
		System.out.print("Enter "+yourName+"\'s skill: ");
		int skill = scan.nextInt();
		
		System.out.print("Enter "+yourName+"\'s maximum turn time: ");
		int maxTime = scan.nextInt();
		
		Contestant p1 = new Contestant(yourName, skill, maxTime);
		
		System.out.print("Enter player two's name: ");
		yourName = scan.next();
		
		System.out.print("Enter "+yourName+"\'s skill: ");
		skill = scan.nextInt();
		
		System.out.print("Enter "+yourName+"\'s maximum turn time: ");
		maxTime = scan.nextInt();
		
		Contestant p2 = new Contestant(yourName, skill, maxTime);
		
		System.out.print("Enter the initial clock time : ");
		int clockTime = scan.nextInt();
		System.out.println();
		
		
		CheckersTable game = new CheckersTable(p1, p2, clockTime);
		
		game.simulateGame();
		
		String move = game.getMoveHistory();
		System.out.print(move);
		
		Contestant winner = game.getWinner();
		String realwinner = winner.getName();
		System.out.println();
		
		int timeleft = winner.getClockTime();
		int piecesleft = winner.getNumPieces();
		
		System.out.println("The Winner is "+realwinner);
		System.out.println("The Time left is "+timeleft+" sec");
		System.out.println("The Pieces left is "+piecesleft);
	}

}