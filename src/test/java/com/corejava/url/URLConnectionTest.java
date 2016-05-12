package com.corejava.url;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.codec.binary.Base64OutputStream;

public class URLConnectionTest {

	public static void main(String[] args) {
		
		try{
			String urlName;
			if(args.length>0) urlName=args[0];
			else urlName="http://www.baidu.com";
			
			URL url = new URL(urlName);
			URLConnection connection = url.openConnection();
			
			if(args.length>2){
				
				String username = args[1];
				String password = args[2];
				String input = username+":"+password;
				String encoding = base64Encode(input);
				connection.setRequestProperty("Authorization", "Base"+encoding);
			}
			connection.connect();
			
			Map<String,List<String>> headers = connection.getHeaderFields();
			for(Map.Entry<String, List<String>> entry:headers.entrySet()){
				
				String key = entry.getKey();
				for(String value:entry.getValue()){
					System.out.println(key+":"+value);
				}
			}
			
			System.out.println("--------------");
			System.out.println("getContentType:"+connection.getContentType());
			System.out.println("getContentLength:"+connection.getContentLength());
			System.out.println("getContentEncoding:"+connection.getContentEncoding());
			System.out.println("getDate:"+connection.getDate());
			System.out.println("getException:"+connection.getExpiration());
			System.out.println("getLastModifed:"+connection.getLastModified());
			System.out.println("---------------");
			
			Scanner in = new Scanner(connection.getInputStream());
			
			for(int n=1;in.hasNextLine()&&n<=10;n++){
				System.out.println(in.nextLine());
			}
			if(in.hasNextLine())
				System.out.println("...");
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	private static String base64Encode(String s) {

		ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		Base64OutputStream out = new Base64OutputStream(bOut);
		
		try {
			out.write(s.getBytes());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bOut.toString();
	}
}
