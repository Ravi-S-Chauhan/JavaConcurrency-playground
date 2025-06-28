package com.ravi.ch;

public class Threads {
    public static void main(String[] args) {
        CustomThreadClass thread1 = new CustomThreadClass();
        CustomThreadClass thread2 = new CustomThreadClass();
        thread1.start();
        thread2.start();
    }
}