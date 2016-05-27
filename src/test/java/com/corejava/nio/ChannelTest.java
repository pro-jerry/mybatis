package com.corejava.nio;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import org.junit.Test;

public class ChannelTest {

	@Test
	public void testReadFile() throws IOException {
		
		RandomAccessFile aFile = new RandomAccessFile("e://1.txt", "rw");
		FileChannel inChannel = aFile.getChannel();
		
		ByteBuffer buf =ByteBuffer.allocate(48);
		int bytesRead = inChannel.read(buf);
		
		while(bytesRead!=-1){
			System.out.println("Read " + bytesRead);
			buf.flip();
			while(buf.hasRemaining()){
				System.out.print((char)buf.get());
			}
			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}
	
	/**
	 *通道之间的数据传输
	 * transferFrom()方法将数据源从通道传输到FileChannel中
	 * @throws IOException
	 */
	@Test
	public void transferFrom() throws IOException{
		
		RandomAccessFile fromFile = new RandomAccessFile("e://1.txt", "rw");
		FileChannel fromChannel = fromFile.getChannel();
		
		RandomAccessFile toFile = new RandomAccessFile("e://2.txt", "rw");
		FileChannel toChannel = toFile.getChannel();
		
		long position = 0;
		long count = fromChannel.size();
		
		toChannel.transferFrom(fromChannel, position, count);
	}
	
	@Test
	public void transferTo() throws IOException{
		
		RandomAccessFile fromFile = new RandomAccessFile("e://1.txt", "rw");
		FileChannel fromChannel = fromFile.getChannel();
		
		RandomAccessFile toFile = new RandomAccessFile("e://2.txt", "rw");
		FileChannel toChannel = toFile.getChannel();
		
		long position=0;
		long count = fromChannel.size();
		
		fromChannel.transferTo(position, count, toChannel);
	}
	
	
	
	/**
	 * FileChannel无法设置为非阻塞模式，总是运行在阻塞模式下
	 * @throws IOException 
	 */
	@Test
	public void testReadFromChannel() throws IOException{
		
		RandomAccessFile file = new RandomAccessFile(new File("e://1.txt"), "rw");
		FileChannel channel = file.getChannel();
		
		ByteBuffer buf = ByteBuffer.allocate(4000);
		int byteRead = channel.read(buf);
		
		StringBuilder sb = new StringBuilder();
		
		while(byteRead!=-1){
			
			buf.flip();
			while(buf.hasRemaining()){
				sb.append((char)buf.get());
			}
			buf.clear();
			byteRead = channel.read(buf);
		}
//		System.out.println(sb.toString());
		String str = sb.toString();
		String s = new String(str.getBytes(),"utf-8");
		System.out.println(s);
		
	}
	/**
	 * 向FileChannel中写数据
	 * @throws IOException 
	 */
	@Test
	public void testWriteToChannel() throws IOException{
		
		@SuppressWarnings("resource")
		RandomAccessFile file = new RandomAccessFile("e://2.txt", "rw");
		FileChannel channel = file.getChannel();
		String newData = "New String to write to ..... "+System.currentTimeMillis();
		ByteBuffer buf = ByteBuffer.allocate(60);
		buf.clear();
		
		buf.put(newData.getBytes());
		buf.flip();
		
		while(buf.hasRemaining()){
			channel.write(buf);
		}
		
		channel.close();
	}
	
	/**
	 * Java编码问题
	 * <a href="https://www.ibm.com/developerworks/cn/java/j-lo-chinesecoding/">
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException{
		
		
		
	}
	
}
