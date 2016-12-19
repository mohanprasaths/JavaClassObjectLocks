package com.mohan;

import java.util.Random;

public class JavaThreadSyncLock {
	public static final class GenerateNumberAndPrint{
		Random randomNumberGenrator = new Random();
		static Object a = new Object();
		private String classNameSync;
		public GenerateNumberAndPrint(String a) {
			// TODO Auto-generated constructor stub
			classNameSync = a;
		}
		void printTheRandomThing() throws InterruptedException{
			synchronized (a) {
				
			
			for(int i=0;i<60;i++){
				Thread.sleep(10);
			 System.out.println(classNameSync + "this is my random numebr"+randomNumberGenrator.nextInt(50)+1);
			}
			}
		}
	}
public static void main(String[] args){
//	GenerateNumberAndPrint test1 = new GenerateNumberAndPrint("test1");
//	test1.printTheRandomThing();
	final myThreadOne TestOne = new myThreadOne();
	final myThreadTwo TestTwo = new myThreadTwo();
	Thread t1 = new Thread(TestOne);
	Thread t2 = new Thread(TestTwo);
	try{
	t1.start();
	t2.start();
	}catch(Exception a){
		
	}
	
}
public static class myThreadOne implements  Runnable {
	GenerateNumberAndPrint test1;
	public void run() {
		test1 = new GenerateNumberAndPrint("test1");

		try {
			test1.printTheRandomThing();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void start() {
		// TODO Auto-generated method stub
	}
}
public static class myThreadTwo implements  Runnable {
	GenerateNumberAndPrint test2;
	public void run() {
		test2 = new GenerateNumberAndPrint("test2");

		try {
			test2.printTheRandomThing();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void start() {
		// TODO Auto-generated method stub

	}
}
}
