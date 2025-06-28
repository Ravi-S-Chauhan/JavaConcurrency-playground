package com.ravi.ch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomThreadClass extends Thread{

    private static final Logger logger = LoggerFactory.getLogger(CustomThreadClass.class);

    private final int a;
    private int b;

    CustomThreadClass(int a){
        this.a = a;
    }

    @Override
    public void run(){

        b = a*a;
        logger.info("the square of {} is {}",a,b);
    }

    public int getResult(){
        return b;
    }
}
