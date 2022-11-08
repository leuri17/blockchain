//package com.solera.blockchain.models;
//
//import javax.persistence.*;
//
//@Entity
//@IdClass(AnswerUserId.class)
//@Table(name="answer_user")
//public class AnswerUser {
//    @EmbeddedId
//    private AnswerUserId answerUserId;
//    @ManyToOne
//    private Answer answer;
//
//    @ManyToOne
//    private User user;
//
//    public AnswerUser() {
//    }
//
//    public AnswerUser(AnswerUserId answerUserId, Answer answer, User user) {
//        this.answerUserId = answerUserId;
//        this.answer = answer;
//        this.user = user;
//    }
//
//    public AnswerUserId getAnswerUserId() {
//        return answerUserId;
//    }
//
//    public void setAnswerUserId(AnswerUserId answerUserId) {
//        this.answerUserId = answerUserId;
//    }
//
//    public Answer getAnswer() {
//        return answer;
//    }
//
//    public void setAnswer(Answer answer) {
//        this.answer = answer;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    @Override
//    public String toString() {
//        return "AnswerUser{" +
//                "answerUserId=" + answerUserId +
//                ", answer=" + answer +
//                ", user=" + user +
//                '}';
//    }
//}
