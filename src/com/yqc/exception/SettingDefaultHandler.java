package com.yqc.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SettingDefaultHandler {
	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler(new MyUncugtExceptionHandler());
		ExecutorService exec=Executors.newCachedThreadPool();
		exec.execute(new ExceptionThread());
	}
}