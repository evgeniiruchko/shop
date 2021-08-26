package ru.garant21.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "ru.garant21")
@SpringBootApplication(scanBasePackages = "ru.garant21")
public class MsOrdersApplication {

    public static void main(String[] args) {
        System.out.println("test");
        SpringApplication.run(MsOrdersApplication.class, args);
    }

}
