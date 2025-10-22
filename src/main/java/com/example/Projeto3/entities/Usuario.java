package com.example.Projeto3.entities;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Usuario extends User{
    long id_user;

    public Feedback criarFeedback(){
        Feedback feedback = new Feedback();

        return feedback;
    }
}
