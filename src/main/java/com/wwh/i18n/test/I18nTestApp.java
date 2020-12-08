package com.wwh.i18n.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.wwh.i18n.test.dao")
public class I18nTestApp {

    public static void main(String[] args) {
        SpringApplication.run(I18nTestApp.class);
    }
}
