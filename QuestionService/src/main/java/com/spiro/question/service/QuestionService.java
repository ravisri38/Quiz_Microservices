package com.spiro.question.service;

import java.util.List;

import com.spiro.question.entity.Question;

public interface QuestionService {

	Question getQuestionById(Long id);

	List<Question> getAllQuestion();

	String deleteQuestionById(Long id);

	List<Question> addQuestions(List<Question> questionData);

	List<Question> getQuestionsOfQuiz(Long quizId);

}
