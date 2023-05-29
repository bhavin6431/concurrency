package org.hariom.concurrency.synchronizers.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class Client {
	public static void main(String[] args) {
		Runnable barrierAction = () -> System.out.println("do the combination...");
		CyclicBarrier barrier = new CyclicBarrier(3, barrierAction);
		for (int i = 1; i <= 5; i++) {
			MeetAtBarrier t = new MeetAtBarrier(barrier, i);
			t.start();
		}
	}
}
