package com.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.mapper.StudentMapper;
import com.pojo.Students;

public class Main {
	
	private static Logger log=Logger.getLogger(Main.class);
	
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//相当于连接池
		SqlSessionFactory	sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	    //相当于Connection
		SqlSession  session=sqlSessionFactory.openSession();
		
		StudentMapper sm=session.getMapper(StudentMapper.class);
		
		
		
	/*	Students stu=new Students();
		stu.setEmail("gogo@qq.com");
		stu.setName("小明");
		stu.setDob(new Date());
		
		sm.addStudents(stu);
		
		session.commit();*/
		
		
		List<Students>  list=sm.getAllStudents();
		
		
		for(Students s:list)
		{
			log.info(s.getName());
			//System.out.println(s.getStudId()+"\t"+s.getName()+"\t"+s.getEmail()+"\t"+s.getDob());
		}
		
		System.out.println("-----------------------------");
		
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id", 2);
		map.put("name", "%Stu%");
		Students stu=sm.getStudents(map);
		System.out.println(stu.getStudId()+"\t"+stu.getName()+"\t"+stu.getEmail()+"\t"+stu.getDob());
/*	 	
	 List<Students>  list1=session.selectList("com.mapper.StudentMapper.getAllStudents");
		
		
		for(Students s:list1)
		{
			System.out.println(s.getStudId()+"\t"+s.getName()+"\t"+s.getEmail()+"\t"+s.getDob());
		}*/
	
	}
}
