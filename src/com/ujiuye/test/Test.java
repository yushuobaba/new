package com.ujiuye.test;

import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		YunSuan ys = new YunSuan();
		TimeShow ts = new TimeShow();
		MyProxy mpMyProxy = new MyProxy(ys,ts);
		YunSuan newys =(YunSuan)Proxy.newProxyInstance(ys.getClass().getClassLoader(),ys.getClass().getInterfaces(),mpMyProxy);
		newys.add(3, 4);
		
	}
}
