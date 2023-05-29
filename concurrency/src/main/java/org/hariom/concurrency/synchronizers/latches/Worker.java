package org.hariom.concurrency.synchronizers.latches;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Worker implements Runnable {
	private CountDownLatch countDownLatch;
	private List<String> outputScrapper;

	public void run() {
		outputScrapper.add("Latch Down");
		countDownLatch.countDown();
	}

}
