package ru.vsu.cs.springboot.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductFromDeliveryDTO {
    private String id;
    private int amount;
}
