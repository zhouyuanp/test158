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
		// 1.新建一个客户端对象
		CloseableHttpClient client = HttpClients.createDefault();
		try {                                       

			// 2.新建一个使用POST请求方法的请求对象,使用接口的请求地址进行初始化
			HttpPost request = new HttpPost("http://192.168.146.135:8080/test158/FormServlet");
             //
			// 3.新建一个UrlEncodedFormEntity实体对象,使用参数和参数值列表进行初始化
			List<NameValuePair> list = new ArrayList<NameValuePair>(); // 实现
													// //NameValuePair数据类型接口
			list.add(new BasicNameValuePair("a", "1"));
			list.add(new BasicNameValuePair("b", "2"));
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "utf-8"); // 固定方法
			// 4.将实体对象赋值给请求对象的实体属性
			request.setEntity(entity); // 实体 setEntity
			// 5.新建一个响应对象,接受客户端发送请求的响应
			CloseableHttpResponse response = client.execute(request);
			try {
				// 6.从响应里面提取实际结果
				HttpEntity responseEntity = response.getEntity();  //将响应对象赋值给响应实体
				String result = EntityUtils.toString(responseEntity);
				System.out.println(result);
				// 7.将实际结果与用例中的预期结果进行比较

			} finally {
				response.close();
			}

		} finally {
			client.close();
		}
	}
///////////////////////////////////////////////////////
		public static void doPOST1() throws Exception {
			// 1.新建一个客户端对象
			CloseableHttpClient client = HttpClients.createDefault();
			try {

				// 2.新建一个使用POST请求方法的请求对象,使用接口的请求地址进行初始化
				HttpPost request = new HttpPost("http://172.31.6.178:1080/cgi-bin/login.pl");

				// 3.新建一个UrlEncodedFormEntity实体对象,使用参数和参数值列表进行初始化
				List<NameValuePair> list = new ArrayList<NameValuePair>(); // 实现
																			// //NameValuePair数据类型接口
				list.add(new BasicNameValuePair("username", "test15810"));
				list.add(new BasicNameValuePair("password", "1234567"));
				list.add(new BasicNameValuePair("passwordConfirm", "1234567"));
				list.add(new BasicNameValuePair("firstName"," "));
				list.add(new BasicNameValuePair("lastName", " "));
				list.add(new BasicNameValuePair("address1", " "));
				list.add(new BasicNameValuePair("address2", " "));
				list.add(new BasicNameValuePair("register.x", "50"));
				list.add(new BasicNameValuePair("register.y", "7"));
			
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "utf-8"); // 固定方法
				// 4.将实体对象赋值给请求对象的实体属性
				request.setEntity(entity); // 实体 setEntity
				// 5.新建一个响应对象,接受客户端发送请求的响应
				CloseableHttpResponse response = client.execute(request);
				try {
					// 6.从响应里面提取实际结果
					HttpEntity responseEntity = response.getEntity();
					String result = EntityUtils.toString(responseEntity);
					System.out.println(result);
					// 7.将实际结果与用例中的预期结果进行比较

				} finally {
					response.close();
				}

			} finally {
				client.close();
			}

	}
}
