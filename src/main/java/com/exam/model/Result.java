package com.exam.model;

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

    private User user;


}
