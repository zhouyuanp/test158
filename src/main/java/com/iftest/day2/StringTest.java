package com.iftest.day2;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class StringTest {

	public static void main(String[] args) {
		String str = "abcdefj";     // ����һ��String����
		char c = str.charAt(4); // charAt ��ȡ�ַ�����ָ��λ�õ��ַ�
		System.out.println(c);    //���4 =e
		int length = str.length(); //��ȡ�ַ����ĳ���
		System.out.println(length); // �������

		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));       //������������ַ�
		}
		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.println(str.charAt(i));      //������������ַ�
		}
		
		if (str.equals("abcdef")) {//�������붨��һ��str.equals("abcdef")�ж��Ƿ���String str = "abcdefj";һ��
			System.out.println("equals");
		} else{
			System.out.println("not equals");
		}
/////////////////////////////////////////////////////////////////////////////////////
		String str1 = " abc def ";
		System.out.println(str1.length()); /// ���ȥ�ַ����ĳ���
		System.out.println(str1); // ������ո���ַ���
		System.out.println(str1.trim().length()); // ���ȥ�ո�ĳ���
		System.out.println(str1.trim()); // ���ȥ���ո��ַ���

	}

   
	// ����жϻ����ַ���
	//����1
		public static void isParlindrome(String str){
			String reversed = "  ";//��
			for (int i = str.length()-1;i>=0;i--){
				reversed = reversed + str.charAt(i);
				System.out.println(reversed);
			}
			
			
			////����2
			StringBuffer sb = new StringBuffer(str);
			reversed = sb.reverse().toString();
			
		
			if(str.equals(reversed)){
				System.out.println(str + "�ǻ����ַ���");
			}else{
				System.out.println(str + "���ǻ����ַ���");
			}

	}

   }
