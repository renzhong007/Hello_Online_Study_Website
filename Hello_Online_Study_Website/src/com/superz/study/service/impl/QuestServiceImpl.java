package com.superz.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.superz.study.bean.User;
import com.superz.study.dao.QuestDao;
import com.superz.study.dao.impl.QuestDaoImpl;
import com.superz.study.pojo.Answer;
import com.superz.study.pojo.Question;
import com.superz.study.service.QuestService;

@Service("questService")
@Transactional(propagation = Propagation.REQUIRED)
public class QuestServiceImpl implements QuestService {
	@Autowired
	private QuestDao questDao;

	@Override
	public void saveQuestion(Question question) {
		questDao.saveQuestion(question);
	}

	@Override
	public List<Question> getAllQuestion(User user) {
		return questDao.getAllQuestion(user);
	}

	@Override
	public List<Question> getAllQuestion() {
		return questDao.getAllQuestion();
	}

	@Override
	public void saveAnswer(Answer answer) {
		questDao.saveAnswer(answer);
	}

	@Override
	public List<Answer> getAllAnswer(Question question) {
		return questDao.getAllAnswer(question);
	}

	@Override
	public Question getLastQuestion() {
		return questDao.getLastQuestion();
	}

	@Override
	public List<Answer> get3Answer(Question question) {
		return questDao.get3Answer(question);
	}

	@Override
	public Answer getLastAnswer(Question question) {
		return questDao.getLastAnswer(question);
	}

	@Override
	public Question getQuestionById(int id) {
		return questDao.getQuestionById(id);
	}


	



}
