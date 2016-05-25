package com.corejava.multithread.v3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized的功能扩展:重入锁 ReentrantLock
 * @author Administrator
 *
 */
public class ReenterLock implements Runnable{

	public static ReenterLock reenterLock = new ReenterLock();
	public static int i=0;
	public static ReentrantLock lock = new ReentrantLock();
	@Override
	public void run() {

		for(int j=0;j<10000000;j++){
			
			lock.lock();
			try{
				i++;
			}finally{
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		
		ReenterLock r = new ReenterLock();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println(i);
		
	}
}
