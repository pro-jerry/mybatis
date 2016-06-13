package com.corejava.java_concurrency_in_practice.ch04;

import net.jcip.annotations.NotThreadSafe;

/**
 * 
 * @author jerry
 *
 */
@NotThreadSafe
public class MutablePoint {

	public int x,y;

	public MutablePoint() {
		x=0;
		y=0;
	}
	
	public MutablePoint(MutablePoint p){
		
		this.x = p.x;
		this.y = p.y;
	}
}
