package com.ruby.java.ch03제어문;

import java.util.Scanner;

/*
 * 구구단 출력
 * int dan = sc.nextInt()
 * for(;;) {
 *     //3x1 = 3
 *     //3x2 = 6 등으로 출력
 * }
 * 
 */
public class 실습_3장_5_for_구구단 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int dan = sc.nextInt();
	System.out.println(dan + "단:");
	for(int n = 1; n < 10; n++) {
		int a = dan*n;
		if(dan<10 && dan>1)
			System.out.println(dan + "x" + n + "=" + a);
		else
			break;
			}
}
}
