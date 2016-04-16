//package com.net.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send implements Runnable {

	private DatagramSocket ds;
	public Send(DatagramSocket ds) {
		this.ds=ds;
		// TODO 自动生成的构造函数存根
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		System.out.println("发送端启动...000...");
		try {
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
			String line = null;

			while((line=bufr.readLine())!=null){
				byte[] buf = line.getBytes();
				DatagramPacket dp = 
						new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.255"),10001);
				ds.send(dp);			
				if("886".equals(line))
					break;
			}
			
			ds.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
