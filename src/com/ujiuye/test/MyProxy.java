package com.ujiuye.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxy implements InvocationHandler {
	private Object obj;
	private TimeShow ts;
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object invoke = method.invoke(obj, args);
		
		return invoke;
	}
	public MyProxy(Object obj,TimeShow ts) {
		this.obj=obj;
		this.ts=ts;
	}
}
