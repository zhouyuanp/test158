package com.iftest.day2;

import java.util.Set;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import sun.awt.AWTAccessor.SystemTrayAccessor;

public class JSONTest {

	public static void main(String[] args) {
		JSONObject obj1 = new JSONObject(); // ���� ����   �½�JSONObject���͵Ķ���
		obj1.put("key1", "value1"); // value����Ԫ��     key�������ַ�������
		obj1.put("key2", 123);
		obj1.put("key3", 12.34);
		System.out.println(obj1);
    
		// ����֪��value��ʲô����  ֪��key1������Ӧ��value1

		String value1 = obj1.getString("key1");
		System.out.println(value1);

		int value2 = obj1.getIntValue("key2");
		System.out.println(value2);

		float value3 = obj1.getFloatValue("key3");
		System.out.println(value3);
		// ת������   ��JSONObject����ת��ΪString����    //�ӿ���
		String str1 = obj1.toString();
		System.out.println(str1);
		//��String����JSONObject��ʽ������ת��ΪJSONObject����    //���ָ�ʽ�Ļ�ת
		JSONObject obj2 = JSONObject.parseObject(str1);
		System.out.println(obj2);
		///////////////
		//��α���JSONObject�����Ԫ��value
		Set<String> keySet = obj1.keySet(); // ���� ����
		for (String key : keySet) {
			System.out.println(obj1.get(key));     //ȡֵ

			if (key.equals("key2")) {             //�ж�ֵ�Ƿ���� ������ɹ�123 

				if (obj1.get(key).toString().equals("123")) {
					System.out.println("SUCCESS");
				} else {
					System.out.println("FAIL");
				}
			}

		}

		///////////////////////////
		JSONArray arr1 = new JSONArray(); // ���� ���� //����һ��JSONOArray����

		arr1.add("element1");     //�ڶ��������Ԫ��
		arr1.add(123);
		arr1.add(12.34);
		arr1.add(obj1);
         
		System.out.println(arr1);   //���

		String ele1 = arr1.getString(0);    // ��JSONArray�����л�ȡԪ��
		System.out.println(ele1);

		int ele2 = arr1.getIntValue(1);
		System.out.println(ele2);

		float ele3 = arr1.getFloatValue(2);
		System.out.println(ele3);

		JSONObject ele4 = arr1.getJSONObject(3); // 
		System.out.println(ele4);
//1.��α���JSONArray�е�Ԫ��
//array.size()������ȡJSONArray��Ԫ�صĸ���
		for (int i = 0; i < arr1.size(); i++) {     //����Ԫ��
			System.out.println(arr1.get(i));
		}
		for (Object object : arr1) {
			System.out.println(object);
		}
		//��JSONArray���͵�����ת��ΪString����
		String str2 = arr1.toString();
		System.out.println(str2);
//��String����JSONArray��ʽ������ת��ΪJSONArray����
		JSONArray arr2 = JSONArray.parseArray(str2);
		System.out.println(arr2);

	}

}
