package com.iftest.day5;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Servlet implementation class XMLServler
 */
public class XMLServler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XMLServler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����������л�ȡ�ͻ��˷��͹�����������
		InputStream is = request.getInputStream(); // ��������
		// ����ȡ��������ת��λDocument����
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		Document doc = null;
		try {

			db = dbf.newDocumentBuilder();
			doc = db.parse(is);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {

			e.printStackTrace();
		} // ��ȡxmlDOM����ĸ��ڵ�
		Element root = doc.getDocumentElement();
		// ���ݲ������ƻ�ȡ�ڵ�
		NodeList nla = root.getElementsByTagName("a");
		NodeList nlb = root.getElementsByTagName("b");
		// �ӽڵ��б��л�ȡ�ڵ�ֵ
		String a = nla.item(0).getTextContent();
		String b = nlb.item(0).getTextContent();
		// ת�����Ͳ�����
		int int_a = Integer.parseInt(a);
		int int_b = Integer.parseInt(b);
		int sum = int_a + int_b;
		// ����������ӵ���Ӧxml��
		String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" // ת�봦��
				+ "<root>"
				+ "<a>" + a + "</a>"
				+ "<b>" + b + "</b>"
				+ "<sum>" + sum + "</sum>"
				+ "</root>";
		response.getWriter().append(result);

		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
