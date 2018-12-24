package com.shicheng.mis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shicheng.mis.mapper")
public class MisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MisApplication.class, args);
    }

}

