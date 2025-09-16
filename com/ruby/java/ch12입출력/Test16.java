package com.ruby.java.ch12입출력;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test16 {
	public static void main(String[] args) {
		try(ObjectInputStream in = 
				new ObjectInputStream(new FileInputStream("user.txt"))) {
			UserBean user = (UserBean) in.readObject();
			System.out.println(user.toString());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
