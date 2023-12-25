package config;

import main.Parrot;
import main.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration
@ComponentScan(basePackages = "main")
public class ProjectConfiguration2 {

    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("Ella");
        person.setParrot(parrot());
        return person;

    }

    @Bean
    public Parrot parrot() {
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }


}
