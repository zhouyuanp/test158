package com.iftest.day5;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLTest {
	public static void main(String[] args) throws Exception {
     	doPost();
		doGetTVstationString();
	}

	public static void doPost() throws Exception {

		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
		+ "<root>"
		+ "<a>3</a>"
		+ "<b>4</b>"
		+ "</root>";
		// 1.新建一个客户端对象
		CloseableHttpClient client = HttpClients.createDefault();
		try {
			// 2.新建一个POST请求对象,使用接口请求地址进行初始化
			HttpPost request = new HttpPost("http://192.168.146.135:8080/test158/XMLServlet");
			// 3.新建一个StringEntity实体对象,使用xml进行初始化
			StringEntity entity = new StringEntity(xml, "utf-8");
			// 4.将实体对象赋值请求对象的实体属性
			request.setEntity(entity);
			// 5.新建一个响应对象,接受客户端发送请求后的响应
			CloseableHttpResponse response = client.execute(request);
			try { 
				// 6.从响应中提取实际结果
				HttpEntity responseEntity = response.getEntity();
				// String result = EntityUtils.toString(responseEntity);
				// System.out.println(result);
				InputStream is = responseEntity.getContent();

				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(is);

				Element root = doc.getDocumentElement(); // 选3c导包
				NodeList nl = root.getElementsByTagName("sum");//得出响应的结果的名
				String sum = nl.item(0).getTextContent();
				System.out.println(sum);
				// 7.将实际结果与用例中的预期结果进行对比
			} finally {
				response.close();

			}

		} finally {
			client.close();
		}
	}
	//////////////////////////////////////////////////////////////////////////
	
        public static  void doGetTVstationString() throws Exception{

   String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://WebXml.com.cn/\">"
    		+ "<soapenv:Header/>" 
    		+ "<soapenv:Body>"
            + "<web:getTVstationString>"
    		+ "<web:theAreaID>4</web:theAreaID>"
            + "</web:getTVstationString>" 
            + "</soapenv:Body>" 
    		+ "</soapenv:Envelope>";
    		// 1.新建一个客户端对象
    		CloseableHttpClient client = HttpClients.createDefault();
    		try {
    			HttpPost request = new HttpPost("http://www.webxml.com.cn/webservices/ChinaTVprogramWebService.asmx");
    			StringEntity entity = new StringEntity(xml, "utf-8");
    			request.setEntity(entity);
    			request.setHeader("Content-Type","text/xml;charset=UTF-8");//设置消息头
    			CloseableHttpResponse response = client.execute(request);
    			try {
    			
    				HttpEntity responseEntity = response.getEntity();
//    				String str = EntityUtils.toString(responseEntity);
//    				String str = responseEntity.toString();
//    				System.out.println(str);  //检查结果排错
    				InputStream is = responseEntity.getContent();
    				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    				DocumentBuilder db = dbf.newDocumentBuilder();
    				Document doc = db.parse(is);
    				Element root = doc.getDocumentElement(); // 选3c导包
    				NodeList nl = root.getElementsByTagName("getTVstationStringResult"); //取元素集合
    				String result = nl.item(0).getTextContent();
    				System.out.println(result);
    			} finally {
    				response.close();
    			}
    		} finally {
    			client.close();
    		}
    	}
	}	
		
		
		
		

	
	
