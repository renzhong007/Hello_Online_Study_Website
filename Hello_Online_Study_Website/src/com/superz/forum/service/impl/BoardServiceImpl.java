package com.superz.forum.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.superz.forum.pojo.Board;
import com.superz.forum.service.IBoardService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class BoardServiceImpl<T extends Board> extends ServiceImpl<T> implements IBoardService<T> {

	@Override
	public void create(T board) {

		if (dao.createQuery(" from Board b where b.deleted = false and b.name = :name ")
				.setParameter("name", board.getName().trim()).list().size() > 0) {

			throw new RuntimeException("版面 " + board.getName() + " 已经存在。");
		}

		dao.create(board);
	}
}
