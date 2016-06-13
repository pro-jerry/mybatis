package com.corejava.java_concurrency_in_practice.ch04;

import java.util.HashSet;
import java.util.Set;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * 通过封闭机制来确保线程安全("装饰器模式")
 * @author Administrator
 *
 */
@ThreadSafe
public class PersonSet<E> {

	@GuardedBy("this")
	private final Set<E> mySet = new HashSet<E>();
	
	public synchronized void add(E e){
		mySet.add(e);
	}
	
	public synchronized boolean contains(E e){
		
		return mySet.contains(e);
	}
}
