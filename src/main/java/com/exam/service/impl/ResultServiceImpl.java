package com.exam.service.impl;

import com.exam.model.Result;
import com.exam.model.User;
import com.exam.model.exam.Quiz;
import com.exam.repo.ResultRepository;
import com.exam.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    ResultRepository resultRepository;

    @Override
   public List<Result> getResultByUser(User user){
       List<Result>results=this.resultRepository.findByUser(user);
       return results;
   }

    @Override
    public Result addResult(Result result) {

        return this.resultRepository.save(result);
    }

    @Override
    public List<Result> getAllResults() {
        return this.resultRepository.findAll();
    }

    @Override
    public List<Result> getResultByQuiz(Quiz quiz){
        List<Result>results=this.resultRepository.findByQuiz(quiz);
        return results;
    }
}
