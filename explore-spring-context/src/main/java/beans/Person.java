package beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class Person {

    @Autowired
    public Person(Parrot parrot) {
        this.parrot = parrot;
    }

    private String name = "Ella";

    private final Parrot parrot;
}
