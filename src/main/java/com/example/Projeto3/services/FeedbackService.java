package com.example.Projeto3.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Projeto3.entities.Feedback;
import com.example.Projeto3.repositories.FeedbackRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> listarTodos() {
        return feedbackRepository.findAll();
    }

    public Feedback buscarPorId(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    public Feedback salvar(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Feedback atualizar(Long id, Feedback feedbackAtualizado) {
        Feedback feedbackExistente = feedbackRepository.findById(id).orElse(null);
        if (feedbackExistente != null) {
            feedbackExistente.setTitulo(feedbackAtualizado.getTitulo());
            feedbackExistente.setMensagem(feedbackAtualizado.getMensagem());
            feedbackExistente.setCategoria(feedbackAtualizado.getCategoria());
            feedbackExistente.setStatus(feedbackAtualizado.getStatus());
            return feedbackRepository.save(feedbackExistente);
        }
        return null;
    }

    public void deletar(Long id) {
        feedbackRepository.deleteById(id);
    }
}