package ru.vsu.cs.springboot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

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
    private int shopId;
    private int loaderId;
    private Date date;
    private String status;

    public Order(int shopId, int loaderId, Date date, String status) {
        this.shopId = shopId;
        this.loaderId = loaderId;
        this.date = date;
        this.status = status;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId(){
        return this.id;
    }
}
