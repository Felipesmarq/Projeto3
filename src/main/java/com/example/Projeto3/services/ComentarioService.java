package com.example.Projeto3.services;

import com.example.Projeto3.entities.Comentario;
import com.example.Projeto3.repositories.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    @Autowired
    public ComentarioService(ComentarioRepository comentarioRepository) {this.comentarioRepository = comentarioRepository;}

    // Criar um novo comentário
    public Comentario createComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> getComentariosByFeedbackId(Long feedbackId) {
        return comentarioRepository.findByFeedback_IdFeedback(feedbackId);
    }

}
