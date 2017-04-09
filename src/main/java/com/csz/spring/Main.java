package com.csz.spring;

import java.util.Arrays;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.csz.service.StudentServiceImpl;

public class Main {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext bf = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

		String[] beanNames=bf.getBeanDefinitionNames();
		StudentServiceImpl bean =    bf.getBean(StudentServiceImpl.class);

		System.out.println(bean.getById(1).getName());
		System.out.println(beanNames);
		
		System.out.println(Arrays.toString(beanNames));
		System.out.println(bf.getBeanDefinitionCount());
		
		System.out.println(SpringContextUtil.getBean(StudentServiceImpl.class).getById(2).getName());
	}

}
