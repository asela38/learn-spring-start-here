package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

@Service
@ComponentScan(basePackages =  {"services", "aspects", "annotations"})
@EnableAspectJAutoProxy
public class ProjectConfiguration {
}
