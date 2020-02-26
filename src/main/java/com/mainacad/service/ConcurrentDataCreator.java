package com.mainacad.service;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class ConcurrentDataCreator extends Thread {

    @Override
    public void run() {
        Long currentTime = System.currentTimeMillis();
        DataCollector.addDataByKey(new AtomicLong(currentTime), new Date(currentTime).toString());
    }
}
