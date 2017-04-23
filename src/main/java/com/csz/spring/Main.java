package com.csz.spring;

import java.util.Arrays;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.csz.service.StudentServiceImpl;

public class Main {

	public static void main(String[] args) {

		BeanFactory bf=MyApplicationContext.getBeanFactory("spring/applicationContext.xml");
		StudentServiceImpl bean =    bf.getBean(StudentServiceImpl.class);

		/*System.out.println(bean.toString());
		System.out.println(bean.getById(1).getName());*/

		
	}
	
}
