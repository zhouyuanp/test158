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

	public static void main(String[] args) throws Exception { // 异常声明

		// 向服务器发送一个请求

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
		// 从响应中使用jsop提取session的值
		Document doc = Jsoup.parse(result);
		Elements elements = doc.getElementsByAttributeValue("name", "userSession");
		String session = elements.attr("value");
		System.out.println(session);

		// 2.新建一个使用POST请求方法的请求对象,使用接口的请求地址进行初始化
		HttpPost request1 = new HttpPost("http://172.31.6.178:1080/cgi-bin/login.pl");

		// 3.新建一个UrlEncodedFormEntity实体对象,使用参数和参数值列表进行初始化
		List<NameValuePair> list = new ArrayList<NameValuePair>(); // 实现
																	// //NameValuePair数据类型接口
		list.add(new BasicNameValuePair("userSession", session));
		list.add(new BasicNameValuePair("username", "test15810"));
		list.add(new BasicNameValuePair("password", "1234567"));
		list.add(new BasicNameValuePair("JSFormSubmit", "off"));
		list.add(new BasicNameValuePair("login.x", "41"));
		list.add(new BasicNameValuePair("login.y", "2"));
		list.add(new BasicNameValuePair("JSFormSubmit", "off"));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "utf-8"); // 固定方法
		// 4.将实体对象赋值给请求对象的实体属性
		request1.setEntity(entity); // 实体 setEntity
		// 5.新建一个响应对象,接受客户端发送请求的响应
		CloseableHttpResponse response1 = client.execute(request1);

		// 6.从响应里面提取实际结果
		HttpEntity responseEntity1 = response1.getEntity();
		String result1 = EntityUtils.toString(responseEntity1);
		System.out.println(result1);
		// 7.将实际结果与用例中的预期结果进行比较

	}

}
