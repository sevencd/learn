package com.csz.service;



import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.csz.domain.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml"})
public class StudentTest{
	private @Autowired IStudent stu;
	public  StudentTest(){
		System.out.println("StudentTest初始化成功");
	}
	@Test
	public void select(){
		Student i=stu.getById(1);
		System.out.println(i.getName());
	}
	@Test
	public void insert(){
		Student i=new Student();
		i.setAge(10);
		i.setName("csz");
		short s=1;
		i.setSex(s);
		System.out.println(stu.addStudent(i));
		
	}
	@Test
	public void jdbcdbrouting(){
		//AbstractRoutingDataSource ar;
		DataSource ds;
	}
	
}
