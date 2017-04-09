package com.csz.util;

import com.csz.domain.Student;
import com.csz.jdbc.JdbcConnectionFactory;

import baseclass.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropertiesUtil {

	private  List<Object> selectInnerList(String statement, Object parameter){
			List<Object>	list=new ArrayList<Object>();
			Connection conn=JdbcConnectionFactory.getConn();
			try {
				PreparedStatement pstmt=conn.prepareStatement("select * from student");
				ResultSet rs=pstmt.executeQuery();
				Student stu;
				while(rs.next()){
					stu=new Student();
					stu.setId(rs.getInt("id"));
					stu.setAge(rs.getInt("age"));
					stu.setName(rs.getString("name"));
					stu.setSex(rs.getShort("sex"));
					list.add(stu);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
	  }

	private  <E> List<E> selectList(String statement, Object parameter){
		return (List<E>) this.selectInnerList(statement,parameter);
	}
	public static void main(String[] str) {
		List<Student> list =  new PropertiesUtil().selectList("select * from student",null);
		for(Student s:list){
			System.out.println(s.getName());
		}
	}
}