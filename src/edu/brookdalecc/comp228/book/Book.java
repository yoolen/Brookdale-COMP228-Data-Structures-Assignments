package edu.brookdalecc.comp228.book;

import java.io.Serializable;

/* Terry Chern
 * Comp 228-800RL
 * 2 March 2014
 * Professor Kamp
 * Assignment 4: Book Class and Book-based Linked List
 */
public class Book implements Serializable, Comparable<Book>{
// Attributes - All are private for this class.
	private int numberOfPages;
	private boolean hardBack;
	private String title;
	private double price;

// Constructor	
	public Book(int numberOfPages, boolean hardBack, String title, double price) throws BookException{
	// There is no default constructor for this class (null book doesn't 
	// make sense). If any of the mutator methods fail, exception will
	// be thrown to calling class (driver) where it will be handled.
		this.setNumberOfPages(numberOfPages);
		this.setHardBack(hardBack);
		this.setTitle(title);
		this.setPrice(price);
	}

// Accessors and Mutators
	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) throws BookException{
	// Books can not have less than 1 page.
		if(numberOfPages < 1){
			throw new BookException("# of pages cannot be <1.");
		}
		this.numberOfPages = numberOfPages;
	}

	public boolean getHardBack() {
		return hardBack;
	}

	public void setHardBack(boolean hardBack){
		this.hardBack = hardBack;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) throws BookException{
	// Books must have a title
		if(title==null || title.isEmpty()){ // Must check for null first, or running .isEmpty() would cause an error
			throw new BookException("Book must have a title.");
		}
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws BookException{
	// Can give books away for free, but can't pay people to take them
		if(price < 0){
			throw new BookException("Price cannot be less than 0.");
		}
		this.price = price;
	}
	
// Other Methods	
	@Override
	public boolean equals(Object obj){
	/* The equals method is inherited from the object class and implements an equivalence
	 * relation on NON-NULL object references. The implementation is left to the developer
	 * but it must follow a set of conditions to be properly defined. It should be:
	 * 1)Reflexive: for any non-null reference value x, x.equals(x) should return true.
	 * 2)Symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
	 * 3)Transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
	 * 4)Consistent: for any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, provided no information used in equals comparisons on the objects is modified.
	 * For any non-null reference value x, x.equals(null) should return false, and for null
	 * reference values it should immediately return false.
	 * If the method is not overridden, it implements the most discriminating possible
	 * equivalence relation on objects, that is for non-null references x and y, this only
	 * returns true is x and y refer to the same object.
	 * -Taken from JavaDocs on java.lang.Object
	 */
		if(obj == null){ // If compared object is null do not bother checking
			return false;
		}
		if(!(obj instanceof Book)){ // Different kinds objects cannot be the same
			return false;
		}
		if(obj == this){ // Reflexivity, object is equal to itself
			return true;
		}	
		// Because the original method from the Object class uses Object as its parameter
		// and .equals() is not a generic method we must pass in the Book we are comparing
		// as an Object and cast it into a book.
		if(this.getNumberOfPages() == ((Book)obj).getNumberOfPages() && 
				this.getPrice() == ((Book)obj).getPrice() &&
				this.getHardBack() == ((Book)obj).getHardBack() &&
				this.getTitle() == ((Book)obj).getTitle()){
			// Compare each attribute, starting with the "cheapest" comparisons
			// of primitives and moving on to objects (like Strings) and methods 
			// that must be evaluated.
			return true; // All these attributes must match for the two books to be equal
		}
		else
			return false; // If any attribute of the book is different we return false
	}
	
	@Override
	public int compareTo(Book book) {
		// Compares two books to determine their natural ordering. Books are sorted by
		// Author first, Title second; all other attributes are arbitrary and can be
		// prioritized per user requirements. Given the same book it would make sense
		// to compare the number of pages first. Consulting with my sister (a librarian)
		// we determined that hardcover books are always printed first, making hardcover
		// a chronological indicator. Price will be the final differentiator. Will use
		// the same comparitors as equals().
		if(this.getTitle().compareTo(book.getTitle())!=0){
			return this.getTitle().compareTo(book.getTitle()); // use built in String compareTo
		}
		else if(this.getNumberOfPages() != book.getNumberOfPages()){
			return Integer.compare(this.getNumberOfPages(),book.getNumberOfPages());
			// Use Integer wrapper to compare the two page numbers
		}
		else if(this.getPrice() != book.getPrice()){
			return Double.compare(this.getPrice(), book.getPrice());
			// Use Double wrapper to compare the two prices
		}
		else if(this.getHardBack() != book.getHardBack()){
			return this.getHardBack()?-1:1; 
			// hardbacks come before paperbacks, knowing the covers of the two compared
			// books are not the same means we only need to check for one books status
			// to know the other's (XOR).
		}
		else
			return 0; // if everything is equal return 0, this is consistent with the equals() method.
	}
	
	@Override
	public String toString(){
		return String.format("Title   : %s\nHardback: %s\n#ofPages: %s\nPrice   : %.2f\n",this.getTitle(),this.getHardBack(),this.getNumberOfPages(),this.getPrice());
	}


}
