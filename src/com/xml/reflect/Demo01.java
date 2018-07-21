package com.xml.reflect;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import com.xml.demo01.HelloXml;
/**
 * 反射
 * @author Peter
 *
 */
public class Demo01 {
	
	@Test
	public void f0(){
		Object obj = null;
		HelloXml hi = new HelloXml();
		hi.hello();
		hi.hello("peter");
		hi.hello("mic", 23);
	}
	
	@Test
	public void f1() throws Exception{
		HelloXml hi = new HelloXml();
		Class clazz = hi.getClass();
		HelloXml hi1 = (HelloXml) clazz.newInstance();
		Method method = clazz.getMethod("hello");
		method.invoke(hi1);
	}
	
	/**
	 * 利用反射
	 * @throws Exception 类没有发现
	 */
	@Test
	public void f2() throws Exception{
		Class clazz = Class.forName("com.xml.demo01.HelloXml");
		//通过字节码对象创建一个实例对象(相当于调用空参的构造器)
		HelloXml hi = (HelloXml) clazz.newInstance();
		hi.hello();
		hi.hello("peter");
		hi.hello("mic", 23);
	}
	
	/**
	 * 调用空参数的hello()方法
	 * @throws Exception
	 */
	@Test
	public void f3()throws Exception{
		Class clazz = Class.forName("com.xml.demo01.HelloXml");
		//通过字节码对象创建一个实例对象(相当于调用空参的构造器)
		HelloXml hi = (HelloXml) clazz.newInstance();
		Method method = clazz.getMethod("hello");
		method.invoke(hi);
	}
	/**
	 * 调用有两个参数的hello()方法
	 * @throws Exception
	 */
	@Test
	public void f4()throws Exception{
		Class clazz = HelloXml.class;
		HelloXml hi = (HelloXml) clazz.newInstance();
		Method method = clazz.getMethod("hello", String.class, int.class);
		method.invoke(hi, "peter", 23);
	}
	
	@Test
	public void f5()throws Exception{
		//创建核心对象
		SAXReader reader = new SAXReader();
		
		//获取dom树
		Document dom = reader.read("D:\\program\\eclipse_chuanzhiboke\\XmlTest\\xml\\web.xml");
		
		//获取根结点
		Element root = dom.getRootElement();
		
		//获取子结点的值
		String value = (String) root.selectSingleNode("//servlet/servlet-class").getText();
		String key = (String)root.selectSingleNode("//servlet-mapping/url-parrten").getText();
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put(key, value);
		
		Class clazz = Class.forName(map.get("/hello"));
		HelloXml hi = (HelloXml) clazz.newInstance();
		
		Method method = clazz.getMethod("hello");
		method.invoke(hi);
		
	}
	
}
