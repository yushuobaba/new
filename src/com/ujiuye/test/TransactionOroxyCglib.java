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
	//������̬����Ķ���filter��
	public Object create() {
		Enhancer enhancer = new Enhancer();
		//
		enhancer.setSuperclass(obj.getClass());
		//�ص�����������ڴ������Ƕ���ִ��Ŀ�귢����ʱ����Ӹ�������
		enhancer.setCallback(this);
		Object create = enhancer.create();
		return create;
	}
}
