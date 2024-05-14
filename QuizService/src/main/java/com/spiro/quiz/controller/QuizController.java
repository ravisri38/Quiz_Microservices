package com.spiro.quiz.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spiro.quiz.entity.Quiz;
import com.spiro.quiz.service.QuizService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Quiz")
@RequestMapping("/api/v1/quiz")
public class QuizController {

	private QuizService quizService;

	public QuizController(QuizService quizService) {
		super();
		this.quizService = quizService;
	}

	@PostMapping(path = "/addQuiz")
	public List<Quiz> addQuiz(@RequestBody List<Quiz> quizzes) {
	    return quizService.addAll(quizzes);
	}

	@GetMapping(path = "/getAllQuiz")
	public List<Quiz> getAllQuiz() {
		return quizService.get();
	}

	@GetMapping(path ="/{id}")
	public Quiz getQuizById(@PathVariable("id") Long id) {
		return quizService.get(id);
	}
	@DeleteMapping(path ="/{id}")
	public String deleteQuestionById(@PathVariable("id") Long id){
		return quizService.deleteQuestionById(id);
	}

}
