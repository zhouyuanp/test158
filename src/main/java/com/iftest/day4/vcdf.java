package com.iftest.day4;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
public class vcdf {
	public static void main(String[] args) throws Exception {
		doQuery();
	}
	public static void doQuery() throws Exception { // �׳��쳣
		CloseableHttpClient client = HttpClients.createDefault();
		URI uri = new URIBuilder()
				.setScheme("https")
				.setHost("api.weixin.qq.com")
				.setPath("/cgi-bin/token") // ��Ŀ��
				.setParameter("grant_type", "client_credential") // ������ ����ֵ
				.setParameter("appid", "wx79cdc2b24b9f84c1")
				.setParameter("secret", "c0142e40c99bb2ef76a7a983296b603f").build();
		HttpGet request = new HttpGet(uri);
		CloseableHttpResponse response = client.execute(request);
		HttpEntity responseEntity = response.getEntity();
		String result = EntityUtils.toString(responseEntity);
		System.out.println(result);
	}
}
