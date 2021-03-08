package com.company.yedam.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExpectTimeAspect {
	@Pointcut("execution(* com.company.yedam..*Impl.*One(..))")
	public void getpointcut() {}
	
	@Around("getpointcut()")
	public Object measure(ProceedingJoinPoint pjp) {
		System.out.println("[around] before");
		long start = System.nanoTime();
		Object result = null;
		//현재시간을 nanoTime으로 값을 들고옴
		try {
			result = pjp.proceed(); //서비스 호출
			return result;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			long finish = System.nanoTime();
			System.out.println("[around] after 실행시간: " + (finish-start));
		}
		return result;	
	}
}
