package edu.brookdalecc.comp228.book;
/* Terry Chern
 * Comp 228-800RL
 * 26 February 2014
 * Professor Kamp
 * Assignment 3: Book Class
 */

public class UseBook {

	public static void main(String[] args) {
		Book b1 = null, b2 = null, b3 = null, b4 = null;
		try{ // Test title preconditions using constructor
			b1 = new Book(90, true, "Lord of the Flies", 8.99); // This is okay
			System.out.println(b1);
			b2 = new Book(287, true, null, 15.40); // This is not
			System.out.println(b2);
		}catch(BookException be){
			System.err.println(be.getMessage());
		}
		
		try{ // Test setHardBack(), there's no precondition here though
			b2 = new Book(287, true, "Catcher in the Rye", 4.99);
			System.out.println(b2);
			b2.setHardBack(false);
			System.out.println(b2);
		}catch(BookException be){
			System.err.println(be.getMessage());
		}
		
		try{ // Test page number preconditions
			b3 = new Book(500, false, "Wicked", 29.95);
			System.out.println(b3);
			b3.setNumberOfPages(100); // This works
			System.out.println(b3);   // toString() uses all accessors.
			b3.setNumberOfPages(-9);  // This doesn't work and throws and exception
			System.out.println(b3);
		}catch(BookException be){
			System.err.println(be.getMessage());
		}
		
		try{ // Test price preconditions
			b4 = new Book(299, false, "Choke", 9.98); // Create a new book
			System.out.println(b4);
			b4.setNumberOfPages(400); // This works
			System.out.println(b4);
			b4.setPrice(-19.25); // This fails and throws an exception.
			System.out.println(b4);
		}catch(BookException be){
			System.err.println(be.getMessage());
		}
	}
}
