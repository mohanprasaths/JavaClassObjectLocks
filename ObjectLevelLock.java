package com.mohan;

public class ObjectLevelLock {
	public static class DummyClass{
		 private final  Object lock = new Object(); 

		public String name ;
		public DummyClass(String name) {
			// TODO Auto-generated constructor stub
			this.name = name;
		}
		public void printNameWithNumber(int number){
			synchronized (lock) {
				System.out.println( this.name + "   --  "+number);

			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DummyClass dummyObject = new DummyClass("test");
		PrintFirstFifty printFifty = new PrintFirstFifty(dummyObject);
		Thread t1 =  new Thread(printFifty);
		PrintFirstHundred printHundred = new PrintFirstHundred(dummyObject);
		Thread t2 =  new Thread(printHundred);
		t1.start();
		t2.start();
	}
	public static class PrintFirstFifty implements Runnable{
		DummyClass myObject;
		public PrintFirstFifty(DummyClass dummyObject) {
			// TODO Auto-generated constructor stub
		  myObject = dummyObject;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<50;i++){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				myObject.printNameWithNumber(i);
			}
		}
		
	}
	public static class PrintFirstHundred implements Runnable{
		DummyClass myObject;
		public PrintFirstHundred(DummyClass dummyObject) {
			// TODO Auto-generated constructor stub
		  myObject = dummyObject;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=50;i<100;i++){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				myObject.printNameWithNumber(i);
			}
		}
		
	}
}
