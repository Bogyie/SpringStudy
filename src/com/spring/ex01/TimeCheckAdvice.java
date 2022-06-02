package com.spring.ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TimeCheckAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // before
        System.out.println("시간측정 시작");
        long beforeTiem = System.currentTimeMillis();
        // proceed
        Object object = methodInvocation.proceed();
        // after
        System.out.print("실행시간 : ");
        System.out.println(System.currentTimeMillis() - beforeTiem);
        return object;
    }
}
