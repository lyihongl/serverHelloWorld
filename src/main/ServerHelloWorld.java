package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHelloWorld {
	
	public static void main(String[] args) throws IOException {
		Client client = new Client();
		client.cli_main(2901, "129.97.124.70");
	}
}
