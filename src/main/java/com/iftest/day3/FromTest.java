package com.iftest.day3;

import java.net.URI;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class FromTest {
	public static void main(String[] args) throws Exception {
		// 用main方法调用方法
		doGet();

		doQuery();
	}

	public static void doGet() throws Exception { // 抛出异常
	        // 1.新建一个客户端对象
		CloseableHttpClient client = HttpClients.createDefault();
		try {
			// 2.新建一个GET请求对象
			HttpGet request = new HttpGet();
			// 3.给请求对象的构造请求地址属性赋值 setScheme规范
			URI uri = new URIBuilder()    //建立一个URT
					.setScheme("http")     //协议   Scheme协议
					.setHost("192.168.146.135")   //主机地址   Host主机
					.setPort(8080)    //端口号   Port 设置端口
					.setPath("/test158/FormServlet") // 项目名   Path 道路
					.setParameter("a", "1") // 参数名 参数值   Parameter 参数
					.setParameter("b", "2")
					.build();                 //build  构造
			        request.setURI(uri);   //把uri代入 request 
			// 4.新建一个响应对象,接收客户端发送请求的响应 
			CloseableHttpResponse response = client.execute(request);//可关闭的响应CloseableHttpResponse
			try { // 可关闭响应                    响应                        //客户端      执行               请求
				// 5.从响应中提取实际结果 //响应实体
				HttpEntity responseEntity = response.getEntity();
				// 转换类型 专门工具类
				String sum = EntityUtils.toString(responseEntity);
				System.out.println(sum);

				// 6.用实际结果与用例中的预期结果进行比较

			} finally {
				response.close(); // 响应结束
			}

		} finally {
			client.close();    //客户端关闭
		}

	}

	public static void doQuery() throws Exception { // 抛出异常
		CloseableHttpClient client = HttpClients.createDefault();
		try {
			URI uri = new URIBuilder()
					.setScheme("http")
					.setHost("dev-hanzi.lqdzj.cn")
					.setPath("/ajax_stroke_search") // 项目名
					.setParameter("q", "⿱亠") // 参数名 参数值
					.setParameter("mode", "1")
					.build();
			HttpGet request = new HttpGet(uri);
			CloseableHttpResponse response = client.execute(request);
			HttpEntity responseEntity = response.getEntity();
			String result = EntityUtils.toString(responseEntity);
			System.out.println(result);
			// 将String类型JSONObject格式的数据转换为JSONObject类型
			JSONObject object = JSONObject.parseObject(result);

			JSONArray array = object.getJSONArray("result");
			for (Object o : array) {

				JSONObject obj = JSONObject.parseObject(o.toString());
				String hanzi = obj.getString("hanzi_char");
				System.out.println(hanzi);
			}

		} finally {
			client.close();
		}

	}
}
