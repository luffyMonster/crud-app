package com.dn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.dn.config.JpaConfig;

@Import(JpaConfig.class)
@SpringBootApplication(scanBasePackages={"com.dn"})
public class StudentManagamentApp {
    public static void main(String[] args) {
        SpringApplication.run(StudentManagamentApp.class, args);
    }
}
