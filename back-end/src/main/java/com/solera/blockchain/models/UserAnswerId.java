package com.solera.blockchain.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class UserAnswerId implements Serializable {

    private UUID answer;
    private UUID user;

    public UserAnswerId(){}

    public UserAnswerId(UUID answer, UUID user) {
        this.answer = answer;
        this.user = user;
    }

    public UUID getAnswer_id() {
        return answer;
    }

    public void setAnswer_id(UUID answer_id) {
        this.answer = answer_id;
    }

    public UUID getUser_id() {
        return user;
    }

    public void setUser_id(UUID user_id) {
        this.user = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAnswerId that = (UserAnswerId) o;
        return Objects.equals(answer, that.answer) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer, user);
    }

    @Override
    public String toString() {
        return "UserAnswerId{" +
                "answer_id=" + answer +
                ", user_id=" + user +
                '}';
    }
}
