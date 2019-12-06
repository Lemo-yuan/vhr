package com.lemo.vhrmaster;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.lemo.vhrmaster.mapper")
@EnableCaching
public class VhrMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(VhrMasterApplication.class, args);
    }

}
