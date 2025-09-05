package com.ruby.java.ch03제어문;
import java.util.Scanner;
/*
 * 달의 일 수 계산
 * int month = sc.nextInt()
 * switch(month) { 
 *     case1:
 *     		break;
 *     case3:
 *         days=31;
 * }
 * 
 */
public class 실습_3장_3switch문_달일수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("연도입력 : ");
		int year = sc.nextInt();
		System.out.print("달 입력 : ");
		int month = sc.nextInt();
		int days = 0;
		switch(month) {
		case 1:
			days=31; break;
		case 2:
			days=28; break;
		case 3:
			days=31; break;
		case 4:
			days=30; break;
		case 5:
			days=31; break;
		case 6:
			days=30; break;
		case 7:
			days=31; break;
		case 8:
			days=31; break;
		case 9:
			days=30; break;
		case 10:
			days=31; break;
		case 11:
			days=30; break;
		case 12:
			days=31; break;
		default:
			System.out.println("없음"); break;		
		}
		if(year/4 == 0 && month == 2)
			days = 29;
		System.out.println("달일수 = " + days + "일");
	}
}
