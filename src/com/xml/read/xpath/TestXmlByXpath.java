package com.xml.read.xpath;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TestXmlByXpath {

	@Test
	public void testReadStudentXml()throws Exception{
		//获取dom树
		Document dom = new SAXReader().read("D:\\program\\eclipse_chuanzhiboke\\XmlTest\\xml\\student.xml");
		
		//获取单一节点
		Element ele = (Element) dom.selectSingleNode("//student/name");
		System.out.println(ele.getText()+"--");
		
		//获取节点列表
		List<Element> list = dom.selectNodes("//student/name");
		for (Element elem : list) {
			System.out.println(elem.getText());
		}
	}
	
	
}
