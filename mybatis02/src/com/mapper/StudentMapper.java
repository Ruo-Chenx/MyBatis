package com.mapper;

import java.util.List;

import com.pojo.Students;

public interface StudentMapper {

	//��ѯ����ѧ��
	public List<Students> getAllStudents();
	//����һ��ѧ��
	public void addStudents(Students stu);
}
