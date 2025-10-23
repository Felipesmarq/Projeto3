package com.example.Projeto3.services;

import com.example.Projeto3.entities.Feedback;
import com.example.Projeto3.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    // Criar um novo feedback
    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    // Obter todos os feedbacks
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    // Obter um feedback por ID
    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    // Atualizar um feedback existente
    public Optional<Feedback> updateFeedback(Long id, Feedback feedbackDetails) {
        Optional<Feedback> optionalFeedback = feedbackRepository.findById(id);

        if (optionalFeedback.isPresent()) {
            Feedback feedbackExistente = optionalFeedback.get();
            feedbackExistente.setTitulo(feedbackDetails.getTitulo());
            feedbackExistente.setMensagem(feedbackDetails.getMensagem());
            feedbackExistente.setCategoria(feedbackDetails.getCategoria());
            feedbackExistente.setStatus(feedbackDetails.getStatus());

            return Optional.of(feedbackRepository.save(feedbackExistente));
        } else {
            return Optional.empty();
        }
    }

    // Deletar um feedback
    public boolean deleteFeedback(Long id) {
        if (feedbackRepository.existsById(id)) {
            feedbackRepository.deleteById(id);
            return true;
        }
        return false;
    }
}