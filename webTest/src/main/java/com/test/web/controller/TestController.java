package com.test.web.controller;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.web.di.Student;


@Controller
@RequestMapping(value = "/a")
public class TestController {
//	@Resource
	private Student student;
	
	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}
	@ResponseBody
	@RequestMapping(value = "/data")
	public String getData() {
		return "{hello:4}";
	}
	public static void main(String[] args){}
}
class Test{
	static volatile int sum = 10;
	static AtomicInteger ac = new AtomicInteger(0); 
	
	public synchronized static void reduceMoney(){
		sum = sum - 1;
	}
	public static void main(String[] args){
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				while(sum > 0){	
					reduceMoney();				
					System.out.println("t1:"+sum);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Thread.yield();					
				}
			}
		},"t1");
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				while(sum > 0){
					reduceMoney();
					System.out.println("t2:"+sum);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Thread.yield();
				}
			}
		},"t2");
		t1.start();
		t2.start();
	}
}