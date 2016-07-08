package com.superz.forum.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.superz.forum.pojo.Reply;
import com.superz.forum.service.IReplyService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ReplyServiceImpl<T extends Reply> extends ServiceImpl<T> implements IReplyService<T> {

	@Override
	public void create(T reply) {

		dao.create(reply);

		// 更新帖子最后回复、最后回复日期、作者、回帖数
		int count = dao.getTotalCount(" select count(r) from Reply r  where r.thread.id = " + reply.getThread().getId(),
				null);

		dao.createQuery(" update Thread t " + " set t.authorLastReplied.id = :authorLastReplied, "
				+ " t.dateLastReplied = :dateLastReplied, " + " t.replyCount = :replyCount "
				+ " where t.id = :threadId ").setParameter("authorLastReplied", reply.getAuthor().getId())
				.setParameter("dateLastReplied", new Date()).setParameter("replyCount", count)
				.setParameter("threadId", reply.getThread().getId()).executeUpdate();

		int floor = dao.getTotalCount(
				" select count(r) from Reply r " + " where r.thread.id = " + reply.getThread().getId(), null);

		// 回帖处于第几楼
		reply.setFloor(floor);

		dao.save(reply);
	}

	public void delete(T reply) {
		dao.delete(reply);
		String hql = "from Reply r where r.thread.id = " + reply.getThread().getId() + " ORDER BY r.dateCreated DESC";
		List<Reply> list = dao.createQuery(hql).list();
		Reply lastReply = null;
		if(list.size()==0){
			lastReply = new Reply();
		}else{
			lastReply = list.get(0);
		}
		int count = dao.getTotalCount(" select count(r) from Reply r  where r.thread.id = " + reply.getThread().getId(),
				null);
		dao.createQuery(
				" update Thread t "
				+ "set  t.replyCount = :replyCount, "
				+ "t.authorLastReplied = :authorLastReplied, "
				+ "t.dateLastReplied = :dateLastReplied "
				+ "where t.id = :threadId ")
				.setParameter("replyCount", count).setParameter("authorLastReplied", lastReply.getAuthor())
				.setParameter("dateLastReplied", lastReply.getDateCreated())
				.setParameter("threadId", reply.getThread().getId()).executeUpdate();

	}
}
