package com.example.Projeto3.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

public class Comentario {
    private String titulo;
    private String menasagem;
    private long id_Comentario;
    private LocalDateTime data;
}
