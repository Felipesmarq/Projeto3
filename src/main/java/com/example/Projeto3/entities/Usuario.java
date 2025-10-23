package com.example.Projeto3.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
}
