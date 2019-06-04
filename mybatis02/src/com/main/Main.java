package com.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mapper.StudentMapper;
import com.pojo.Students;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//�൱�����ӳ�
		SqlSessionFactory	sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	    //�൱��Connection
		SqlSession  session=sqlSessionFactory.openSession();
		
		StudentMapper sm=session.getMapper(StudentMapper.class);
		
		
		
		Students stu = new Students();
		stu.setEmail("gogo@qq.com");
		stu.setName("С��");
		stu.setDob(new Date());
		
		sm.addStudents(stu);
		
		session.commit();
		
		
		List<Students>  list = sm.getAllStudents();
		
		
		for(Students s:list)
		{
			System.out.println(s.getStudId()+"\t"+s.getName()+"\t"+s.getEmail()+"\t"+s.getDob());
		}
		
		System.out.println("-----------------------------");
		
/*	 	
	 List<Students>  list1=session.selectList("com.mapper.StudentMapper.getAllStudents");
		
		
		for(Students s:list1)
		{
			System.out.println(s.getStudId()+"\t"+s.getName()+"\t"+s.getEmail()+"\t"+s.getDob());
		}*/
	
	}
}
