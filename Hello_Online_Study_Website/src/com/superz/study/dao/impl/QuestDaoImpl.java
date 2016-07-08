package com.superz.study.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.superz.study.bean.User;
import com.superz.study.dao.QuestDao;
import com.superz.study.pojo.Answer;
import com.superz.study.pojo.Question;

@Repository("questDao")
public class QuestDaoImpl implements QuestDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveQuestion(Question question) {
		sessionFactory.getCurrentSession().save(question);
	}

	@Override
	public List<Question> getAllQuestion(User user) {
		List<Question> qusetionList = sessionFactory.getCurrentSession()
				.createQuery("FROM Question q WHERE q.student.id = " + user.getId() + "order by q.createTime desc")
				.list();
		return qusetionList;
	}

	@Override
	public List<Question> getAllQuestion() {
		String hql = "FROM Question q order by q.createTime desc";
		return sessionFactory.getCurrentSession()
				.createQuery(hql)
				.list();
	}

	@Override
	public void saveAnswer(Answer answer) {
		sessionFactory.getCurrentSession().save(answer);
	}

	@Override
	public List<Answer> getAllAnswer(Question question) {
		List<Answer> answerList = sessionFactory.getCurrentSession()
				.createQuery("FROM Answer a WHERE a.question.id = " + question.getId()).list();
		return answerList;
	}

	@Override
	public Question getLastQuestion() {
		String hql = "FROM Question q ORDER BY q.createTime desc";
		 List<Question> qusetionList = sessionFactory.getCurrentSession().createQuery(hql).list();
		if (qusetionList.size() != 0) {
			return (Question) qusetionList.get(0);
		} else {
			return new Question();
		}
	}

	@Override
	public List<Answer> get3Answer(Question question) {
		String hql = "FROM Answer a WHERE a.question.id = " + question.getId() + "order by a.createTime desc";
		List<Answer> answerList = (List<Answer>) sessionFactory.getCurrentSession().createQuery(hql).setFirstResult(0)
				.setMaxResults(3).list();
		return answerList;
	}

	@Override
	public Answer getLastAnswer(Question question) {
		String hql = "FROM Answer a WHERE a.question.id = " + question.getId() + "order by a.createTime desc";
		Answer answer = (Answer)sessionFactory.getCurrentSession().createQuery(hql).setFirstResult(0).setMaxResults(1)
				.uniqueResult();
		return answer;
	}

	@Override
	public Question getQuestionById(int id) {
		return (Question) sessionFactory.getCurrentSession().get(Question.class, id);
	}


	

}
