package com.corejava.multithread.v3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * scheduleAtFixedRate()创建一个周期性任务。任务开始于给定的初始延时。后续的任务按照给定的周期进行：
 * 后期第一个任务将会在initialDelay+perid时执行，后续的第二个任务将在inittialDelay+2*period时，
 * 进行
 * @author Administrator
 *
 */
public class ScheduledExecutorServiceDemo {

	public static void main(String[] args) {
		
		ScheduledExecutorService ses  =  Executors.newScheduledThreadPool(10);
		//如果前面的任务没完成，则调度不会启动
		ses.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {

				try {
					Thread.sleep(1000);
					System.out.println(System.currentTimeMillis()/1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, 0, 2, TimeUnit.SECONDS);
		
	}
}
