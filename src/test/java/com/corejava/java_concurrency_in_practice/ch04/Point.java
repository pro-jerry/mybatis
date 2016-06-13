package com.corejava.java_concurrency_in_practice.ch04;

import net.jcip.annotations.Immutable;

@Immutable
public class Point {

	public final int x,y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
}
