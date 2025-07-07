package com.ravi.ch;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class FizzBuzz {
    private final int num;
    private int count;
    private Semaphore fizzLock;
    private Semaphore buzzLock;
    private Semaphore fizzBuzzLock;
    private Semaphore numLock;

    FizzBuzz(int num){
        this.num = num;
        this.count = 1;
        this.fizzLock = new Semaphore(0);
        this.buzzLock = new Semaphore(0);
        this.fizzBuzzLock = new Semaphore(0);
        this.numLock = new Semaphore(1);
    }

    public void number() throws InterruptedException{
        while(count< num && numLock.tryAcquire(1, TimeUnit.SECONDS)){
            System.out.println(count);
            count++;
            if (count%3 == 0 && count%5 == 0){
                fizzBuzzLock.release();
            } else if (count%3 == 0){
                fizzLock.release();
            } else if (count%5 == 0){
                buzzLock.release();
            } else {
                numLock.release();
            }
        }
    }

    public void fizzBuzz() throws InterruptedException{
        while(count< num && fizzBuzzLock.tryAcquire(1,TimeUnit.SECONDS)){
            System.out.println("FizzBuzz");
            count++;
            numLock.release();
        }
    }

    public void buzz() throws InterruptedException{
        while(count< num && buzzLock.tryAcquire(1, TimeUnit.SECONDS)){
            System.out.println("Buzz");
            count++;
            numLock.release();
        }
    }

    public void fizz() throws InterruptedException{
        while(count< num && fizzLock.tryAcquire(1, TimeUnit.SECONDS)){
            System.out.println("Fizz");
            count++;
            numLock.release();
        }
    }
}
