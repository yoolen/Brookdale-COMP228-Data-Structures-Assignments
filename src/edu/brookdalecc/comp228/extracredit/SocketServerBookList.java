package edu.brookdalecc.comp228.extracredit;

import java.io.ObjectOutputStream;
import java.net.*;
import java.util.LinkedList;
import java.util.List;

import edu.brookdalecc.comp228.book.*;

public class SocketServerBookList {

	public static void main(String[] args) {
		ServerSocket server;
		Socket client = null;
		ObjectOutputStream oos = null;
		List<Book> booklist = new LinkedList<Book>();
		Book b1=null, b2=null, b3=null, b4=null, b5=null, b6=null;
		try{ // Test title preconditions using constructor
			b1 = new Book(90, true, "Lord of the Flies", 8.99); // This is okay
			b2 = new Book(287, true, "Catcher in the Rye", 4.99);
			b3 = new Book(500, false, "Wicked", 29.95);
			b4 = new Book(299, false, "Choke", 9.98);
			b5 = new Book(1000, true, "War and Peace", 8.49);
			b6 = new Book(329, false, "The Silmarillion", 6.78);
		}catch(BookException be){
			System.err.println(be.getMessage());
		}
		booklist.add(b1);
		booklist.add(b2);
		booklist.add(b3);
		booklist.add(b4);
		booklist.add(b5);
		booklist.add(b6);
		
		try{
			server = new ServerSocket(3210);
			System.out.println("Waiting for connections.");
			client = server.accept(); // wait indefinitely
			System.out.println("Accepted a connection from: " + client.getInetAddress());
			oos = new ObjectOutputStream(client.getOutputStream());
			oos.writeObject(booklist); // serializable - tag interface
			oos.close();
			client.close();
		} catch(Exception e){
			System.out.println(e.getMessage());
			System.exit(-1);
		}

	}

}
