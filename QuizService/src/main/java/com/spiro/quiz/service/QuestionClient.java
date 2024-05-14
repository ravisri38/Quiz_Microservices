package com.spiro.quiz.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spiro.quiz.entity.Question;

//@FeignClient(url = "http://localhost:8083/api/v1/", value = "Question-Client")
@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionClient {

	@GetMapping(path = "/api/v1/question/quiz/{quizId}")
	public List<Question> getQuestionOfQuiz(@PathVariable("quizId") Long quizId);
}
