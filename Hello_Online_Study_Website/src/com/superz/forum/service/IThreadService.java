package com.superz.forum.service;

import com.superz.forum.pojo.Thread;

public interface IThreadService<T extends Thread> extends IService<T> {

	public void updateHit(Integer threadId);

}
