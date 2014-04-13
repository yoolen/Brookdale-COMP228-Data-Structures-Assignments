package edu.brookdalecc.comp228.comparisons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import edu.brookdalecc.comp228.book.*;

public class BookArray{
	private BookArray(){};
	
	public static void main(String[] args) {
		Book b1 = null, b2 = null, b3 = null, b4 = null, b5 = null, b6 = null;
		
		// Make some books
		try{ // compareTo method sorts by Title,Pages, Hardback, Price
			b1 = new Book(300,true,"Redwall",9.99);
			b2 = new Book(300,false,"Redwall",10.99);
			b3 = new Book(400,false,"Red Dragon",8.99);
			b4 = new Book(200,false,"Where the Red Fern Grows",3.99);
			b5 = new Book(250,true,"Where's Waldo",8.45);
			b6 = new Book(300,false,"Redwall",10.99);
		} catch(BookException be){
			System.err.println(be.getMessage());
		}

		// Test equals and compareTo for consistency.
		if(b2.compareTo(b6) == 0 && b6.equals(b2)==true){
			System.out.println("Consistent!\n");
		}
		else{
			System.out.println("Inconsistent!\n");
		}
		
		System.out.println("Array:");
		System.out.println("Presort:");
		Book[] bookArray = {b1,b2,b3,b4,b5,b6};
		for(Book book: bookArray){
			System.out.println(book);
		}
		
		Arrays.sort(bookArray); // Use static sort method from Arrays class
		System.out.println("Postsort:");
		for(Book book: bookArray){
			System.out.println(book);
		}
		
		List<Book> bookArrayList = new ArrayList<Book>(); // code to interface
		bookArrayList.add(b1); // Populate the ArrayList with books
		bookArrayList.add(b2);
		bookArrayList.add(b3);
		bookArrayList.add(b4);
		bookArrayList.add(b5);
		bookArrayList.add(b6);
		
		System.out.println("Arraylist:");
		System.out.println("Presort:");
		Iterator<Book> bookIt = bookArrayList.iterator(); // print out the books in order of insertion
		while(bookIt.hasNext()){
			System.out.println(bookIt.next());
		}
		
		Collections.sort(bookArrayList); // sort the ArrayList
		System.out.println("Postsort:");
		bookIt = bookArrayList.iterator(); // print out the books after sorting
		while(bookIt.hasNext()){
			System.out.println(bookIt.next());
		}
	}

}
