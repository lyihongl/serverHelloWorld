package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerConnection extends Thread {
	private Socket socket = null;
	private BufferedReader in = null;
	private PrintWriter out = null;

	public ServerConnection(Socket s) throws IOException {
		socket = s;
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(1);
		}
		start();
	}

	public void run() {
		System.out.println("client accepted from: " + socket.getInetAddress() + ":" + socket.getPort());
		String input, output;
		Scanner scan = new Scanner(System.in);

		try {
//				System.out.println("AAA");
				while ((input = in.readLine()) != null) {
//					System.out.println("A");
					System.out.println("Request: " + input);

//					out.println("I've recieve: " + input);
					out.println("Server has recieved: "+input);
					out.flush();
//					out.print(scan.nextLine());
					System.out.println("Out printed");
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Server ending");
		out.close();
		try {
			in.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}