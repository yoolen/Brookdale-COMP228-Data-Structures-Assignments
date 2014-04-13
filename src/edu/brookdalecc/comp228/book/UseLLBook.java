package edu.brookdalecc.comp228.book;

public class UseLLBook {

	public static void main(String[] args) {
	// Testing the Book class and equals() method
		Book b1 = null, b2 = null, b3 = null, b4 = null;
		try{
			b1 = new Book(90, true, "Lord of the Flies", 8.99);
			b2 = new Book(287, true, "The Grand Design", 15.40);
			b3 = new Book(300, false, "Fahrenheit 451", 9.99);
			b4 = new Book(300, false, "Fahrenheit 451", 9.99);
		}catch(BookException be){
			System.err.println(be.getMessage());
		}
		
		System.out.println("b1:\n" + b1);
		System.out.println("b2:\n" + b2);
		System.out.println("b3:\n" + b3);
		
		if(b1.equals(b2)){
			System.out.println("b1 and b2 are equal!");
		}
		else{
			System.out.println("b1 and b2 are NOT equal!");
		}
		
		if(b3.equals(b4)){
			System.out.println("b3 and b4 are equal!");
		}
		else{
			System.out.println("b3 and b4 are NOT equal!");
		}
	// Testing LinkedBookLog, BookLogInterface and LLBookNode
		LinkedBookLog library = new LinkedBookLog("Library");
		System.out.println("\n" + library.getName());
		library.insert(b1); // The order these books are inserted should be reflected in
		library.insert(b2); // the order they are printed out (LIFO).
		System.out.println(String.format("There are currently %d books in %s.\n",library.size(),library.getName())); // test size() method
		System.out.println(library); // Uses the toString methods of both Book and LinkedBookLog, b2 should come first
				
		Book b5 = null, b6 = null; // Make some new books
		try{
			b5 = new Book(110, true, "The Girl with the Dragon Tattoo", 14.99);
			b6 = new Book(300, false, "The Hobbit", 19.25);
		}catch(BookException be){
			System.err.println(be.getMessage());
		}
		library.insert(b3);
		
		// This is pretty much a uniqInsert() method, it's here to test contains()
		if(library.contains(b4)){
			System.out.println("Book already exists!");
		}
		else{
			library.insert(b4);
		}
		
		library.insert(b5); // These books should add with no problems.
		library.insert(b6);
		
		System.out.println(String.format("There are currently %d books in %s.",library.size(),library.getName()));
		// Should give us 5 books, listed in reverse order of insertion
		System.out.println(library);
		
		library.clear(); // Test clear method
		System.out.println(String.format("There are currently %d books in %s.",library.size(),library.getName()));
		// Should give us 0 books
		System.out.println(library);
	}
}
