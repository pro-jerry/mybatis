package com.corejava.multithread;

public class GoodSuspend {

	public static Object u = new Object();
	
	public static class ChangeObjectThread extends Thread{
		
		volatile boolean suspendme = false;
		
		public void suspendMe(){
			
			suspendme = true;
		}
		
		public void resumeMe(){
			
			suspendme = false;
			synchronized (this) {
				notify();
			}
		}
		
		
		@Override
		public void run() {
			
			while(true){
				synchronized (this) {
					while(suspendme){
						try {
							wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
		}
		
		
	}
}
