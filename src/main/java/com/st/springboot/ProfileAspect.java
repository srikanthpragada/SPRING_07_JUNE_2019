package com.st.springboot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProfileAspect {
	@Around("execution (* process(..))")
	public Object beforeAndAfter(ProceedingJoinPoint pjp) {
		System.out.println("About to start process!");
		try {
			Object rv = pjp.proceed(pjp.getArgs());
			System.out.println("Done process!");
			return rv;
		} catch (Throwable  ex) {
			System.out.println("Error in process!");
			return null;
		}

	}
}
