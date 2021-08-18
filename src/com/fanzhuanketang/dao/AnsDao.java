package com.fanzhuanketang.dao;

import java.util.List;

import com.fanzhuanketang.po.Ans;


public interface AnsDao {
		/**
	     * 向数据库中保存回复信息
	     * @return
	     * @throws Exception
	     */
		 public boolean saveAns(Ans Ans) throws Exception;
		 /**
		     *查询所有问题 
		     * @return
		     * @throws Exception
		     */

		 public List<Ans> findByQuesId(int quesID) throws Exception;
		

	}

