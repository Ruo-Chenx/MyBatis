package com.mapper;

import java.util.List;
import java.util.Map;

import com.pojo.Students;

public interface StudentMapper {

	//��ѯ����ѧ��
	public List<Students> getAllStudents();
	//����һ��ѧ��
	public void addStudents(Students stu);
	//�õ�һ��ѧ����Ϣ
	public Students getStudents(Map<String,Object> map);
}
