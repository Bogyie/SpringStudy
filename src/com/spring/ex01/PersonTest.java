package com.spring.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {

	public static void main(String[] args) {
		// Spring과 Java Bean을 사용해 DI 하는 예시 코드
		// 사용하는 구현체가 바뀌면 xml 파일만 수정하면 됨.
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml")); // person.xml 에서 의존성 설정을 가져옴
		PersonService person1 = (PersonService) factory.getBean("personService"); // xml의 beans 설정에 명시된 id를 사용해 beans 가져옴. 싱글턴 패턴

		// Java 코드를 사용해 직접 객체를 생성하는 예시 코드
		// 사용하는 구현체가 바뀌면 코드를 찾아 수정해야 함
		PersonService person2 = new PersonServiceImpl();


		person1.sayHello();
		person2.sayHello();
	}

}
