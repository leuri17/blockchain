package com.solera.blockchain.models;

import java.io.Serializable;

public class IdAnswerQuestionUser implements Serializable {

    private Answer answer;
    private Question question;
    private User user;

    public IdAnswerQuestionUser(){}

    public IdAnswerQuestionUser(Answer answer, Question question, User user) {
        this.answer = answer;
        this.question = question;
        this.user = user;
    }

    public Answer getAnswer() {
        return answer;
    }

    public Question getQuestion() {
        return question;
    }

    public User getUser() {
        return user;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
