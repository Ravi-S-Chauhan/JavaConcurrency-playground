package com.ravi.ch;

import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(6);
        IntConsumer printNumber = x -> System.out.println(x);
        Thread t1 = new Thread(()-> {
            try {
                zeroEvenOdd.zero(printNumber);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(()-> {
            try {
                zeroEvenOdd.odd(printNumber);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(()-> {
            try {
                zeroEvenOdd.even(printNumber);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }
}