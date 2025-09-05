package com.ruby.java.ch02데이터타입;
import java.util.Scanner;
public class MinBillcount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //정수일 때
		int FifTho = n/50000;
		int TenTho = (n%50000)/10000;
		int FiveTho = ((n%50000)%10000)/5000;
		int Tho = (((n%50000)%10000)%5000)/1000;
		System.out.println("5만원 = " +FifTho +"장" + "\n1만원 = " +TenTho +"장" + "\n5천원 = " + FiveTho +"장" + "\n1천원 = " + Tho +"장");
		
	}

}
