package com.csz.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.csz.service.StudentServiceImpl;

@Component
public class SpringContextUtil implements ApplicationContextAware {
	private static ApplicationContext applicationContext; // Spring应用上下文环境

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static Object getBean(String name) throws BeansException {
		return  applicationContext.getBean(name);
	}

	public static <T> T getBean(Class<T> clazz) {
		return (T) applicationContext.getBean(clazz);
	}

}
