package com.example.demo;



public class ReverseText {

    private String text;

    public ReverseText() {}

    public String getText() {return text;}
    public void setText(String text) {this.text=text;}

    public String reverse() {
        String cleaned=text.toLowerCase().replaceAll("\\s+","");
        return new StringBuilder(cleaned).reverse().toString();
    }

        
    
}
