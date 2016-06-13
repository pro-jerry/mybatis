package com.corejava.java_concurrency_in_practice.ch04;

import java.util.concurrent.atomic.AtomicInteger;

public class NumberRange {

	//不变性条件：lower<=upper
	private final AtomicInteger lower = new AtomicInteger();
	private final AtomicInteger upper = new AtomicInteger();
	
	public void setLower(int i){
		
		if(i>upper.get())
			throw new IllegalArgumentException("");
		lower.set(i);
	}
	
	public void setUpper(int i){
		
		if(i<lower.get())
			throw new IllegalArgumentException("can't set upper to "+i+"< lower");
		
		upper.set(i);
	}
	
	public boolean isInRange(int i){
		
		return (i>=lower.get() && i<=upper.get());
	}
	
	
	
}
