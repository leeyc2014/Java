package com.ruby.java.ch03제어문;

import java.util.Scanner;

/*
 * 출력 형태를 다음과 같이 만들기 실습
 * 실습1:
 * $$$$$
 * $$$$
 * $$$
 * $$
 * $
 * 
 * 실습2: 정삼각형 형태로 출력하기
 * $$$$$
 *  $$$
 *   $
 */
public class 실습_3장_9_forfor문 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	for(; n > 0; n--) {
		System.out.print("\n");
		for(int m = n; m >0 ; m--)
			System.out.print("$");
//		for(int m = n; m > 0; m--)
//			System.out.print("$");  //실습 1

	}
}
}
