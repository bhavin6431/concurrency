package org.hariom.concurrency.synchronizers.latches;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {
	public static void main(String args[]) throws InterruptedException {
		List<String> outputScraper = Collections.synchronizedList(new ArrayList<String>());

		CountDownLatch countDownLatch = new CountDownLatch(5);

		List<Thread> workers = Stream.generate(() -> new Thread(new Worker(countDownLatch, outputScraper))).limit(5)
				.collect(Collectors.toList());

		workers.forEach(Thread::start);

		countDownLatch.await();

		outputScraper.add("Finished");

		outputScraper.forEach(System.out::println);

	}
}
