package com.corejava.java_concurrency_in_practice.ch04;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 独立的状态变量
 * @author jerry
 *
 * @param <E>
 */
public class VisualComponent<E> {

	private final List<E> keyListeners = new CopyOnWriteArrayList<E>();
	
	private final List<E> mouseListeners = new CopyOnWriteArrayList<E>();
	
	public void addKeyListener(E e){
		
		keyListeners.add(e);
	}
	
	public void addMouseListener(E e){
		mouseListeners.add(e);
	}
	
	public void removeMouseListeners(E e){
		
		mouseListeners.remove(e);
	}
	
	public void removeKeyListeners(E e){
		keyListeners.remove(e);
	}
}
