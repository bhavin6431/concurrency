package org.hariom.concurrency.synchronizers.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MeetAtBarrier extends Thread {
	private CyclicBarrier barrier;
	private int ID;

	public void run() {
		try {
			int workTime = 3;
			System.out.println("Thread #" + ID + " is going to work for " + workTime + " seconds");

			Thread.sleep(workTime * 1000);
			System.out.println("Thread #" + ID + " is waiting at the barrier...");
			this.barrier.await();
			System.out.println("Thread #" + ID + " passed the barrier...");
		} catch (Exception e) {
			System.out.println("Barrier is broken...");
		}
	}
}
