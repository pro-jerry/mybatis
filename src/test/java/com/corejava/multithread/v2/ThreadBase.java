package com.corejava.multithread.v2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class ThreadBase {

	/**
	 * 2.8.3 HashMap 使用HashMpa会出现错误的结果，推荐使用ConcurrentHashMap
	 */
//	static Map<String,String> map = new HashMap<String, String>();
	static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
	
	public static class AddThead implements Runnable{

		int start = 0;
		
		public AddThead(int start) {
			super();
			this.start = start;
		}

		@Override
		public void run() {

			for(int i=start;i<100000;i+=2){
				map.put(Integer.toString(i), Integer.toBinaryString(i));
			}
		}
		
	}
	
	@Test
	public void testHashMapThread() throws InterruptedException{
		
		Thread t1 = new Thread(new AddThead(0));
		Thread t2 = new Thread(new AddThead(1));
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(map.size());
	}
	
	
	
	
	
	
	
	
}
