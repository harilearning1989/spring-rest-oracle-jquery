package com.web.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringJQueryApplication implements CommandLineRunner {

    public static void main(String[] args) {

        //SpringApplication.run(SpringJQueryApplication.class, args);

        ApplicationContext ctx = SpringApplication.run(SpringJQueryApplication.class, args);

        System.out.println("NinjaSquare server up and running with Spring Boot!");
        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("SpringJQueryApplication===");//+Thread.currentThread().getName());
    }
}
