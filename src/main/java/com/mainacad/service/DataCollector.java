package com.mainacad.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DataCollector {

    private static ConcurrentHashMap<AtomicLong, String> cache = new ConcurrentHashMap<>();


    public static void addDataByKey(AtomicLong key, String value) {
        cache.put(key, value);
    }

    public static void storeDataByTime(Long time) {
        cache.keySet().stream().filter(it -> it.get() >= time).forEach(it -> System.out.println(cache.get(it)));
    }

}
