package com.ravi.ch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(60);

        Thread t1 = new Thread(() -> {
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                fizzBuzz.number();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        });

        Thread t4 = new Thread(() -> {
            try {
                fizzBuzz.fizzBuzz();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}