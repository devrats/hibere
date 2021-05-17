/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/16/2021
 *   Time: 12:08 PM
 *   File: Question.java
 */

package com.example.mapping.onetoone;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "ques")
public class Question {

    @Id
    private int qId;
    private String question;
    private int marks;

    public Question() {

    }

    @Override
    public String toString() {
        return "Question{" +
                "qId=" + qId +
                ", question='" + question + '\'' +
                ", marks=" + marks +
                ", answer=" + answer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question1 = (Question) o;
        return getqId() == question1.getqId() && getMarks() == question1.getMarks() && Objects.equals(getQuestion(), question1.getQuestion()) && Objects.equals(getAnswer(), question1.getAnswer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getqId(), getQuestion(), getMarks(), getAnswer());
    }

    public int getqId() {

        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getMarks() {
        return marks;
    }

    public Question(int qId, String question, int marks) {
        this.qId = qId;
        this.question = question;
        this.marks = marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Question(int qId, String question, int marks, Answer answer) {
        this.qId = qId;
        this.question = question;
        this.marks = marks;
        this.answer = answer;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aId")
    private Answer answer;
}