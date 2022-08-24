package com.exam.model;

import com.exam.model.exam.Quiz;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resultId",nullable = false)
    private long rid;

    private long marks;

    private int questionsAttempted;

    private int correctAnswer;

    private Date attemptedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="quiz_id")
    private Quiz quiz;

    public Result() {
    }

    public Result(long rid, long marks, int questionsAttempted, int correctAnswer, Date attemptedDate, User user,Quiz quiz) {
        this.rid = rid;
        this.marks = marks;
        this.questionsAttempted = questionsAttempted;
        this.correctAnswer = correctAnswer;
        this.attemptedDate = attemptedDate;
        this.user = user;
        this.quiz=quiz;
    }

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public long getMarks() {
        return marks;
    }

    public void setMarks(long marks) {
        this.marks = marks;
    }

    public int getQuestionsAttempted() {
        return questionsAttempted;
    }

    public void setQuestionsAttempted(int questionsAttempted) {
        this.questionsAttempted = questionsAttempted;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Date getAttemptedDate() {
        return attemptedDate;
    }

    public void setAttemptedDate(Date attemptedDate) {
        this.attemptedDate = attemptedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
