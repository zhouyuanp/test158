package com.iftest.day5;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

public class JSONTest {
	public static void main (String []args)throws Exception{
		 doPost();
	
		
	}
	public static void doPost() throws Exception {
		// 1.�½�һ���ͻ��˶���
		CloseableHttpClient client = HttpClients.createDefault();    // ����json
		try {
			// 2.�½�һ��ʹ��POST���󷽷����������ʹ�ýӿڵ������ַ���г�ʼ��
			HttpPost request = new HttpPost("http://192.168.146.135:8080/test158/JSONServlet");

			// 3.�½�һ��UrlEncodedFormEntityʵ�����ʹ�ò����Ͳ���ֵ�б���г�ʼ��
			JSONObject obj = new JSONObject();
			obj.put("a", 1);
			obj.put("b", 2);
			StringEntity entity = new StringEntity(obj.toString(),"utf-8");

			// 4.��ʵ�����ֵ����������ʵ������
			request.setEntity(entity);

			// 5.�½�һ����Ӧ���󣬽��տͻ��˷����������Ӧ
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
