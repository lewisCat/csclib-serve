package com.csclib;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.csclib.mapper")
@SpringBootApplication
public class CsclibServeApplication {

  public static void main(String[] args) {
    SpringApplication.run(CsclibServeApplication.class, args);
  }
}
