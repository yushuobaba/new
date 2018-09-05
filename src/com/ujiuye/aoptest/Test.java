package com.ujiuye.aoptest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ujiuye.Dao.PersonDao;
import com.ujiuye.test.PersonDaoImpl;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		PersonDao ndao =(PersonDao)context.getBean("perdao");
		ndao.save();
		
	}
}
