package com.example.jspapp.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    private Long id;
    private String pseudo;
    private String email;
    private String password;
}
