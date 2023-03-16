package com.exam.service;

import com.exam.model.User;
import com.exam.model.exams.Quiz;
import com.exam.model.exams.Result;

import java.util.List;

public interface ResultService {

	public Result addResult(Result result);
	public List<Result> getAllResult();
	public List<Result> getResultOfQuiz(Quiz quiz);
	public List<Result> getResultOfUser(User user);
	public List<Result> getResultOfUserAndQuiz(Quiz quiz,User user);

}
