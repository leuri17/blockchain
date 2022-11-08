package com.solera.blockchain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(AnswerUserId.class)
@Table(name="useranswer")
public class AnswerUser implements Serializable  {
    @Id
    @ManyToOne
    private Answer answer_id;

    @Id
    @ManyToOne
    private User user_id;

    public AnswerUser() {
    }

    public AnswerUser(Answer answer_id, User user_id) {
        this.answer_id = answer_id;
        this.user_id = user_id;
    }

    public Answer getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Answer answer_id) {
        this.answer_id = answer_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "AnswerUser{" +
                "answer_id=" + answer_id +
                ", user_id=" + user_id +
                '}';
    }
}
