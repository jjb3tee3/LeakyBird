package com.rithium.leakybird.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient extends Thread implements Runnable {
	private static TCPClient instance;
	
	public static TCPClient getInstance() {
		if(instance == null)
			instance = new TCPClient();
		
		return instance;
	}

	private static final int SERVER_PORT = 11011;
	private Socket socket;
	
	public TCPClient() {
		
	}
	
	public void startClient() {
		InetAddress addr;
		try {
			addr = InetAddress.getByName("192.168.0.12");
			socket = new Socket(addr, SERVER_PORT);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		this.startClient();
	}
}
