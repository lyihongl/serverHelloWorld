package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	static Socket echoSocket = null;
	static PrintWriter out = null;
	static BufferedReader in = null;

	public static void cli_main(int port, String serverName) throws IOException {
		Scanner scan = new Scanner(System.in);
		try {
//			System.out.println("A");
			echoSocket = new Socket(serverName, port);
			System.out.println("Socket ip: " + echoSocket.getInetAddress() + " Socket port " + echoSocket.getPort());
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

			out.println("Hello");

			System.out.println("printed to out");
		} catch (UnknownHostException e) {
			System.err.println("Don't know host: " + serverName);
			System.exit(1);
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println("Couldn't get IO for " + serverName);
			System.exit(1);
		}

		System.out.println("Client ready");

		while (true) {
//			System.out.println(in.readLine());
//			System.out.println("A");
			String input = null;
//			System.out.println(in.ready());
			
			
			while((input = in.readLine())!=null) {
				System.out.println("waiting for input");
				out.println(scan.nextLine());
				System.out.println(input);
			}

			if (input == null) {
				System.out.println("Client closing");
				break;
			}

//			String[] tokens = input.split(" ");
		}
		out.close();
		in.close();
		System.out.println("Client closing");
	}

	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.svr_main(2901);

	}

}
