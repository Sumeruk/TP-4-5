package ru.vsu.cs.springboot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Users")
public class User implements Identifiable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;
    private String email;
    private String phone;
    private Date birthday;
    private String role;

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
