package com.example.Projeto3.entities;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Admin extends User{
    private long id_admin;

    public Feedback editarStatus(Feedback feedback) {
        feedback.status = Status.Pendente;
        return feedback;
    }
}
