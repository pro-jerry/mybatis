package com.corejava.java_concurrency_in_practice.ch04;

/**
 * 通过一个私有锁来保护状态
 * @author jerry
 *
 */
public class PrivateLock<E> {

	private final Object myLock = new Object();
	
	E e;
	
	void someMethod(){
		
		synchronized (myLock) {
			//访问或修改E的状态
		}
	}
}
