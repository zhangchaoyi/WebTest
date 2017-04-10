package com.test.web.practice;

/**
 * 
 * @author chris
 * 
 *类加载过程的执行
父类的静态成员变量和静态代码块 > 子类的静态成员变量和静态代码块 > 父类的成员变量和非静态代码块 > 父类构造方法 > 子类的成员变量和非静态代码块 > 子类的构造方法
同一级别的按先后顺序执行，如静态成员变量和静态代码块
对于静态成员变量中出现
    public static StaticTest t1 = new StaticTest("t1");//
    public static int n = 99;

 则先进行实例化，加载StaticTest,执行StaticTest的静态成员变量和静态代码块，执行StaticTest的成员变量和代码块，调用StaticTest的构造方法
 再进行k的实例化
 是递归进行的
 */
public class StaticTest {
	
	public static int k = 0;
	public static Z z = new Z();//此时需要将Z加载，初始化,依次执行Z的静态和非静态内容
	public static StaticTest t1 = new StaticTest("t1");//此时先不执行静态代码块内容
	public static StaticTest t2 = new StaticTest("t2");
	public static int i = print("i");
	public static int n = 99;
	public int j = print("j");
	
	{
		print("构造快");
	}
	
	static{
		print("静态块");
	}
	
	public StaticTest(String str) {
		System.out.println((++k) + ":" + str + " i=" + i + " n=" + n);
		++n;
		++i;
	}
	
	public static int print(String str) {
		System.out.println((++k) + ":" + str + " i=" + i + " n=" + n);
		++i;
		return ++n;
	}
	public static void main(String[] args) {
		StaticTest t = new StaticTest("init");
	}

}

class Z{
	static {
		System.out.println("B static");
	}
	public Z(){
		System.out.println("AAA");
	}
}