package com.superz.study.service;

import java.util.List;

import com.superz.study.bean.User;
import com.superz.study.pojo.Answer;
import com.superz.study.pojo.Question;

public interface QuestService {
	/**
	 * 保存提问
	 * 
	 * @param question
	 * @return
	 */
	void saveQuestion(Question question);

	/**
	 * 获取所有问题
	 * 
	 * @param user
	 * @return
	 */
	List<Question> getAllQuestion(User user);
	List<Question> getAllQuestion();

	/**
	 * 保存回复
	 * 
	 * @param answer
	 * @return
	 */
	void saveAnswer(Answer answer);

	/**
	 * 获取所有回复
	 * 
	 * @param question
	 * @return
	 */
	List<Answer> getAllAnswer(Question question);

	/**
	 * 获取最后一条问题
	 * 
	 * @param user
	 * @return
	 */
	Question getLastQuestion();

	/**
	 * 获取最近3条回复
	 * 
	 * @param question
	 * @return
	 */
	List<Answer> get3Answer(Question question);

	/**
	 * 回去最后一条回复
	 * 
	 * @param question
	 * @return
	 */
	Answer getLastAnswer(Question question);

	/**
	 * 根据id获取question对象
	 * 
	 * @param id
	 * @return
	 */
	Question getQuestionById(int id);


}
