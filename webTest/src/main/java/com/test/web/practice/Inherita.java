package com.test.web.practice;

public class Inherita {
	public static void main(String[] args){
//		Bird bird = new Hawl("hawl","red");
//		bird.fly();
//		bird.test();
//		Class<?> c = bird.getClass();
		Hawl b = new Hello("hello", "aa");
		b.test("a","b");
	}
}

abstract class Bird {
	String name;
	String color;
	
	abstract void fly();
	public Bird(String name, String color){
		this.name = name;
		this.color = color;
		System.out.println("Bird Fly");
	}
	static void test(){
		System.out.println("test");
	}

}

class Hawl extends Bird {

	public Hawl(String name, String color) {
		super(name, color);
		
	}
	
	@Override
	void fly() {
		System.out.println("Hawl Fly");
		System.out.println(name + "-" + color);
	}
	public void test(String a, String b){
		System.out.println("hawl");
	}
	
}

class Hello extends Hawl {
	public Hello(String a, String b) {
		super(a, b);
	}
	@Override
	public void test(String c, String d){
		System.out.println("Hello");
	}
}
