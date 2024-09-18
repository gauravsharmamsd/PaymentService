package org.payment.gui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})

public class GuiApplication {
    public static void main(String[] args) {

        SpringApplication.run(GuiApplication.class, args);
    }

}
