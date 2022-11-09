package com.solera.blockchain.models;

import java.io.Serializable;
import java.util.Objects;

public class UserAnswerId implements Serializable {

    private Answer answer_id;
    private User user_id;

    public UserAnswerId(){}

    public UserAnswerId(Answer answer, User user) {
        this.answer_id = answer;
        this.user_id = user;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAnswerId that = (UserAnswerId) o;
        return answer_id.equals(that.answer_id) && user_id.equals(that.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer_id, user_id);
    }

    @Override
    public String toString() {
        return "AnswerUserId{" +
                "answer_id=" + answer_id +
                ", user_id=" + user_id +
                '}';
    }
}
