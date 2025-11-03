package com.example.Projeto3.controllers;

import com.example.Projeto3.entities.Comentario;
import com.example.Projeto3.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
@CrossOrigin(origins = "*") // opcional: permite requisições do front-end
public class ComentarioController {

    private final ComentarioService comentarioService;

    @Autowired
    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    // 🔹 Criar um novo comentário
    @PostMapping
    public ResponseEntity<Comentario> createComentario(@RequestBody Comentario comentario) {
        Comentario novoComentario = comentarioService.createComentario(comentario);
        return ResponseEntity.ok(novoComentario);
    }

    // 🔹 Listar todos os comentários de um feedback específico
    @GetMapping("/feedback/{feedbackId}")
    public ResponseEntity<List<Comentario>> getComentariosByFeedbackId(@PathVariable Long feedbackId) {
        List<Comentario> comentarios = comentarioService.getComentariosByFeedbackId(feedbackId);

        if (comentarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(comentarios);
    }
}