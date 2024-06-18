package ru.vsu.cs.springboot.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoDTO {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private Date birthday;
    private String role;

}
