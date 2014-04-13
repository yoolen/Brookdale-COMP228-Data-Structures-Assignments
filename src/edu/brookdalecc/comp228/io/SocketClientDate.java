package edu.brookdalecc.comp228.io;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class SocketClientDate {

	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		Socket socket = null;
		Date date = null;
		
		try{
			// open a socket connection
			socket = new Socket("127.0.0.1", 3000); // or "localhost"
			// open I/O streams for objects
			ois = new ObjectInputStream(socket.getInputStream());
			// reads an object from the server
			date = (Date)ois.readObject();
			System.out.println("The date is: " + date);
			// oos.close();
			ois.close();
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
