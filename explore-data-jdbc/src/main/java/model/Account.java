package model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
@Builder
@Getter
@Setter
public class Account {
    @Id
    private long id;
    private String name;
    private BigDecimal amount;
}
