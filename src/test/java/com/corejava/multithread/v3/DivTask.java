package com.corejava.multithread.v3;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DivTask implements Runnable{

	int a,b;
	
	public DivTask(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	public void run() {

		double re = a/b;
		System.out.println(re);
	}
	
	public static void main(String[] args) {
		
		ThreadPoolExecutor pools = new ThreadPoolExecutor(
				0, 
				Integer.MAX_VALUE, 
				0, 
				TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
		
		for(int i=0;i<5;i++){
			pools.execute(new DivTask(100, i));
		}
	}
}
