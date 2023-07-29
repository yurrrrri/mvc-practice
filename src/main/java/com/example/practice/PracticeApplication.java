package com.example.practice;

import com.example.practice.webCalculator.CustomWebApplicationServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class PracticeApplication {

    public static void main(String[] args) throws IOException {
        new CustomWebApplicationServer(8080).start();
    }

}