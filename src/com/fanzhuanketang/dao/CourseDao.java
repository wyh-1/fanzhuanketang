package com.fanzhuanketang.dao;

import java.util.List;

import com.fanzhuanketang.po.Course;

public interface CourseDao {
	/**
	 * 根据传入的Course实例插入记录
	 * @param s Course的实例
	 * @return 布尔型变量
	 */
	public boolean insertCourse(Course s);
	/**
	 * 查询所有课程实例
	 * @return list
	 */
	public List<Course> selectAllCourseByUserID(int identity, String idNum);
    public List<Course> selectAllCourseByID(String id);
    public List<Course> selectAllCourse();

    public boolean UpdateCourse(Course s);
	public boolean deleteCourse(String ID);
}
