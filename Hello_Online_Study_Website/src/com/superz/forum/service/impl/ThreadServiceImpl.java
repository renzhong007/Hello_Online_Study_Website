package com.superz.forum.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.superz.forum.pojo.Thread;
import com.superz.forum.service.IThreadService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ThreadServiceImpl<T extends Thread> extends ServiceImpl<T> implements IThreadService<T> {

	@Override
	public void create(T thread) {
		dao.create(thread);
	}

	public void updateHit(Integer threadId) {

		dao.createQuery(" update Thread t set t.hit = t.hit + 1 where t.id = :id ").setParameter("id", threadId)
				.executeUpdate();

	}

}
