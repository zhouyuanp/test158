package com.iftest.day4;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class FormTest {
	public static void main(String[] args) throws Exception {

		doPOST();
		doPOST1();
	
	}

	public static void doPOST() throws Exception {
		// 1.�½�һ���ͻ��˶���
		CloseableHttpClient client = HttpClients.createDefault();
		try {                                       

			// 2.�½�һ��ʹ��POST���󷽷����������,ʹ�ýӿڵ������ַ���г�ʼ��
			HttpPost request = new HttpPost("http://192.168.146.135:8080/test158/FormServlet");
             //
			// 3.�½�һ��UrlEncodedFormEntityʵ�����,ʹ�ò����Ͳ���ֵ�б���г�ʼ��
			List<NameValuePair> list = new ArrayList<NameValuePair>(); // ʵ��
													// //NameValuePair�������ͽӿ�
			list.add(new BasicNameValuePair("a", "1"));
			list.add(new BasicNameValuePair("b", "2"));
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "utf-8"); // �̶�����
			// 4.��ʵ�����ֵ����������ʵ������
			request.setEntity(entity); // ʵ�� setEntity
			// 5.�½�һ����Ӧ����,���ܿͻ��˷����������Ӧ
			CloseableHttpResponse response = client.execute(request);
			try {
				// 6.����Ӧ������ȡʵ�ʽ��
				HttpEntity responseEntity = response.getEntity();  //����Ӧ����ֵ����Ӧʵ��
				String result = EntityUtils.toString(responseEntity);
				System.out.println(result);
				// 7.��ʵ�ʽ���������е�Ԥ�ڽ�����бȽ�

			} finally {
				response.close();
			}

		} finally {
			client.close();
		}
	}
///////////////////////////////////////////////////////
		public static void doPOST1() throws Exception {
			// 1.�½�һ���ͻ��˶���
			CloseableHttpClient client = HttpClients.createDefault();
			try {

				// 2.�½�һ��ʹ��POST���󷽷����������,ʹ�ýӿڵ������ַ���г�ʼ��
				HttpPost request = new HttpPost("http://172.31.6.178:1080/cgi-bin/login.pl");

				// 3.�½�һ��UrlEncodedFormEntityʵ�����,ʹ�ò����Ͳ���ֵ�б���г�ʼ��
				List<NameValuePair> list = new ArrayList<NameValuePair>(); // ʵ��
																			// //NameValuePair�������ͽӿ�
				list.add(new BasicNameValuePair("username", "test15810"));
				list.add(new BasicNameValuePair("password", "1234567"));
				list.add(new BasicNameValuePair("passwordConfirm", "1234567"));
				list.add(new BasicNameValuePair("firstName"," "));
				list.add(new BasicNameValuePair("lastName", " "));
				list.add(new BasicNameValuePair("address1", " "));
				list.add(new BasicNameValuePair("address2", " "));
				list.add(new BasicNameValuePair("register.x", "50"));
				list.add(new BasicNameValuePair("register.y", "7"));
			
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "utf-8"); // �̶�����
				// 4.��ʵ�����ֵ����������ʵ������
				request.setEntity(entity); // ʵ�� setEntity
				// 5.�½�һ����Ӧ����,���ܿͻ��˷����������Ӧ
				CloseableHttpResponse response = client.execute(request);
				try {
					// 6.����Ӧ������ȡʵ�ʽ��
					HttpEntity responseEntity = response.getEntity();
					String result = EntityUtils.toString(responseEntity);
					System.out.println(result);
					// 7.��ʵ�ʽ���������е�Ԥ�ڽ�����бȽ�

				} finally {
					response.close();
				}

			} finally {
				client.close();
			}

	}
}
