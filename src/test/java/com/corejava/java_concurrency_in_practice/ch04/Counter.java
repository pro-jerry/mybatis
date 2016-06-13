package com.corejava.java_concurrency_in_practice.ch04;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * 使用java监视器模式的线程安全计数器（"监视器模式"）
 * @author Administrator
 *
 */
@ThreadSafe
public class Counter {

	@GuardedBy("this")
	private long value = 0;
	
	public synchronized long getValue(){
		
		return value;
	}
	
	public synchronized long increment(){
		
		if(value == Long.MAX_VALUE)
			throw new IllegalStateException("counter overflow");
		
		return ++value;
	}
	
	
}
