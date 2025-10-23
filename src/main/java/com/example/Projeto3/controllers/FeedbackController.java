package com.example.Projeto3.controllers;

import com.example.Projeto3.entities.Feedback;
import com.example.Projeto3.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks") // Define a URL base para este controller
@CrossOrigin(origins = "*") // Permite requisições de qualquer front-end
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    // Endpoint para CRIAR (POST) -> /api/feedbacks
    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {
        Feedback novoFeedback = feedbackService.createFeedback(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFeedback);
    }

    // Endpoint para LER TODOS (GET) -> /api/feedbacks
    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        return ResponseEntity.ok(feedbacks);
    }

    // Endpoint para LER POR ID (GET) -> /api/feedbacks/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
        return feedbackService.getFeedbackById(id)
                .map(ResponseEntity::ok) // Retorna 200 OK se encontrado
                .orElse(ResponseEntity.notFound().build()); // Retorna 404 se não encontrado
    }

    // Endpoint para ATUALIZAR (PUT) -> /api/feedbacks/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable Long id, @RequestBody Feedback feedbackDetails) {
        return feedbackService.updateFeedback(id, feedbackDetails)
                .map(ResponseEntity::ok) // Retorna 200 OK se atualizado
                .orElse(ResponseEntity.notFound().build()); // Retorna 404 se não encontrado
    }

    // Endpoint para DELETAR (DELETE) -> /api/feedbacks/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        if (feedbackService.deleteFeedback(id)) {
            return ResponseEntity.noContent().build(); // 204 No Content se sucesso
        } else {
            return ResponseEntity.notFound().build(); // 404 se não encontrado
        }
    }
}