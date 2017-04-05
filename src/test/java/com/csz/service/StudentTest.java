package com.csz.service;



import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.csz.domain.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml"})
public class StudentTest{
	private @Autowired IStudent stu;
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
		AbstractRoutingDataSource ar;
		DataSource ds;
	}
	
}
