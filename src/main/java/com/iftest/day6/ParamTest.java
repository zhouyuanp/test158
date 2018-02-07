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
		URI uri = new URIBuilder()      //ͳһ��Դ��ʾ������Ԫ�ض�λ   
				.setScheme("http")
				.setHost("192.168.146.135")
				.setPort(8080)
				.setPath("/test158/FormServlet")
				.setParameter("a", a)
				.setParameter("b", b)  //����
				.build();
		HttpGet request = new HttpGet(uri);//�Ѳ������Ľ����ֵ������
		CloseableHttpResponse response = client.execute(request);  //��Ӧ�ӿͻ����õ�����Ĳ���
		String actual = EntityUtils.toString(response.getEntity());//����Ӧ������ת�����Ͳ���ֵ��String
		System.out.println(actual); //���ʵ�ʽ��
		Assert.assertEquals(actual, expected); // ʵ�ʽ�� Ԥ�ڽ��  ѡ�Է��� //���ӿ� ��ʵ�ʽ����Ԥ�ڽ�����жԱ�

	}

}
