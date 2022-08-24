package com.exam.service;

import com.exam.model.Result;
import com.exam.model.User;

import java.util.List;

public interface ResultService {

    public List<Result> getResultByUser(User user);
    public Result addResult(Result result);

    List<Result> getAllResults();
}
