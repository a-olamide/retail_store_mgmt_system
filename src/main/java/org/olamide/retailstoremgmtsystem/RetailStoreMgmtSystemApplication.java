package org.olamide.retailstoremgmtsystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RetailStoreMgmtSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RetailStoreMgmtSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello There!\nWelcome to Zonama Retail Store Mgmt System Application");
        System.out.println("To fetch the list of product go to http://localhost:8080/zrsms/api/v1/products");
    }
}
