package com.iftest.day1;

public class Dome {

	public static void main(String[] args) {
		//// �����޲��޷��ķ���
		func1();
		// �����в��޷��ķ���
		func2(1, 2); // ʵ���б�
		// �����޲��з��ķ���
		int sum = func3();
		System.out.println(func3());
		// �����в��з��ķ���
		int sum1 = func4(1, 2);   //����ֵ���ص�������
		System.out.println(sum1);
	}

	// �޲��޷�
	// a=1,b=2,������func1,��ӡ���a��b�ĺ�
	public static void func1() {
		int a = 1;
		int b = 2;
		int sum = a + b;
		System.out.println(sum);
	}

	// �в��޷�
	public static void func2(int a, int b) {
		int sum = a + b;
		System.out.println(sum);
	}

	// �޲��з�
	public static int func3() {
		int a = 1;
		int b = 2;
		int sum = a + b;
		return sum;
	}

	// �в��з�
	public static int func4(int a, int b) {
		int sum = a + b;
		return sum;
	}

}
