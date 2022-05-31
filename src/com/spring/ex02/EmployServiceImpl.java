package com.spring.ex02;

public class EmployServiceImpl implements PersonService {
    private String name;
    private String job;

    public EmployServiceImpl(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public void sayHello() {
        System.out.println("이름: " + name);
        System.out.println("직책: " + job);
    }
}
