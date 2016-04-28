
// CS 142 WInter 2010 Midterm #2
// JaeHun Lee, 95-225-6535


public class Driver {
	
	public static void main(String[] args) {
		
		PersonList TomList = new PersonList();
		
		PersonList BenList = new PersonList();
		
		TomList.add(new Person("Lionel", "Messi", true));		
		TomList.add(new Person("Frank", "Lampard", true));
		TomList.add(new Person("Fernando", "Torres", false));
		TomList.add(new Person("Fernando", "Torres", false));
		TomList.add(new Person("Frank", "Lampard", true));
		
//		TomList.remove(new Person("Fernando", "Torres", false));
		System.out.println("**Tom's dad's list");
		TomList.printOut();
		
		BenList.add(new Person("Lionel", "Messi", true));
		BenList.add(new Person("Zinedine", "Zidane", true));
		BenList.add(new Person("Zinedine", "Zidane", true));
		BenList.add(new Person("Zinedine", "Zidane", false));
		BenList.add(new Person("Fernando", "Torres", false));

//		BenList.remove(new Person("Lionel", "Messi", true));
		
		System.out.println();
		System.out.println("**Ben's dad's list");
		BenList.printOut();
		
		System.out.println();
		System.out.println("**Prospective participants in Tom's dad's list");
		TomList.getSize();
		
		System.out.println();
		System.out.println("**Prospective participants in Ben's dad's list");
		BenList.getSize();
		
		System.out.println();
		System.out.println("**Prospective participants common to both lists");
		TomList.Intersect(BenList);
		
		System.out.println();
		System.out.println("**Prospective participants in either or both lists");
		TomList.Unisect(BenList);
		
		System.out.println();
		System.out.println("**Prospective participants in Tom's dad's list, but not in Ben's dad's list");
		TomList.oneside(BenList);
		
		System.out.println();
		System.out.println("**Prospective participants in Ben's dad's list, but not in Tom's dad's list");
		BenList.oneside(TomList);
		
		// to clear lists
		TomList.clear();
		BenList.clear();
	}
}