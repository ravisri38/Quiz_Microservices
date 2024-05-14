package com.spiro.question.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spiro.question.entity.Question;
import com.spiro.question.service.QuestionService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Question")
@RequestMapping("/api/v1/question")
public class QuestionController {

	private QuestionService questionService;
	public QuestionController(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}
	
	@PostMapping(path ="/addQuestion")
	public List<Question> addQuestion(@RequestBody List<Question> questionData){
		return questionService.addQuestions(questionData);
	}
	@GetMapping(path ="/{id}")
	public Question getQuestionById(@PathVariable("id") Long id){
		return questionService.getQuestionById(id);
	}
	@GetMapping(path ="/getAllQuestions")
	public List<Question> getAllQuestion(){
		return questionService.getAllQuestion();
	}
	@DeleteMapping(path ="/{id}")
	public String deleteQuestionById(@PathVariable("id") Long id){
		return questionService.deleteQuestionById(id);
	}
	
	//get all question of specific quiz
	@GetMapping(path ="/quiz/{quizId}")
	public List<Question> getQuestionsOfQuiz(@PathVariable("quizId") Long quizId){
		return questionService.getQuestionsOfQuiz(quizId);
	}
}
