package com.ujiuye.test;

import com.ujiuye.Dao.PersonDao;

public class Test2 {
	public static void main(String[] args) {
		//���������
		PersonDao dao = new PersonDaoImpl();
		//�������ܹ���
		Transaction tx = new Transaction();
		//�����������͸������߽��а�
		TransactionOroxyCglib tpCglib = new TransactionOroxyCglib(dao, tx);
		//�����������
		PersonDao ndao =(PersonDao)tpCglib.create();
		//����Ŀ�귽��
		ndao.save();
	}
}
