package ru.vsu.cs.springboot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Orders")
public class Order implements Identifiable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int loaderId;
    private Date date;
    private String status;

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId(){
        return this.id;
    }
}
