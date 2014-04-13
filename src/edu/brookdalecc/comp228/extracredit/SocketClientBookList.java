package edu.brookdalecc.comp228.extracredit;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import edu.brookdalecc.comp228.book.Book;

public class SocketClientBookList {

	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		Socket socket = null;
		List<Book> booklist;
		
		try{
			// open a socket connection
			socket = new Socket("127.0.0.1", 3210); // or "localhost"
			// open I/O streams for objects
			ois = new ObjectInputStream(socket.getInputStream());
			// reads an object from the server
			booklist = (LinkedList<Book>)ois.readObject();
			System.out.println(booklist.size());
			Iterator<Book> bookIt = booklist.iterator();
			while(bookIt.hasNext()){
				System.out.println(bookIt.next());
			}
			oos.close();
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
