package com.yqc.sisuo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ��ѧ�ҽ������������汾
 *
 * @author yangqc 2016��7��26��
 */
public class DeadlockingDiningPhilosophers {
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
			exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, ponder));
		}
		if (args.length == 3 && args[2].equals("timeout")) {
			TimeUnit.SECONDS.sleep(5);
		}
		exec.shutdown();
	}
}