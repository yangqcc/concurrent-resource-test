package com.yqc.sisuo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 解决死锁，最后一个哲学家先拿左边，再拿右边，其他哲学家先拿右边，再拿左边
 *
 * @author yangqc 2016年7月26日
 */
public class FixedDiningPhilosophers {
	public static void main(String[] args) throws InterruptedException {
		int ponder = 5;
		if (args.length > 0) {
			ponder = Integer.parseInt(args[1]);
		}
		int size = 5;
		if (args.length > 1) {
			size = Integer.parseInt(args[1]);
		}
		ExecutorService exec = Executors.newCachedThreadPool();
		Chopstick[] sticks = new Chopstick[5];
		for (int i = 0; i < size; i++) {
			sticks[i] = new Chopstick();
		}
		for (int i = 0; i < size; i++) {
			if (i < size - 1) {
				exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, ponder));
			} else {
				exec.execute(new Philosopher(sticks[0], sticks[5], i, ponder));
			}
		}
		if (args.length == 3 && args[2].equals("timeout")) {
			TimeUnit.SECONDS.sleep(5);
		}
		exec.shutdown();
	}
}
