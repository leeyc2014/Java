package com.ruby.java.ch07상속;
/*
//class Person2 {
final class Person2 {
	private final String ssn_id;
	// private final String ssn_id = "2025_09";
	private String name;
	private int age;

	public Person2() {// 오류 - 이유는?
		System.out.println("Person2() 생성자 실행!");
	}

	public Person2(String sid, int age) {// final 변수 초기화
		ssn_id = sid;
		this.age = age;
		System.out.println("Person2(sid, age) 생성자 실행!");
	}

	void set_ssn_id(String sid) {
		ssn_id = sid;// 오류 - 이유는? final로 선언한 변수이기 때문에 setter로 변경 불가능
	}

	public final String toString() {
		return name + ", " + age;
	}
}

class Student2 extends Person2 {
	String dept;

	public Student2(String name, int age, String dept) {
		super(name, age);
		this.dept = dept;
	}
	public final String toString() {
		return super.toString() + ", " + dept;
	}
}

public class PersonFinal {

	public static void main(String[] args) {
		Student2 s2 = new Student2("딥러닝");
		System.out.println(s2);

	}

}
*/