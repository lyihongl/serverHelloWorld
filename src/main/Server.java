package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
	public static void svr_main(int port) throws IOException{
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(port);
		}catch (Exception e) {
			System.out.println("Could not listen on port: "+port);
			System.exit(1);
		}
		System.out.println("Server ready");
		try {
			while (true) {
				Socket socket = serverSocket.accept();
				try {
					new ServerConnection(socket);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			serverSocket.close();
		}
	}
}
