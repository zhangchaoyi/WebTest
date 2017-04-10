package com.test.web.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MutiThread {
	public static void main(String[] args){
		ExecutorService es = Executors.newCachedThreadPool();
		SingleThread st = new SingleThread("st");
		SingleThread stz = new SingleThread("stz");
		Future f1 = es.submit(st);
		Future f2 = es.submit(stz);
		try {
			System.out.println(f1.get());
			System.out.println(f2.get());
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
class SingleThread implements Callable{
	private String name;
	public String call() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("start");
		Thread.yield();
		return name;
	}
	public SingleThread(String name){
		this.name = name;
	}
	
}