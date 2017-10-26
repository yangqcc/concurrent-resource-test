package com.yqc.beforePractice.demo;

import java.util.concurrent.*;

public class CallableAndFuture {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future = threadPool.submit(
                new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        Thread.sleep(2000);
                        return "hello";
                    }

                }
        );
        System.out.println("等待结果");
        try {
            System.out.println("拿到结果：" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
