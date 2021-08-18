package com.fanzhuanketang.dao;

import java.util.List;

import com.fanzhuanketang.po.Ques;

public interface QuesDao {
	/**
     * 向数据库中保存问题信息
     * @return
     * @throws Exception
     */
	 public boolean saveQues(Ques ques) throws Exception;

	 /**
	     *查看所有问题 
	     * @return
	     * @throws Exception
	     */

	 public List<Ques> findAll() throws Exception;

	 List<Ques> findById(int id) throws Exception;
}
