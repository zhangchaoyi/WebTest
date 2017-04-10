package com.test.web.test.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * application.xml 中配置的bean默认的单例的，需要在xml中bean配置scope="prototype"设置为多例
 * 另外可以配置init方法getBean时调用 以及destroy方法 close时调用；但此时如果配置了scope="prototype" 则不执行
 * xml中配置bean默认是lazy-init=default，false默认值，因此在xml加载到内存时直接就会执行bean的构造函数
 * @author chris
 *
 */
public class HelloIocTest {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/application.xml");  
		/*测试bean多例
		HelloIoc helloIoc = (HelloIoc) applicationContext.getBean("helloIoc");  
		HelloIoc helloIoc2 = (HelloIoc) applicationContext.getBean("helloIoc");  
		helloIoc.setName("xiaoming");  
		helloIoc2.setName("test");  
		System.out.println(helloIoc);  
		System.out.println(helloIoc2);  
		System.out.println(helloIoc.getName());  
		System.out.println(helloIoc2.getName());
		*/
		/*测试init 和 destroy
		HelloIoc helloIoc = (HelloIoc) applicationContext.getBean("helloIoc");
		ClassPathXmlApplicationContext cPathContext = (ClassPathXmlApplicationContext)applicationContext;
		cPathContext.close();
		*/
//		HelloIoc helloIoc = applicationContext.getBean("helloIoc", HelloIoc.class);
//		helloIoc.setName("bbb");
//		System.out.println(helloIoc.getName() + "aa");
		HelloIoc hello = applicationContext.getBean("helloFactory", HelloIoc.class);
		System.out.println(hello.getName());
	}
}
