package ru.vsu.cs.springboot.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Products")
public class Product implements Identifiable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;
    private Integer quantity;
    private Integer price;
    private Integer weight;
    private String units;
    private String provider;
    private String description;

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId(){
        return this.id;
    }
}