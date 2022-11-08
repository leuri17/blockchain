package com.solera.blockchain.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="questions")
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID id;

    @OneToMany(mappedBy = "id_question", fetch = FetchType.LAZY)
    private List<Answer> answerList;

    @Column(nullable = false)
    private String question;

    public Question(){}

    public Question(UUID id, List<Answer> answerList, String question) {
        this.id = id;
        this.answerList = answerList;
        this.question = question;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public UUID getId() {
        return id;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public String getQuestion() {
        return question;
    }
}
