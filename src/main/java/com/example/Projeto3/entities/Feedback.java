package com.example.Projeto3.entities;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class Feedback {
    private String titulo;
    Categoria categoria;
    private String mensagem;
    private LocalDateTime data = LocalDateTime.now();
    private long id_feedback;
    Status status;

    public void deletarFeedback(Feedback feedback) {}

    public Feedback editarFeedback(Feedback feedback) {
        return feedback;
    }
}
