package com.ravi.ch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomThreadInterface implements Runnable{
    public static final Logger logger = LoggerFactory.getLogger(CustomThreadInterface.class);
    @Override
    public void run(){
        logger.info("We are implementing runnable with {} thread",Thread.currentThread().getName());
    }
}
