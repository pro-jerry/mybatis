package com.mybatis.base;

import org.junit.*;

public class Test {

	/**
	 * 测试左移“<<”,num<<3-->就是num*2^3(num乘以2的3次方)
	 */
	@org.junit.Test
	public void moveLeft(){
		
		int num = 10;
		String i =Integer.toBinaryString(num);
		System.out.println(i);
		num = num<<3;
		System.out.println(num);
	}
	
	/**
	 * 测试右移“>>”,num>>3-->就是num/2^3(num除以2的3次方)
	 */
	@org.junit.Test
	public void moveRight(){
		
		int num = 1000;
		String i =Integer.toBinaryString(num);
		System.out.println(i);
		num = num>>>3;
		System.out.println(num);
	}
	
	/**
	 * 无符号右移，向右移动几位，空位都以“0”补齐
	 */
	@org.junit.Test
	public void unsignedMoveRight(){
		
		int num = -1000;
		String i =Integer.toBinaryString(num);
		System.out.println(i);
		num = num>>>3;
		System.out.println(num);
	}
	
	
}
