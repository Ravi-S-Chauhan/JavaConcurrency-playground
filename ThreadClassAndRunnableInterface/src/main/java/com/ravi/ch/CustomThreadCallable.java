package com.ravi.ch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.Callable;

public class CustomThreadCallable implements Callable<String> {

    private static final Logger logger = LoggerFactory.getLogger(CustomThreadCallable.class);

    @Override
    public String call(){
        logger.info("Thread {} entered to the call method",Thread.currentThread().getName());
        logger.info("Thread {} exiting from the call method", Thread.currentThread().getName());
        return "Complete Execution for"+ Thread.currentThread().getName();
    }
}
