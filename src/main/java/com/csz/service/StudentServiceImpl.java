package com.csz.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.csz.domain.Student;
import com.csz.mapper.StudentMapper;
@Service
public class StudentServiceImpl implements IStudent{
	public  StudentServiceImpl(){
		System.out.println("StudentServiceImpl 构造函数");
	}
	@Autowired SqlSessionFactory sqlSessionFactory;
	private @Autowired StudentMapper studentMapper;
	public Student getById(int id) {
		// TODO Auto-generated method stub
		//studentMapper=new studentMapper
		/*SqlSession session=sqlSessionFactory.openSession();
		Student student = (Student) session.selectOne("com.csz.mapper.StudentMapper.selectByPrimaryKey", id);
		session.close();*/

		return studentMapper.selectByPrimaryKey(id);
	}
	public List<Student> getAllStudent() {
		SqlSession session=sqlSessionFactory.openSession();
		List<Student> list =  session.selectList("com.csz.mapper.StudentMapper.selectAll");
		session.close();
		return list;
	}
	public int addStudent(Student stu) {
		// TODO Auto-generated method stub
		return studentMapper.insert(stu);
	}
	public String toString(){
		return "StudentServiceImpl实例化成功";
	}
}
