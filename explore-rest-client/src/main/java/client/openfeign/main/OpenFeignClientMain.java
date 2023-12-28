package client.openfeign.main;

import com.sun.tools.javac.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages = { "client.openfeign", "aspects" })
public class OpenFeignClientMain {
    public static void main(String[] args) {
        System.setProperty("server.port", "9090");
        SpringApplication.run(OpenFeignClientMain.class, args);
    }
}
