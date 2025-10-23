package com.example.Projeto3.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Projeto3.entities.Feedback;
import com.example.Projeto3.services.FeedbackService;

@RestController
@RequestMapping("/feedbacks")
@CrossOrigin(origins = "*") // permite requisições de qualquer front-end
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public List<Feedback> listarTodos() {
        return feedbackService.listarTodos();
    }

    @GetMapping("/{id}")
    public Feedback buscarPorId(@PathVariable Long id) {
        return feedbackService.buscarPorId(id);
    }

    @PostMapping
    public Feedback criarFeedback(@RequestBody Feedback feedback) {
        return feedbackService.salvar(feedback);
    }

    @PutMapping("/{id}")
    public Feedback atualizarFeedback(@PathVariable Long id, @RequestBody Feedback feedbackAtualizado) {
        return feedbackService.atualizar(id, feedbackAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarFeedback(@PathVariable Long id) {
        feedbackService.deletar(id);
    }
}
