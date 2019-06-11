package com.st.springboot;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	@Pointcut("execution (* print*(..))")
	public void allMethods() {

	}

	@Before("allMethods()")
	public void beforeAdviceMethod(JoinPoint jp) {
		System.out.println("Before Advice --> " + jp.getSignature());
	}

	@After("allMethods()")
	public void afterAdviceMethod(JoinPoint jp) {
		System.out.println("After Advice --> " + jp.getSignature());
	}
}
