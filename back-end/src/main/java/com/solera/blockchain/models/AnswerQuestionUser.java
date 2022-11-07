package com.solera.blockchain.models;

import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.UUID;

@Entity
@IdClass(IdAnswerQuestionUser.class)
@Table(name="answersquestionsusers")
public class AnswerQuestionUser {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_answer")
    private Answer answer;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_question")
    private Question question;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

}
