package com.rr.myaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.rr.annotation.HandleErrorMessage;

@Aspect
@Component
public class ExceptionHandler {

	// @Pointcut("execution(** com.rr.dao.EmpDao.getEmp(..))")
	@Pointcut("@annotation(com.rr.annotation.HandleErrorMessage)")
	public void myPointCut() {
	}

	@Around("myPointCut()")
	public void exceptionAdvice(ProceedingJoinPoint joinPoint) {

		try {
			joinPoint.proceed();
		} catch (Throwable e) {

			MethodSignature sig = (MethodSignature) joinPoint.getSignature();

			HandleErrorMessage han = sig.getMethod().getAnnotation(HandleErrorMessage.class);

			System.out.println("value in annoataion is : " + han.value());
			System.out.println(" exceptionAdvice came");

			throw new RuntimeException("Exception raised in method : " + sig.getMethod().getName() + " in class :"
					+ sig.getMethod().getClass().getSimpleName());

		}

	}

}
