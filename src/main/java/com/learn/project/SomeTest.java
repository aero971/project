package com.learn.project;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.*;

@RestController
public class SomeTest {
    @GetMapping("")
    public String Test()
    {
        LocalDate ld = LocalDate.now();
        LocalTime time = LocalTime.now();
        return "<h1>Shree swami samarth </h1> <br> Currunt date  = "+ ld +"<br> Currunt time  = "+ time ;
    }
}
