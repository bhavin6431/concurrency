package org.hariom.concurrency.synchronizers.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Client {
	public static void main(String args[]) {
		int slots = 10;
		ExecutorService executorService = Executors.newFixedThreadPool(slots);
		LoginQueueUsingSemaphore loginQueue = new LoginQueueUsingSemaphore(slots);

		IntStream.range(0, slots).forEach(user -> executorService.execute(loginQueue::tryLogin));
		executorService.shutdown();
		System.out.println(loginQueue.availableSlots());
		System.out.println(loginQueue.tryLogin());

		loginQueue.logout();
		loginQueue.logout();

		System.out.println(loginQueue.availableSlots());
		System.out.println(loginQueue.tryLogin());

	}
}
