package com.solera.blockchain.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(UserAnswerId.class)
@Table(name="useranswer")
public class UserAnswer implements Serializable  {
    @Id
    @ManyToOne
    private User user;

    @Id
    @ManyToOne
    private Answer answer;

    public UserAnswer() {
    }

    public UserAnswer(User user, Answer answer) {
        this.user = user;
        this.answer = answer;
    }

    public User getUser_id() {
        return user;
    }

    public void setUser_id(User user_id) {
        this.user = user_id;
    }

    public Answer getAnswer_id() {
        return answer;
    }

    public void setAnswer_id(Answer answer_id) {
        this.answer = answer_id;
    }

    @Override
    public String toString() {
        return "UserAnswer{" +
                "user_id=" + user +
                ", answer_id=" + answer +
                '}';
    }
}
