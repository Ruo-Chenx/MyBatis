package com.xzy.edu;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.xzy.pojo.Students;
import com.zxy.mapper.StudentMapper;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	@Test
    public void testSelect()
    {
		InputStream inputStream = AppTest.class.getResourceAsStream("/mybatis-config.xml");
		//相当于根据mybatis-config.xml构建接池
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);

		// SqlSession相当于我们的Connection
		SqlSession session = sqlSessionFactory.openSession();
		try {
		
			StudentMapper sm=session.getMapper(StudentMapper.class);
			List<Students> stus=sm.findAllStudents();
			for(Students s:stus)
			{
				System.out.println(s.getStud_id()+"\t"+s.getName()+"\t"+s.getEmail()+"\t"+s.getDob());
			}
			//assertEquals(3, stus.size());
			
	//		Asser.assertEquals(3, stus.size());
		} finally {
		 session.close();
		}
		
    }
	//MyBatis默认支持一级缓存
	@Test
    public void testSelectfindid()
    {
		InputStream inputStream = AppTest.class.getResourceAsStream("/mybatis-config.xml");
		//相当于根据mybatis-config.xml构建接池
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);

		// SqlSession相当于我们的Connection
		SqlSession session = sqlSessionFactory.openSession();
		try {
		
			StudentMapper sm=session.getMapper(StudentMapper.class);
			Students s=sm.findStudentsById(4);
			System.out.println(s.getStud_id()+"\t"+s.getName()+"\t"+s.getEmail()+"\t"+s.getDob());
			System.out.println("---------------------------------------------------------------");
			Students s1=sm.findStudentsById(4);
			System.out.println(s1.getStud_id()+"\t"+s1.getName()+"\t"+s1.getEmail()+"\t"+s1.getDob());
			
			
		} finally {
		 session.close();
		}
		
    }
	
	
	
	
	
}
