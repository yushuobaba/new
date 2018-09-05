package com.ujiuye.Dao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Myaspect {
	/**
	 * @author Administrator
	 *前置通知 后置通知 环绕通知 最终通知 异常通知
	 */
	
	public void beforeAdvice(JoinPoint jp) {
		System.out.println(jp.getTarget());
		System.out.println(jp.getArgs());
		
		System.out.println("前置通知执行了");
	}
	public void afterAdvice(JoinPoint jp) {
		System.out.println(jp.getTarget());
		System.out.println(jp.getArgs());
		
		System.out.println("后置通知执行了");
	}
	public void finallyAdvice(JoinPoint jp) {
		System.out.println(jp.getTarget());
		System.out.println(jp.getArgs());
		
		System.out.println("最终通知执行了");
	}
	public void exceptionAdvice(Throwable ex) {
		System.out.println(ex.getMessage());
		System.out.println("异常通知执行了");
	}
	
	public Object aroundAdvice(ProceedingJoinPoint pcd) {
		Object proceed=null;
		System.out.println("环绕前");
		try {
			proceed = pcd.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("环绕后");
		return proceed;
	}
}
