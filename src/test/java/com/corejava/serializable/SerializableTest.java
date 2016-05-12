package com.corejava.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream.GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream.PutField;
import java.io.Serializable;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <a href="http://www.runoob.com/java/java-serialization.html"/>
 * @author jerry
 *
 */
public class SerializableTest implements Serializable{

	private static final Logger log = LoggerFactory.getLogger(SerializableTest.class);
	
	/**
	 * 序列化对象
	 */
	@Test
	public void serializeObject(){
		
		Employee e = new Employee();
		e.name = "Reyan Ali";
		e.address="Phokka Kuan, Ambehta Peer";
		e.SSN=11122333;
		e.number=101;
		
		try {
			FileOutputStream fileOut = new FileOutputStream("e://test.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
			log.info("保存成功");
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * 反序列化对象
	 */
	@Test
	public void deserializeObject(){
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("e://test.txt"));
			Employee e = (Employee) in.readObject();
			in.close();
			log.info("name:"+e.name);
			log.info("address:"+e.address);
			log.info("SSN:"+e.SSN);
			log.info("Number:"+e.number);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <a href="https://www.ibm.com/developerworks/cn/java/j-lo-serial/">
	 */
	/**
	 * 虚拟机是否允许反序列化，不仅取决于类路径和功能代码是否一致，一个非常重要的一点是两个类的序列化 ID 是否一致
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 序列化并不保存静态变量
	 */
	
	private static int  staticVar=5;
	@Test
	public void testStaticVarIsSerializable(){
		
		try{
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("e://test.txt"));
			out.writeObject(new SerializableTest());
			out.close();
			
			SerializableTest.staticVar=10;
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("e://test.txt"));
			SerializableTest t = (SerializableTest) in.readObject();
			in.close();
			
			//10
			System.out.println(t.staticVar);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 父类序列化：要想将父类对象也序列化，就需要让父类也实现Serializable 接口
	 * Transient关键字:作用是控制变量的序列化，在变量声明前加上该关键字，可以阻止该变量被序列化到文件中，
	 * 				 在被反序列化后，transient 变量的值被设为初始值，如 int 型的是 0，对象型的是 null。
	 */
	
	private String password="pass";

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	private void writeObject(ObjectOutputStream out){
		
		try {
			
			PutField  putFields = out.putFields();
			System.out.println("原密码:" + password);
			password = "encryption";//模拟加密
			putFields.put("password", password);
			System.out.println("加密后的密码:" + password);
			out.writeFields();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void readObject(ObjectInputStream in) {
		try {
			GetField readFields = in.readFields();
			Object object = readFields.get("password", "");
			System.out.println("要解密的字符串:" + object.toString());
			password = "pass";//模拟解密,需要获得本地的密钥
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 敏感字段加密
	 */
	@Test
	public void testEncipher(){
		
		ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(
					new FileOutputStream("e://test.txt"));
			out.writeObject(new SerializableTest());
			out.close();

			ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
					"e://test.txt"));
			SerializableTest t = (SerializableTest) oin.readObject();
			System.out.println("解密后的字符串:" + t.getPassword());
			oin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 存储规则
	 * 两次写入对象，文件大小会变为两倍的大小，反序列化时，由于从文件读取，生成了两个对象，判断相等时应该是输入 false 才对，但是最后结果113,118,true
	 * 
	 * -->Java 序列化机制为了节省磁盘空间，具有特定的存储规则，当写入文件的为同一对象时，并不会再将对象的内容进行存储，
	 * 而只是再次存储一份引用，上面增加的 5 字节的存储空间就是新增引用和一些控制信息的空间。
	 * 反序列化时，恢复引用关系，使得t1,t2指向唯一对象，二者相等。输出true
	 */
	@Test
	public void testStorageRule(){
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("e://test.txt"));
			Employee test = new Employee();
			out.writeObject(test);
			out.flush();
			System.out.println(new File("e://test.txt").length());
			
			out.writeObject(test);
			out.flush();
			System.out.println(new File("e://test.txt").length());
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("e://test.txt"));
			Employee t1 = (Employee) in.readObject();
			Employee t2 = (Employee) in.readObject();
			
			System.out.println(t1==t2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
