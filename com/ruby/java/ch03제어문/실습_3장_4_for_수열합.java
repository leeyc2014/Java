package com.ruby.java.ch03제어문;
/*
 * 1~100 수열의 합 구하는 for 문 작성
 * int sum = 0;
 * for (;;) {
 *   sum += i;
 * }
 * sysout("sum = " + sum);
 */
public class 실습_3장_4_for_수열합 {
	public static void main(String[] args) {		
	int n = 0;
	for (int i =0; i <args.length; i++) {
		if (n < 10)
			continue;
		n += 1*2;
		if (n > 20)
			break;
	}
	do {
		System.out.println("sum =" +n);
	} while(n < 10);
	}
}
