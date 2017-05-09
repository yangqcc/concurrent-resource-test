package com.yqc.beforePractice.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFuture {
	public static void main(String[] args) {
		ExecutorService threadPool= Executors.newSingleThreadExecutor();
		Future<String> future=threadPool.submit(
				new Callable<String>(){
					@Override
					public String call() throws Exception {
						Thread.sleep(2000);
						return "hello";
					}
					
				}
				);
		System.out.println("�ȴ����");
		try {
			System.out.println("�õ������"+future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}