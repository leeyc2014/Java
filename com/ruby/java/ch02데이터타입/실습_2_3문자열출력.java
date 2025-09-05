package com.ruby.java.ch02데이터타입;

public class 실습_2_3문자열출력 {

	public static void main(String[] args) {
		// 문자열 변수 선언 및 초기화
		/*
		* 이름, 나이, 도시를 String, int, String으로 선언한다.
		* 3개 변수에 값으로 "홍길동", 25, "부산"으로 초기화한다
		*/
		// 사용자 정보 출력
		/*
		* 출력 형태는 다음과 같이 1줄에 출력한다.
		* "이름 = **, 나이 = **, 도시 = **"
		*/
		String name = "홍길동";
		int age = 25;
		String city = "부산";
		System.out.print("\"" +"이름 = " +name);
		System.out.print(", 나이 = " +age);
		System.out.println(", 도시 = " +city + "\"");
	}

}
