package com.mainacad.service;

import java.util.List;

public class AdditionalService {

    private List<String> logins;

    public void addText(String text){
        logins.add(text);
    }

    public AdditionalService(List<String> logins) {
        this.logins = logins;
    }
}
