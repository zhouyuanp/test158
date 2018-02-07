package com.iftest.day2;

public class ClassTest extends EtendsB implements InterfaceA, InterfaceB {    //接口 A B
	public static void main(String[] args) {
		EtendsB eb = new EtendsB();      //类的继承  类的是实例化
		eb.func2();
	    eb.func3();
		ClassTest ct = new ClassTest();         //一个等号就是赋值的意思  l
        ct.func4();
		InterfaceA ia = new ClassTest(); //接口  借助子类实例化
		ia.func5();
        InterfaceB ic = new ClassTest();
        ic.func7();
        ic.func8(5);
      
	}

	public void func6() {                              //ClassTest点击报错的地方
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
