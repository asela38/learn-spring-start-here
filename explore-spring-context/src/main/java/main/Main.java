package main;

import beans.Parrot;
import beans.Person;
import config.ProjectConfiguration4;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfiguration4.class);

        Person person = context.getBean(Person.class);
        Parrot parrot = context.getBean(Parrot.class);
        System.out.println("parrot.getName() = " + parrot.getName());
        System.out.println("person.getName() = " + person.getName());
        System.out.println("person.getParrot() = " + person.getParrot());
    }

}
