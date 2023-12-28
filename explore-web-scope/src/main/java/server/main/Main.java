package server.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"controllers", "services"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
