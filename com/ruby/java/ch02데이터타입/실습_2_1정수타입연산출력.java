package com.ruby.java.ch02데이터타입;

public class 실습_2_1정수타입연산출력 {

	public static void main(String[] args) {
		//정수 사칙연산
		// 정수형 변수 선언 및 초기화
		/*
		* 정수 변수 num1, num2을 각각 12, 5로 초기화한다
		*/
		// 사칙연산 수행
		/*
		* num1, num2를 덧셈, 차이, 곱, 나눈 몫을 정수 변수 sum, difference, product, quotient로 저장한다
		*/
		// 결과 출력
		/*
		* 출력 형태는 다음과 같이 4줄에 출력한다.
		* "덧셈 = **"
		* "뺄셈 = **"
		* "곱셈 = **"
		* "나눗셈 = **"
		*/
		int num1 = 12;
		int num2 = 5;
		int sum = num1 + num2;
		int difference = num1 - num2;
		int product = num1 * num2;
		int quotient = num1 / num2;
		
		System.out.println("\"" + "덧셈 = "+ sum + "\"");
		System.out.println("\"" + "뺄셈 = "+ difference + "\"");
		System.out.println("\"" + "곱셈 = "+ product + "\"");
		System.out.println("\"" + "나눗셈 = "+ quotient + "\"");
	}

}
