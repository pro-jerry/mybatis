package com.corejava.multithread.v3;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅栏: CyclicBarrier
 * @author Administrator
 *
 */
public class CyclicCarrierDemo {

	public static class Soldier implements Runnable{
		
		private String soldier;
		private final CyclicBarrier cyclic;
		
		public Soldier(CyclicBarrier cyclic, String soldier) {
			super();
			this.soldier = soldier;
			this.cyclic = cyclic;
		}


		@Override
		public void run() {

			try {
				//等待所以士兵到齐
				cyclic.await();
				doWork();
				//等待所有士兵完成工作
				cyclic.await();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}


		private void doWork() {

			try {
				Thread.sleep(Math.abs(new Random().nextInt()%10000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(soldier+":任务完成!");
		}
	}
	
	public static class BarrierRun implements Runnable{

		boolean flag;
		int N;
		
		public BarrierRun(boolean flag, int n) {
			super();
			this.flag = flag;
			N = n;
		}

		@Override
		public void run() {
			if(flag){
				System.out.println("司令:[士兵"+N+"个，任务完成]");
			}else{
				
				System.out.println("司令:[士兵"+N+"个，集合完毕]");
				flag = true;
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		final int N = 10;
		Thread[] allSoldier = new Thread[10];
		boolean flsg = false;
		CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(flsg, N));
		System.out.println("集合队伍!");
		for(int i=0;i<N;i++){
			System.out.println("士兵"+i+"报道!");
			allSoldier[i] = new Thread(new Soldier(cyclic, "士兵"+i));
			allSoldier[i].start();
		}
	}
}
