package com.spiro.quiz.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spiro.quiz.entity.Quiz;
import com.spiro.quiz.repository.QuizRepository;
import com.spiro.quiz.service.QuestionClient;
import com.spiro.quiz.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	private QuizRepository quizRepository;
	private QuestionClient questionClient;


	public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
		super();
		this.quizRepository = quizRepository;
		this.questionClient = questionClient;
	}

	@Override
	public Quiz add(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> get() {
		List<Quiz> quizes = quizRepository.findAll();
		return quizes.stream().map(quiz->{
			quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
	}

	@Override
	public Quiz get(Long id) {
		Quiz quiz= quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Data not found"));
		quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
		return quiz;
	}

	@Override
	public List<Quiz> addAll(List<Quiz> quizzes) {
		return quizRepository.saveAll(quizzes);
	}

	@Override
	public String deleteQuestionById(Long id) {
		quizRepository.deleteById(id);
		return "Deleted Successfully";
	}

}
