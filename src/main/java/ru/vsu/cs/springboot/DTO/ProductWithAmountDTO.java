package ru.vsu.cs.springboot.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithAmountDTO {
    private String id;
    private String name;
    private int amount;
}
