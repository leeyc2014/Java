package com.ruby.java.ch06객체구현;
/*
 * this 키워드는 현재 객체(인스턴스) 자신을 가리킨다 > 251페이지 6.3.4 자신을 가리키는 this
 * 
 * 1) 인스턴스 변수와 매개변수 구별
 *    -> 메서드나 생성자의 매개변수 이름이 인스턴스 변수 이름과 같을 때, this를 사용하여 인스턴스 변수에 접근
 * 2) 한 클래스 내의 다른 생성자를 호출할 때 사용
 *    ->  중복 코드를 줄이고 생성자 간의 연결을 명확하게 한다.
 *        this()는 반드시 생성자의 첫 줄에 위치
 * 3) 현재 인스턴스 자체를 반환
 *    -> 메서드가 현재 객체 자신을 반환 > return this;
 */
public class ThisTest {
	int i = 1; //클래스 필드
	
	ThisTest(int i){ //생성자
		i = i;//지역변수 i
		this.i = i;
	}
	public void first() {
		int i = 2;
		int j = 3;
		this.i = i + j;

		second(4);
	}

	public void second(int i) {
		int j = 5;
		this.i = i + j;
	}
	public void show() {
		System.out.println("i = " + i);
	}
	public static void main(String[] args) {
		/*
		 * stackframe 설명: 253페이지 상단 문단 - 오류가 있다
		 */
		ThisTest exam = new ThisTest(10);
		exam.show();
		System.out.println(" 메소드 first() 실행후: ");
		exam.first();//this 키워드는 현재 실행 중인 메서드가 속한 객체 자신을 가리킨다 
		//메소드 first()에서 this는 exam 객체를 가리킨다
		// 254페이지 하단 문단
		//exam.i;
		exam.show();
	}
}