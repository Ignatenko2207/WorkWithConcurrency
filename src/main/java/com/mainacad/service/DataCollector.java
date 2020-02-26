package com.mainacad.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataCollector {

    private static ConcurrentHashMap<Long, String> cache = new ConcurrentHashMap<>();


    public static void addDataByKey(Long key, String value) {
        cache.put(key, value);
    }

    public static void storeDataByTime(Long time) {
        cache.keySet().stream().filter(it -> it >= time).forEach(it -> System.out.println(cache.get(it)));
    }

}
