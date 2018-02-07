package com.iftest.day1;

public class arraytest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };

		// array [6];
		System.out.println(array[6]);
		// 输出数组中元素
		for (int i = 0; i < array.length; i++) { // 输出数组中元素//循环的索引
			System.out.println(array[i]); // 循环干什么事
		}
		// 倒序输出
		for (int i = array.length - 1; i >= 0; i--) { // 注意越界
			System.out.println(array[i]);
		}

		for (int i : array) { // for esch 输出
			System.out.println(i);
		}

	}

}
