package com.iftest.day1;

public class arraytest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };

		// array [6];
		System.out.println(array[6]);
		// ���������Ԫ��
		for (int i = 0; i < array.length; i++) { // ���������Ԫ��//ѭ��������
			System.out.println(array[i]); // ѭ����ʲô��
		}
		// �������
		for (int i = array.length - 1; i >= 0; i--) { // ע��Խ��
			System.out.println(array[i]);
		}

		for (int i : array) { // for esch ���
			System.out.println(i);
		}

	}

}
