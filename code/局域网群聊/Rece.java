//package com.net.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Rece implements Runnable {

	private DatagramSocket ds;

	public Rece(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		System.out.println("聊天室接收端启动……yy,,发送端输入886退出");
		try {
			ds = new DatagramSocket(10001);
			while (true) {
				byte[] bt = new byte[1024];
				DatagramPacket dp = new DatagramPacket(bt, bt.length);
				ds.receive(dp);
				String ip = dp.getAddress().getHostAddress();
				int port = dp.getPort();
				String text = new String(dp.getData(), 0, dp.getLength());
				System.out.println("发送端IP地址为：" + ip + ",端口为：" + port
						+ ",\n数据为：" + text);
				if ("886".equals(text))
					break;
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
}
