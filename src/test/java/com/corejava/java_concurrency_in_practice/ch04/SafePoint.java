package com.corejava.java_concurrency_in_practice.ch04;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class SafePoint {

	@GuardedBy("this")
	private int x,y;

	public SafePoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public SafePoint(int[] a) {

		this(a[0],a[1]);
	}
	
	public SafePoint(SafePoint p){
		this(p.get());
	}
	
	public synchronized int[] get(){
		return new int[]{x,y};
	}
	
	public synchronized void set(int x,int y){
		
		this.x = x;
		this.y = y;
	}
	
}
