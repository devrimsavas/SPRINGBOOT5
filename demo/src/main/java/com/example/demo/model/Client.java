package com.example.demo.model;

import java.util.regex.Pattern;

public class Client {

    private final int clientNo;    
    private String name;   
    
    private static final Pattern NON_ALNUM=Pattern.compile("[^a-zA-Z0-9]");   

    public Client(int clientNo) {
        if (clientNo<=0) throw new IllegalArgumentException("Client Number must be positive");
        this.clientNo=clientNo;
    }

    //name 
    public void setName(String name) {             
        if (name == null) throw new IllegalArgumentException("Enter a valid name");
        String v=name.trim();
        if (v.isEmpty() || NON_ALNUM.matcher(v).find()) {
            throw new IllegalArgumentException("Enter a valid name");
        }    
        this.name=v;   
    }

    public String getName() {
        return name;
    }

    public Integer getClientNo() {
        return clientNo;
    }

   
}



