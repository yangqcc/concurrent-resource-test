package com.yqc.beforePractice.test2.ThreadException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }

}
