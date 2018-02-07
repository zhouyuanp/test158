package com.iftest.day2;

public class ExceptionTest {

	public static void main(String[] args) {      //选择父类
	try {
		Thread.sleep(3000); 
	} catch (InterruptedException e) {             //方法   是对异常进行处理
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  //方法的参数列表后面

	}

}
