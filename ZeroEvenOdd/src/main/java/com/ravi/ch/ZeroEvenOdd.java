package com.ravi.ch;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private static int number;
    private int counter = 1;
    private static final Semaphore zeroLock = new Semaphore(0);
    private static final Semaphore oddLock = new Semaphore(0);
    private static final Semaphore evenLock = new Semaphore(0);

    ZeroEvenOdd(int num){
        number = num;
    }

    void zero(IntConsumer printNumber) throws InterruptedException {
        while(counter<=number){
            printNumber.accept(0);
            if ((counter&1) == 1){
                oddLock.release();
            } else {
                evenLock.release();
            }
            zeroLock.acquire();
        }
    }

    void odd(IntConsumer printNumber) throws InterruptedException {
        while(counter<=number){
            if (oddLock.tryAcquire(1, TimeUnit.SECONDS)){
                printNumber.accept(counter);
                ++counter;
                zeroLock.release();
            }
        }
    }

    void even(IntConsumer printNumber) throws InterruptedException {
        while(counter<=number){
            if (evenLock.tryAcquire(1,TimeUnit.SECONDS)){
                printNumber.accept(counter);
                ++counter;
                zeroLock.release();
            }
        }
    }
}
