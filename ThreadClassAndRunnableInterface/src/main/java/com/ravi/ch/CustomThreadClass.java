package com.ravi.ch;

public class CustomThreadClass extends Thread{
    @Override
    public void run(){
        System.out.println("This is inside run method "+Thread.currentThread().getName());
    }
}
