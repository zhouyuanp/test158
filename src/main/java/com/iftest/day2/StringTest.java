package com.iftest.day2;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class StringTest {

	public static void main(String[] args) {
		String str = "abcdefj";     // 定义一个String的类
		char c = str.charAt(4); // charAt 获取字符串中指定位置的字符
		System.out.println(c);    //输出4 =e
		int length = str.length(); //获取字符串的长度
		System.out.println(length); // 输出长度

		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));       //正序输出所有字符
		}
		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.println(str.charAt(i));      //倒序输出所有字符
		}
		
		if (str.equals("abcdef")) {//重新输入定义一个str.equals("abcdef")判断是否与String str = "abcdefj";一样
			System.out.println("equals");
		} else{
			System.out.println("not equals");
		}
/////////////////////////////////////////////////////////////////////////////////////
		String str1 = " abc def ";
		System.out.println(str1.length()); /// 输出去字符串的长度
		System.out.println(str1); // 输出带空格的字符串
		System.out.println(str1.trim().length()); // 输出去空格的长度
		System.out.println(str1.trim()); // 输出去除空格字符串

	}

   
	// 输出判断回文字符串
	//方法1
		public static void isParlindrome(String str){
			String reversed = "  ";//空
			for (int i = str.length()-1;i>=0;i--){
				reversed = reversed + str.charAt(i);
				System.out.println(reversed);
			}
			
			
			////方法2
			StringBuffer sb = new StringBuffer(str);
			reversed = sb.reverse().toString();
			
		
			if(str.equals(reversed)){
				System.out.println(str + "是回文字符串");
			}else{
				System.out.println(str + "不是回文字符串");
			}

	}

   }
