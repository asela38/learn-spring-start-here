package model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Builder
@Getter
@Setter
public class Account {
    private long id;
    private String name;
    private BigDecimal amount;
}
