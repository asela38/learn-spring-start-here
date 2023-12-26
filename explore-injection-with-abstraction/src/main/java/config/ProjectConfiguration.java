package config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan( basePackages = {"proxies", "services", "repositories"})
public class ProjectConfiguration {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Object prototypeObject() {
        return new Object();
    }
    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public Object singletonObject() {
        return new Object();
    }


}
