package com.xml.read.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TestXmlByDom4j {

	@Test
	public void testReadStudentXml() throws Exception{
		//创建核心对象
		SAXReader reader = new SAXReader();
		
		//创建dom树
		Document dom = reader.read("D:\\program\\eclipse_chuanzhiboke\\XmlTest\\xml\\student.xml");
		
		//获取根结点
		Element root = dom.getRootElement();
		
		//获取其他节点
		List<Element> list = root.elements();
		
		//遍历集合
		for(Element ele : list){
			String text = ele.elementText("name");
			System.out.println(text);
		}
		//获取root的version属性
		String attr = root.attributeValue("version");
		System.out.println(attr);
	}
	
	@Test
	public void testReadWebXml()throws Exception{
		//创建核心对象SAXReader
		SAXReader reader = new SAXReader();
		//创建dom树
		Document dom = reader.read("D:\\program\\eclipse_chuanzhiboke\\XmlTest\\xml\\web.xml");
		//获取根结点
		Element root = dom.getRootElement();
		//获取其他节点
		List<Element> list = root.elements();
		for(Element ele : list){
			String text = ele.elementText("servlet-name");
			System.out.println(text);
		}
		
		//获取根结点的属性值
		String attr = root.attributeValue("version");
		System.out.println(attr);
		
	}
}
