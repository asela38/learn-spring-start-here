package client.resttemplate.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "client.resttemplate", "aspects" })
public class RestTemplateClientMain {
    public static void main(String[] args) {
        System.setProperty("server.port", "7070");
        SpringApplication.run(RestTemplateClientMain.class, args);
    }
}
