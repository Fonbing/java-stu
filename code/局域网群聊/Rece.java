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
		// TODO �Զ����ɵķ������
		System.out.println("�����ҽ��ն���������yy,,���Ͷ�����886�˳�");
		try {
			ds = new DatagramSocket(10001);
			while (true) {
				byte[] bt = new byte[1024];
				DatagramPacket dp = new DatagramPacket(bt, bt.length);
				ds.receive(dp);
				String ip = dp.getAddress().getHostAddress();
				int port = dp.getPort();
				String text = new String(dp.getData(), 0, dp.getLength());
				System.out.println("���Ͷ�IP��ַΪ��" + ip + ",�˿�Ϊ��" + port
						+ ",\n����Ϊ��" + text);
				if ("886".equals(text))
					break;
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}
}
