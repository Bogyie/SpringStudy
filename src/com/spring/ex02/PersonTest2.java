package com.spring.ex02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import java.util.ArrayList;

public class PersonTest2 {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
		ApplicationContext context = new FileSystemXmlApplicationContext("person.xml");

		ArrayList<PersonService> personList = new ArrayList<>();
		ArrayList<PersonService> employList = new ArrayList<>();

		for (String name : context.getBeanNamesForType(PersonServiceImpl.class)) {
			personList.add((PersonService) factory.getBean(name));
		}

		for (String name : context.getBeanNamesForType(EmployServiceImpl.class)) {
			employList.add((PersonService) factory.getBean(name));
		}

		System.out.println("Person");

		for (PersonService person : personList) {
			person.sayHello();
		}

		System.out.println("Employ");

		for (PersonService employ : employList) {
			employ.sayHello();
		}
	}
}
