package com.app2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(App.class, args);
        HelloWorld hw = (HelloWorld) ctx.getBean("helloWorld");
        System.out.print(hw.hello());
    }
}