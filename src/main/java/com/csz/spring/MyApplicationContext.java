package com.csz.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.csz.service.StudentServiceImpl;

public class MyApplicationContext  {
	public static BeanFactory getBeanFactory(String classPath){
		//创建IOC配置的抽象资源  
        ClassPathResource resource=new ClassPathResource(classPath);  
        //创建一个BeanFactory  
        DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();  
        //创建一个BeanDefinition读区器  
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(beanFactory);  
        //从定义好的资源位置读区配置信息  
        reader.loadBeanDefinitions(resource); 
        return beanFactory;
       /* StudentServiceImpl bean= beanFactory.getBean(clazz);		
        System.out.println(bean.getById(1).getName());*/

	}
	public static BeanFactory getBeanFactory2(String classPath){
		return new ClassPathXmlApplicationContext(classPath);

	}
	public static BeanFactory getBeanFactory3(String classPath){
		//getBeanFactory2("spring/applicationContext.xml");
		return SpringContextUtil.getApplicationContext();

	}
}
