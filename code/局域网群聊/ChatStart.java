//package com.net.chat;

import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatStart {

	public static void main(String[] args) throws SocketException {
		// TODO 自动生成的方法存根
		DatagramSocket send = new DatagramSocket();
		DatagramSocket rece = new DatagramSocket();
		new Thread(new Send(send)).start();
		new Thread(new Rece(rece)).start();	
	}

}
