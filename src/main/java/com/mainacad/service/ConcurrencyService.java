package com.mainacad.service;

import java.util.List;

public class ConcurrencyService extends Thread{

    private List<String> logins;

    public ConcurrencyService(List<String> logins) {
        this.logins = logins;
    }

    @Override
    public void run() {
        AdditionalService additionalService = new AdditionalService(logins);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        additionalService.addText("some string");
    }

}
