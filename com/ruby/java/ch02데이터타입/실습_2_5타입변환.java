package com.ruby.java.ch02데이터타입;
import java.util.Scanner;
public class 실습_2_5타입변환 {

	public static void main(String[] args) {
		// 정수형에서 실수형으로 변환 (묵시적 형 변환)
		/*
		* 정수형 변수를 화면에서 입력받아 double 변수로 변환하여 출력하는 코드를 작성한다.
		* 출력은 "정수변수값 = **, 실수변수값 = **"
		*/
		// 실수형에서 정수형으로 변환 (명시적 형 변환)
		/*
		* 실수형 변수 값을 화면에서 입력받아 정수로 변환하는 코드를 작성한다.
		* 출력은 "실수변수값 = **, 정수변수값 = **
		*/
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double m = n;
		double a = sc.nextDouble(); 
		int b = (int)a;
		System.out.println("\""+ "실수변수값 = " +m +", 정수변수값 = " +b +"\"");
		
	}

}
