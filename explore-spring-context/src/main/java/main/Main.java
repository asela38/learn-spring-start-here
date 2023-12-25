package main;

import config.ProjectConfiguration;
import config.ProjectConfiguration2;
import config.ProjectConfiguration3;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration3.class);
        
        Person person = context.getBean(Person.class);
        Parrot parrot = context.getBean(Parrot.class);
        System.out.println("parrot.getName() = " + parrot.getName());
        System.out.println("person.getName() = " + person.getName());
        System.out.println("person.getParrot() = " + person.getParrot());
        
    }

    private static void chapter2() {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        Parrot parrot = context.getBean("parrot", Parrot.class);
        System.out.println(parrot.getName());
        System.out.println(parrot);

        String string = context.getBean(String.class);
        System.out.println(string);

        Integer integer = context.getBean(Integer.class);
        System.out.println(integer);


        IntStream.range(0,10).peek(i -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                })
                .mapToObj(i -> context.getBean(LocalDateTime.class))
                .forEach(time -> System.out.println(time));


        context.registerBean("newParrot", Parrot.class, () -> {
            Parrot parrot1 = new Parrot();
            parrot1.setName("Nini");
            return parrot1;
        });
        Parrot parrot1 = context.getBean("newParrot", Parrot.class);
        System.out.println(parrot1.getName());
    }
}
