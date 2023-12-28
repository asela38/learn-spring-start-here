package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Payment {
    private String id;
    private double amount;
}
