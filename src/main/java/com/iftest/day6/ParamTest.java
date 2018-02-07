package com.iftest.day6;

import java.net.URI;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.databene.benerator.anno.Source;
import org.databene.feed4testng.FeedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParamTest extends FeedTest {

	@Test(dataProvider = "feeder")
	@Source("./data/add.csv")
	public static void doGet(String a, String b, String expected) throws Exception { //
		CloseableHttpClient client = HttpClients.createDefault();
		URI uri = new URIBuilder()      //统一资源标示符用于元素定位   
				.setScheme("http")
				.setHost("192.168.146.135")
				.setPort(8080)
				.setPath("/test158/FormServlet")
				.setParameter("a", a)
				.setParameter("b", b)  //参数
				.build();
		HttpGet request = new HttpGet(uri);//把参数化的结果赋值给请求
		CloseableHttpResponse response = client.execute(request);  //响应从客户端拿到请求的参数
		String actual = EntityUtils.toString(response.getEntity());//将响应的数据转换类型并赋值给String
		System.out.println(actual); //输出实际结果
		Assert.assertEquals(actual, expected); // 实际结果 预期结果  选对方法 //调接口 将实际结果与预期结果进行对比

	}

}
