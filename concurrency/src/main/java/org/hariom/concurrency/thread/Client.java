package org.hariom.concurrency.thread;

public class Client {
	public static void main(String args[]) {
		new Thread(new MyRunnable()).start();
		(new MyThread()).start();
	}
}
