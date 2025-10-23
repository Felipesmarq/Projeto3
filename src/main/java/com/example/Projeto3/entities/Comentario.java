package com.example.Projeto3.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Table(name = "comentario")
@Entity
@Getter
@Setter
@NoArgsConstructor

public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idComentario;

    private String titulo;
    private String menasagem;
    @ManyToOne
    @JoinColumn(name = "idFeedback")
    private Feedback feedback;

    private LocalDateTime data;
}
