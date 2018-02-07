package com.iftest.day2;

public class EtendsA {

	String name;
	int age;
                                         //静态的只能调用静态的 加 static
	private void func1() {  //私有的             //构造方法=函数      不在一个文件夹要加import+包名
		System.out.println("from func1");
	}

	public void func2() {
		System.out.println("from func2");
	}

}
