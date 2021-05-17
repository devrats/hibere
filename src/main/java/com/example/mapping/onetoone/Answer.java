/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/16/2021
 *   Time: 12:09 PM
 *   File: Answer.java
 */

package com.example.mapping.onetoone;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity(name = "ans")
public class Answer {

    @Id
    private int aId;
    private String answer;

    @Override
    public String toString() {
        return "Answer{" +
                "aId=" + aId +
                ", answer='" + answer + '\'' +
                '}';
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Answer(int aId, String answer, Question question) {
        this.aId = aId;
        this.answer = answer;
        this.question = question;
    }

    @OneToOne(mappedBy = "answer")
    @JoinColumn(name = "qId")
    private Question question;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer)) return false;
        Answer answer = (Answer) o;
        return getaId() == answer.getaId() && Objects.equals(getQuestion(), answer.getQuestion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getaId(), getQuestion());
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer() {
    }

    public Answer(int aId, Question question) {
        this.aId = aId;
        this.question = question;
    }
}