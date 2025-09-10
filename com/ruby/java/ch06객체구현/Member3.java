package com.ruby.java.ch06객체구현;

public class Member3 {
	private String name;
	private int age;
	
	public Member3() {
		this("guest");
	}
	
	public Member3(String name) {
		this(name, 0);
	}
	
	public Member3(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return name + " : " + age;
	}
	
	public static void main(String[] args) {
		Member3 m1 = new Member3();
		Member3 m2 = new Member3("Amy");
		Member3 m3 = new Member3("Amy", 23);
		
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
	}
}
