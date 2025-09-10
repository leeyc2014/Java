package com.ruby.java.ch06객체구현;

public class Member2 {
	private String name;
	private int age;
	
	public Member2() {
		System.out.println("Member() 생성자 실행");
	}
	
	public Member2(String name) {
		System.out.print("Member(String) 생성자 실행 : ");
		System.out.println(name);
	}
	
	public Member2(String name, int age) {
		System.out.print("Member(String, int) 생성자 실행 : ");
		System.out.println(name + " : " + age);
	}
	
	public void setName(String name) {
		
	}
	public static void main(String[] args) {
		System.out.println("main() 매서드 실행");
		new Member2();
		new Member2("Amy");
		new Member2("Amy", 23);
		new Member2();
	}

}
