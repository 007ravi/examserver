package com.exam.controller;

import com.exam.model.Result;
import com.exam.model.User;
import com.exam.model.exam.Quiz;
import com.exam.service.QuizService;
import com.exam.service.ResultService;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/result")
@CrossOrigin("*")
@RestController
public class ResultController {

    @Autowired
    ResultService resultService;

    @Autowired
    UserService userService;

    @Autowired
    QuizService quizService;

    @GetMapping("/user/{username}")
    public ResponseEntity<?> getResultByUser(@PathVariable("username") String username){
        User user=this.userService.getUser(username);

        List<Result>results=this.resultService.getResultByUser(user);
        return ResponseEntity.ok(results);
    }

    @PostMapping("/")
    public ResponseEntity<?> addResult(@RequestBody Result result){
       Result savedResult =this.resultService.addResult(result);
        return ResponseEntity.ok("Result added");
    }

    @GetMapping("/")
    public ResponseEntity<?> getResultByUser(){

        List<Result>results=this.resultService.getAllResults();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<?> getResultByQuiz(@PathVariable("quizId") long quizId){
        Quiz quiz=this.quizService.getQuiz(quizId);

        List<Result>results=this.resultService.getResultByQuiz(quiz);
        return ResponseEntity.ok(results);
    }
}
