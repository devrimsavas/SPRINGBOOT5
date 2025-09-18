//this controller has basic methods 

package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {

    @GetMapping("/")
    public String Hello() {
        return "hello world";
    }

    @GetMapping("/addnumber/{number1}/{number2}")
    public float addNumber(@PathVariable float number1, @PathVariable float number2) {
        float result=number1+number2;
        return result;


    }
    @PostMapping("/reverse") 
    public String getReverse(@RequestBody ReverseText reverseText) {
       
       return reverseText.reverse();
        
    }
    
}
