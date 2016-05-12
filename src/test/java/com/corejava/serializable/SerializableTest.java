package com.corejava.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;







import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <a href="http://www.runoob.com/java/java-serialization.html"/>
 * @author 军
 *
 */
public class SerializableTest {

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
	public void deserializeObject(){
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("e://test.txt"));
			Employee e = (Employee) in.readObject();
			in.close();
			log.info("name:"+e.name);
			log.info("address:"+e.address);
			log.info("SSN:"+e.SSN);
			log.info("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
