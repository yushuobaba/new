package com.ujiuye.Dao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Myaspect {
	/**
	 * @author Administrator
	 *ǰ��֪ͨ ����֪ͨ ����֪ͨ ����֪ͨ �쳣֪ͨ
	 */
	
	public void beforeAdvice(JoinPoint jp) {
		System.out.println(jp.getTarget());
		System.out.println(jp.getArgs());
		
		System.out.println("ǰ��ִ֪ͨ����");
	}
	public void afterAdvice(JoinPoint jp) {
		System.out.println(jp.getTarget());
		System.out.println(jp.getArgs());
		
		System.out.println("����ִ֪ͨ����");
	}
	public void finallyAdvice(JoinPoint jp) {
		System.out.println(jp.getTarget());
		System.out.println(jp.getArgs());
		
		System.out.println("����ִ֪ͨ����");
	}
	public void exceptionAdvice(Throwable ex) {
		System.out.println(ex.getMessage());
		System.out.println("�쳣ִ֪ͨ����");
	}
	
	public Object aroundAdvice(ProceedingJoinPoint pcd) {
		Object proceed=null;
		System.out.println("����ǰ");
		try {
			proceed = pcd.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("���ƺ�");
		return proceed;
	}
}
