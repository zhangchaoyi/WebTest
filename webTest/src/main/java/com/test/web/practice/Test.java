package com.test.web.practice;

import java.util.*;

public class Test {
	public int x;
	public static void main(String[] args){
//		new B();
//		new A();
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		list.remove(new Integer("10"));
		System.out.println(list);
		String a = new String();
	}
}

class A{
	public Test t;
	public A(){
		init();
	}
	public void init(){
		t=new Test();
		t.x=5;
		System.out.println(t.x);
	}
}
class B extends A{
	public B(){
		super();
	}
	public void init(){
		System.out.println(t.x);
	}
}
/**
 * 
 * 
 * 
 */

class C{
	
}
