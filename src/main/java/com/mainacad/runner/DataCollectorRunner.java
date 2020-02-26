package com.mainacad.runner;

import com.mainacad.service.ConcurrentDataCreator;
import com.mainacad.service.ConcurrentDataExtractor;

import java.util.concurrent.atomic.AtomicLong;

public class DataCollectorRunner {

    private static AtomicLong lastExtractionTime = new AtomicLong(System.currentTimeMillis());

    public static void main(String[] args) {
        Long endTime = System.currentTimeMillis() + (1000*60*3);

        Long creationTime = System.currentTimeMillis() - (1000*15);
        Long extractionTime = System.currentTimeMillis() - (1000*45);

        do {
            Long currentTime = System.currentTimeMillis();
            if ((currentTime - creationTime) > (1000*15)) {
                ConcurrentDataCreator concurrentDataCreator = new ConcurrentDataCreator();
                concurrentDataCreator.start();
                creationTime = currentTime;
            }

            if ((currentTime - extractionTime) > (1000*45)) {
                ConcurrentDataExtractor concurrentDataExtractor = new ConcurrentDataExtractor(lastExtractionTime.get());
                concurrentDataExtractor.start();
                extractionTime = currentTime;
                lastExtractionTime.set(extractionTime);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (System.currentTimeMillis()<= endTime);




    }
}
