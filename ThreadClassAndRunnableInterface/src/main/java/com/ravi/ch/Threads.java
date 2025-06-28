package com.ravi.ch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Threads {

    private static final Logger logger = LoggerFactory.getLogger(Threads.class);

    private int findPower(int n, int x){
        if (n == 0) return x >= 1?1:0;
        if (x == 0) return 1;
        if (x == 1) return n;
        if ((x&1) == 1) {
            return n * findPower(x-1,n);
        } else {
            return findPower(n*n,x/2);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CustomThreadClass thread1 = new CustomThreadClass(5);
        CustomThreadClass thread2 = new CustomThreadClass(10);

        thread1.start();
        thread2.start();

        logger.info("{} creates thread via extending Thread",thread1);

        CustomThreadInterface runnable = new CustomThreadInterface();
        Thread thread3 = new Thread(runnable);

        thread3.start();

        logger.info("{} creates new thread by CustomThreadInterface and we pass the custom runnable"
                ,thread2);

        CustomThreadCallable callable = new CustomThreadCallable();
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> future = executor.submit(callable);

        logger.info("The result we got from override callable is `{}`",future.get());

        logger.info("{} created a new Executor using Executor.newFixedThreadPool",executor);
    }
}