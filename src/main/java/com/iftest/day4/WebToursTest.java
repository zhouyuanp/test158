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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebToursTest {

	public static void main(String[] args) throws Exception { // �쳣����

		// �����������һ������

		CloseableHttpClient client = HttpClients.createDefault();

		HttpGet request = new HttpGet();
		URI uri = new URIBuilder().setScheme("http")
				.setHost("172.31.6.178")
				.setPort(1080)
				.setPath("/cgi-bin/nav.pl")
				.setParameter("in", "home")
				.build();
		request.setURI(uri);
		CloseableHttpResponse response = client.execute(request);

		HttpEntity responseEntity = response.getEntity();
		String result = EntityUtils.toString(responseEntity);
		System.out.println(result);
		// ����Ӧ��ʹ��jsop��ȡsession��ֵ
		Document doc = Jsoup.parse(result);
		Elements elements = doc.getElementsByAttributeValue("name", "userSession");
		String session = elements.attr("value");
		System.out.println(session);

		// 2.�½�һ��ʹ��POST���󷽷����������,ʹ�ýӿڵ������ַ���г�ʼ��
		HttpPost request1 = new HttpPost("http://172.31.6.178:1080/cgi-bin/login.pl");

		// 3.�½�һ��UrlEncodedFormEntityʵ�����,ʹ�ò����Ͳ���ֵ�б���г�ʼ��
		List<NameValuePair> list = new ArrayList<NameValuePair>(); // ʵ��
																	// //NameValuePair�������ͽӿ�
		list.add(new BasicNameValuePair("userSession", session));
		list.add(new BasicNameValuePair("username", "test15810"));
		list.add(new BasicNameValuePair("password", "1234567"));
		list.add(new BasicNameValuePair("JSFormSubmit", "off"));
		list.add(new BasicNameValuePair("login.x", "41"));
		list.add(new BasicNameValuePair("login.y", "2"));
		list.add(new BasicNameValuePair("JSFormSubmit", "off"));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "utf-8"); // �̶�����
		// 4.��ʵ�����ֵ����������ʵ������
		request1.setEntity(entity); // ʵ�� setEntity
		// 5.�½�һ����Ӧ����,���ܿͻ��˷����������Ӧ
		CloseableHttpResponse response1 = client.execute(request1);

		// 6.����Ӧ������ȡʵ�ʽ��
		HttpEntity responseEntity1 = response1.getEntity();
		String result1 = EntityUtils.toString(responseEntity1);
		System.out.println(result1);
		// 7.��ʵ�ʽ���������е�Ԥ�ڽ�����бȽ�

	}

}
