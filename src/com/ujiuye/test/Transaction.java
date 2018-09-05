package com.ujiuye.test;

public class Transaction {
	public void begin() {
		System.out.println("开启事务");
	}

	public void comit() {
		System.out.println("提交事务");
	}
}
