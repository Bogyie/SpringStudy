# 스프링 AOP 기능

## 관점 지향 프로그래밍의 등장
- 주 기능과 보조 기능의 분리
  - 코드 유지관리 용이
  - 주 기능 : 로그인, 회원등급
  - 보조 기능 : 로깅, 보안, 프랜잭션
- 기능 구조도
  - 주 기능은 도메인을 의미
  - 보조 기능은 여러 도메인에서 공통적으로 사용되는 기능을 의미

## 스프링에서 AOP 기능 사용하기
- AOP 관련 용어

| 용어        | 설명                                                     |
|-----------|--------------------------------------------------------|
| aspect    | 구현하고자 하는 보조 기능                                         |
| advice    | aspect 의 실제 구현체(클래스). 메서드 호출을 기준으로 여러 지점에서 실행됨         |
| joinpoint | advice 를 적용하는 지점. 스프링은 method 결함점만 제공                  |
| pointcut  | advice 가 적용되는 대상을 지정. 패키지이름.클래스이름.메서드이름을 정규식으로 지정하여 사용 |
| target    | advice 가 적용되는 클래스를 의미                                  |
| weaving   | advice 를 주기능에 적용하는 것                                   |

### 스프링 API 를 시용한 AOP 기능 구현 과정
1. target 클래스를 지정
2. advice 클래스를 지정
3. 설정 파일에서 pointcut 을 설정
4. 설정 파일에서 advice 와 pointcut 을 결합하는 advice 를 설정
5. 설정 파일에서 spring 의 ProxyFactoryBean 클래스를 이용해 target 에 advice 를 설정
6. getBean 메서드로 빈 객체에 접근해 사용

### 스프링 API 에서 제공하는 여러 가지 advice 인터페이스
- MethodBeforeAdvice : 메서드 실행 전
- AfterReturningAdvice : 메서드 실행 완료 후
- ThrowAdvice : 메서드에서 예외 발생시
- MethodInterceptor : 메서드의 실행 전/후와 예외 발생시

### Spring AOP 설정 파일
```xml
<!--해당하는 위치가 어디있는지 설정-->
<!--1. target(주기능) 클래스를 지정-->
<bean id="calcTarget" class="com.spring.ex01.Calculator" />
<!--2. advice(보조기능) 클래스를 지정-->
<bean id="logAdvice" class="com.spring.ex01.LoggingAdvice" />

<bean id="proxyCal" class="org.springframework.aop.framework.ProxyFactoryBean">
  <!--ref : 주입의 의미, target 에 보조기능을 주입  -->
  <property name="target" ref="calcTarget"/>
  
  <!--3/ pointcut 을 설정 : interceptor, 어떤걸 사용해서 advice 를 찾을지 설정 : names  -->
  <property name="interceptorNames">
     <list>
        <!-- 사용할 advice 클래스 설정 -->
        <value>logAdvice</value>
     </list>
  </property>
</bean>
```

### Spring AOP 파일 구조
- Calculator : 주기능
- LoggingAdvice : 보조기능


### Spring 보조기능 구현
- class AdviceClassName implement MethodInterceptor
  - invoke override
- 