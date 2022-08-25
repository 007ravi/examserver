package com.exam.service;

import com.exam.model.Result;
import com.exam.model.User;
import com.exam.model.exam.Quiz;

import java.util.List;

public interface ResultService {

    public List<Result> getResultByUser(User user);
    public Result addResult(Result result);

    List<Result> getAllResults();
    public List<Result> getResultByQuiz(Quiz quiz);
}
