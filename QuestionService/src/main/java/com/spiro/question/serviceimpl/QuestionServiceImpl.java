package com.spiro.question.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spiro.question.entity.Question;
import com.spiro.question.repository.QuestionRepository;
import com.spiro.question.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	private QuestionRepository questionRepository;

	public QuestionServiceImpl(QuestionRepository questionRepository) {
		super();
		this.questionRepository = questionRepository;
	}

	@Override
	public List<Question> addQuestions(List<Question> questions) {
		return questionRepository.saveAll(questions);
	}

	@Override
	public Question getQuestionById(Long id) {
		return questionRepository.findById(id).orElseThrow(()->new RuntimeException("Question Not found"));
	}

	@Override
	public List<Question> getAllQuestion() {
		return questionRepository.findAll();
	}

	@Override
	public String deleteQuestionById(Long id) {
		 questionRepository.deleteById(id);;
		 return "Deleted";
	}

	@Override
	public List<Question> getQuestionsOfQuiz(Long quizId) {
		return questionRepository.findByQuizId(quizId);
	}

}
