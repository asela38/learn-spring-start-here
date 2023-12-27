package main;

import configs.ProjectConfigurations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackageClasses = ProjectConfigurations.class)
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
