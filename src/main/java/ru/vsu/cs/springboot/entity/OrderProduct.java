package ru.vsu.cs.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OrderProduct")
public class OrderProduct {
    @Id
    private Integer id;

    private Integer orderId;
    private String productId;
    private Integer amount;
}
