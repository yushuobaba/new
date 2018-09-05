package com.ujiuye.test;

import com.ujiuye.Dao.PersonDao;

public class Test2 {
	public static void main(String[] args) {
		//被代理对象
		PersonDao dao = new PersonDaoImpl();
		//辅助功能工具
		Transaction tx = new Transaction();
		//将被带离对象和辅助工具进行绑定
		TransactionOroxyCglib tpCglib = new TransactionOroxyCglib(dao, tx);
		//创建代理对象
		PersonDao ndao =(PersonDao)tpCglib.create();
		//调用目标方法
		ndao.save();
	}
}
