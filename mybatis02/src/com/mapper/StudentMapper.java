package com.mapper;

import java.util.List;

import com.pojo.Students;

public interface StudentMapper {

	//查询所有学生
	public List<Students> getAllStudents();
	//增加一个学生
	public void addStudents(Students stu);
}
