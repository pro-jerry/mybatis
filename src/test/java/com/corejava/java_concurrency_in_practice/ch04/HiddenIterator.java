package com.corejava.java_concurrency_in_practice.ch04;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import net.jcip.annotations.ThreadSafe;


@ThreadSafe
public class HiddenIterator {

	private final Set<Integer>  set = Collections.synchronizedSet(new HashSet<Integer>());
	
	public synchronized void add(Integer i){
	
		set.add(i);
	}
	
	public synchronized void remove(Integer i){
		set.remove(i);
	}
	
	public void addTenThings(){
		
		Random r = new Random();
		for(int i=0;i<10;i++){
			add(r.nextInt());
		}
		System.out.println("Debug:added ten elements to "+set);
		
	}
	
	
}
