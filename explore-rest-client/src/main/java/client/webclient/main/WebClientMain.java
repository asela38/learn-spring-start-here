package client.webclient.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication(scanBasePackages = {"client.webclient","aspects"})
public class WebClientMain {
    public static void main(String[] args) {
        System.setProperty("server.port", "9080");
        SpringApplication.run(WebClientMain.class, args);
    }
}
