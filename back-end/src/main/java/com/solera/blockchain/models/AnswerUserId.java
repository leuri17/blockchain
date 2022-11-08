//package com.solera.blockchain.models;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//public class AnswerUserId implements Serializable {
//
//    private Answer answer;
//    private Question question;
//
//    public AnswerUserId(){}
//
//    public AnswerUserId(Answer answer, Question question) {
//        this.answer = answer;
//        this.question = question;
//    }
//
//    public Answer getAnswer() {
//        return answer;
//    }
//
//    public Question getQuestion() {
//        return question;
//    }
//
//    public void setAnswer(Answer answer) {
//        this.answer = answer;
//    }
//
//    public void setQuestion(Question question) {
//        this.question = question;
//    }
//
//    @Override
//    public String toString() {
//        return "IdAnswerUser{" +
//                "answer=" + answer +
//                ", question=" + question +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        AnswerUserId that = (AnswerUserId) o;
//        return answer.equals(that.answer) && question.equals(that.question);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(answer, question);
//    }
//}
