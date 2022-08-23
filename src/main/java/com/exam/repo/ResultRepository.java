package com.exam.repo;

import com.exam.model.Result;
import com.exam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository  extends JpaRepository<Result,Long> {

    public List<Result> findByUser(User user);
}
