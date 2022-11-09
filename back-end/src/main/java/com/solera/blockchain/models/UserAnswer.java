package com.solera.blockchain.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(UserAnswerId.class)
@Table(name="useranswer")
public class UserAnswer implements Serializable  {
    @Id
    @ManyToOne
    private User user_id;

    @Id
    @ManyToOne
    private Answer answer_id;

    public UserAnswer() {
    }

    public UserAnswer(User user_id, Answer answer_id) {
        this.user_id = user_id;
        this.answer_id = answer_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Answer getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Answer answer_id) {
        this.answer_id = answer_id;
    }

    @Override
    public String toString() {
        return "UserAnswer{" +
                "user_id=" + user_id +
                ", answer_id=" + answer_id +
                '}';
    }
}
