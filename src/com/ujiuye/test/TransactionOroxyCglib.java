package com.ujiuye.test;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class TransactionOroxyCglib implements MethodInterceptor {
	private Object obj;
	private Transaction tx;
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		tx.begin();
		Object nobj = arg1.invoke(obj, arg2);
		tx.comit();
		return nobj;
	}
	public TransactionOroxyCglib(Object obj,Transaction tx) {
		this.obj=obj;
		this.tx=tx;
	}
	//创建动态代理的对象（filter）
	public Object create() {
		Enhancer enhancer = new Enhancer();
		//
		enhancer.setSuperclass(obj.getClass());
		//回调：代理对象在代替真是对象执行目标发发的时候，添加辅助功能
		enhancer.setCallback(this);
		Object create = enhancer.create();
		return create;
	}
}
