package com.csz.service;

import org.springframework.stereotype.Service;

import com.csz.domain.Student;
public interface IStudent {
	public Student getById(int id);
	public int addStudent(Student stu);
}
