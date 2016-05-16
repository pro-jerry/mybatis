package com.corejava.multithread;

import org.junit.Test;

public class ThreadTest {

	
	/**
	 * 判断线程在使用了interrupt()后，是否会立即中断，事实证明t1被置上中断状态并不会发生任何作用，
	 * 如果希望t1在中断后退出，就必须为它增加相应的中断代码处理
	 * @throws InterruptedException 
	 */
	@Test
	public  void isImmediately_Interrupted() throws InterruptedException{
		
		Thread t1 = new Thread(){
			@Override
			public void run() {
				
				while(true){
					if(Thread.currentThread().isInterrupted()){
						System.out.println("Interruted");
						break;
					}
					Thread.yield();
					System.out.println("11");
				}
			}
		};
		
		t1.start();
		Thread.sleep(10);
		t1.interrupt();
	}
	
	
	/**
	 * 测试wait()与notify()
	 */
	
	final static Object object  = new Object();
	
	public static class T1 extends Thread{
		
		@Override
		public void run() {
			
			synchronized (object) {
			
				System.out.println(System.currentTimeMillis()+":T1 start!");
				try {
					
					System.out.println(System.currentTimeMillis()+":T1 wait for object!");
					object.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(System.currentTimeMillis()+":T1 end!");
			}
		}
	}
	
	public static class T2 extends Thread{
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			synchronized (object) {
				
				System.out.println(System.currentTimeMillis()+":T2 start! notify one thread");
				object.notify();
				System.out.println(System.currentTimeMillis()+":T2 end!");
				try {
					
					Thread.sleep(2000);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		Thread t1 = new T1();
		Thread t2 = new T2();
		
		t1.start();
		t2.start();
	}
	
}
