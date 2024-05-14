package com.spiro.quiz.service;

import java.util.List;

import com.spiro.quiz.entity.Quiz;

public interface QuizService {

	Quiz add(Quiz quiz);

	List<Quiz> get();

	Quiz get(Long id);
	
	List<Quiz> addAll(List<Quiz> quizzes);

	String deleteQuestionById(Long id);

}
