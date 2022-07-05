package com.trusause.productcenter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ProductCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCenterApplication.class, args);
    }

    @Value("${server.port}")
    private String prot;

    @Value("${spring.application.name}")
    private String name;

    @GetMapping("/getInfo")
    public String getServerPortAndName() {
        return this.name + ":" + this.prot;
    }

}
