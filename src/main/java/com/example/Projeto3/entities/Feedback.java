package com.example.Projeto3.entities;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Table(name = "feedback")
@Entity
@Getter
@Setter
@NoArgsConstructor

public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFeedback;

    private String titulo;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private String mensagem;
    private LocalDateTime data = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Status status;
}
