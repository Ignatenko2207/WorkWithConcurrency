package com.mainacad.service;

import java.util.Date;

public class ConcurrentDataCreator extends Thread {

    @Override
    public void run() {
        Long currentTime = System.currentTimeMillis();
        DataCollector.addDataByKey(currentTime, new Date(currentTime).toString());
    }
}
