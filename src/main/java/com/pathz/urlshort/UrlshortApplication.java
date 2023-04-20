package com.pathz.urlshort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class UrlshortApplication {

    public static void main(String[] args) {
        SpringApplication.run(UrlshortApplication.class, args);
    }

}
