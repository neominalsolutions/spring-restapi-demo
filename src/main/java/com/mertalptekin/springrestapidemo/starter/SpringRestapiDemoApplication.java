package com.mertalptekin.springrestapidemo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mertalptekin.springrestapidemo"})
@EntityScan(basePackages = {"com.mertalptekin.springrestapidemo"}) // starter package ayırdığımızdan @Entity olarak işaretlenmiş nesneleri bulsun diye
@EnableJpaRepositories(basePackages = {"com.mertalptekin.springrestapidemo"})
public class SpringRestapiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestapiDemoApplication.class, args);
    }

}
