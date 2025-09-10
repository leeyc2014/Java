package com.ruby.java.ch06객체구현;

public class Member1 {
	private String name;
	private int age;
	
	public Member1() {
		System.out.println("Member() 생성자 실행");
	}
	
	public void setName(String name) {
		
	}
	public static void main(String[] args) {
		System.out.println("main() 메서드 실행");
		new Member1();
	}
}