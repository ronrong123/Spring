package com.company.yedam.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterAdvice {
	Logger logger = LoggerFactory.getLogger(AfterAdvice.class);
	@AfterReturning(pointcut="LogAdvice.allpointcut()", returning = "returnObj")
	public void agferLog(JoinPoint jp, Object returnObj) {
		String name = jp.getSignature().getName();
		//리턴
		logger.info("[공통로그] after \n"
					+ name
					+ (returnObj != null ? returnObj : "no return"));
	}
}
