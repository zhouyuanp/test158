package com.iftest.day1;

public class Functions {
	public static void main(String[] args) {

		Dome d = new Dome();//new是dome中的方法//
//		无参无返
		d.func1();
//		有参无返
		d.func2(1,2);
//		无参有返
		int sum = d.func3();  //声明一个变量sum  接收调用的数
		System.out.println(sum);
//		有参有返
     	int sum1 =d.func4(1, 2);
		System.out.println(sum1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
