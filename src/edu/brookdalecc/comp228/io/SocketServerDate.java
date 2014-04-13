package edu.brookdalecc.comp228.io;

import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Date;

public class SocketServerDate {

	public static void main(String[] args) {
		ServerSocket server;
		Socket client = null;
		ObjectOutputStream oos = null;
		try{
			server = new ServerSocket(3000);
			System.out.println("Waiting for connections.");
			client = server.accept(); // wait indefinitely
			System.out.println("Accepted a connection from: " + client.getInetAddress());
			oos = new ObjectOutputStream(client.getOutputStream());
			oos.writeObject(new Date()); // serializable - tag interface
			oos.close();
			client.close();
		} catch(Exception e){
			System.out.println(e.getMessage());
			System.exit(-1);
		}

	}

}
