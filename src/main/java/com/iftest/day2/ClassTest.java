package com.iftest.day2;

public class ClassTest extends EtendsB implements InterfaceA, InterfaceB {    //�ӿ� A B
	public static void main(String[] args) {
		EtendsB eb = new EtendsB();      //��ļ̳�  �����ʵ����
		eb.func2();
	    eb.func3();
		ClassTest ct = new ClassTest();         //һ���Ⱥž��Ǹ�ֵ����˼  l
        ct.func4();
		InterfaceA ia = new ClassTest(); //�ӿ�  ��������ʵ����
		ia.func5();
        InterfaceB ic = new ClassTest();
        ic.func7();
        ic.func8(5);
      
	}

	public void func6() {                              //ClassTest�������ĵط�
		// TODO Auto-generated method stub
		System.out.println("from func6");
	}

	public int func7() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int func8(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void func5() {
		// TODO Auto-generated method stub
		
	}
}
