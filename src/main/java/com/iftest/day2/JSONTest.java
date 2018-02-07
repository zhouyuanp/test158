package com.iftest.day2;

import java.util.Set;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import sun.awt.AWTAccessor.SystemTrayAccessor;

public class JSONTest {

	public static void main(String[] args) {
		JSONObject obj1 = new JSONObject(); // 报错 导包   新建JSONObject类型的对象
		obj1.put("key1", "value1"); // value任意元素     key必须是字符串类型
		obj1.put("key2", 123);
		obj1.put("key3", 12.34);
		System.out.println(obj1);
    
		// 首先知道value是什么类型  知道key1输出相对应对value1

		String value1 = obj1.getString("key1");
		System.out.println(value1);

		int value2 = obj1.getIntValue("key2");
		System.out.println(value2);

		float value3 = obj1.getFloatValue("key3");
		System.out.println(value3);
		// 转换类型   将JSONObject类型转换为String类型    //接口用
		String str1 = obj1.toString();
		System.out.println(str1);
		//将String类型JSONObject格式的数据转换为JSONObject类型    //两种格式的互转
		JSONObject obj2 = JSONObject.parseObject(str1);
		System.out.println(obj2);
		///////////////
		//如何遍历JSONObject对象的元素value
		Set<String> keySet = obj1.keySet(); // 报错 导包
		for (String key : keySet) {
			System.out.println(obj1.get(key));     //取值

			if (key.equals("key2")) {             //判断值是否相等 是输出成功123 

				if (obj1.get(key).toString().equals("123")) {
					System.out.println("SUCCESS");
				} else {
					System.out.println("FAIL");
				}
			}

		}

		///////////////////////////
		JSONArray arr1 = new JSONArray(); // 报错 导包 //声明一个JSONOArray对象

		arr1.add("element1");     //在对象中添加元素
		arr1.add(123);
		arr1.add(12.34);
		arr1.add(obj1);
         
		System.out.println(arr1);   //输出

		String ele1 = arr1.getString(0);    // 从JSONArray对象中获取元素
		System.out.println(ele1);

		int ele2 = arr1.getIntValue(1);
		System.out.println(ele2);

		float ele3 = arr1.getFloatValue(2);
		System.out.println(ele3);

		JSONObject ele4 = arr1.getJSONObject(3); // 
		System.out.println(ele4);
//1.如何遍历JSONArray中的元素
//array.size()方法获取JSONArray中元素的个数
		for (int i = 0; i < arr1.size(); i++) {     //遍历元素
			System.out.println(arr1.get(i));
		}
		for (Object object : arr1) {
			System.out.println(object);
		}
		//将JSONArray类型的数据转换为String类型
		String str2 = arr1.toString();
		System.out.println(str2);
//将String类型JSONArray格式的数据转换为JSONArray类型
		JSONArray arr2 = JSONArray.parseArray(str2);
		System.out.println(arr2);

	}

}
