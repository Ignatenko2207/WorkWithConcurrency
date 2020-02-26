package com.mainacad.service;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class ConcurrentDataExtractor extends Thread {

    Long lastExtractionTime;

    public ConcurrentDataExtractor(Long lastExtractionTime) {
        this.lastExtractionTime = lastExtractionTime;
    }

    @Override
    public void run() {
        DataCollector.storeDataByTime(lastExtractionTime);
    }
}
