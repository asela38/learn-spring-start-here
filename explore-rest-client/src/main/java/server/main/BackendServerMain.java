package server.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"server", "aspects" })
public class BackendServerMain {
    public static void main(String[] args) {
        SpringApplication.run(BackendServerMain.class, args);
    }
}
