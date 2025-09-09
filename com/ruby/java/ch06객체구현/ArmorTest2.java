package com.ruby.java.ch06객체구현;
/*
 * 216페이지 6.1.2 자바의 메모리
 * 
 * 자바 메모리: 
 *  1) 메소드영역: 클래스 정보, 필드, 그리고 메소드에 대한 정의
 *     static: 정적 변수와 같은 정적 데이터가 저장되는 공간
 *  2) heap 영역: new 객체 생성된 인스턴스 객체
 *     "hello" 스트링 리터럴: heap의 string constant pool에 저장
 *  3) stack 영역: 222 페이지 참조변수 선언하기
 */
public class ArmorTest2 {
	public static void main(String[] args) {
		Armor suit = new Armor();
		// suit = null;//suit 참조변수가 가리키던 객체를 garbage collection
		
		suit.setName("mark6");//java.lang.NullPointerException
		//228페이지 (3) null 값이란? 문단 이해 필수
		suit.setHeight(180);
		System.out.println(suit.getName() + " : " + suit.getHeight());
	}
}