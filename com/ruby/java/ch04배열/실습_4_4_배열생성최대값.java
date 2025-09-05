package com.ruby.java.ch04배열;

import java.util.Random;

/*
 * 난수 배열의 최대, 최소, 평균 구하기
 * 0부터 100까지의 정수 난수 10개를 생성하여 배열에 저장
 * 배열에서 최대값, 최소값, 평균을 구하기
 *   >> for문을 사용한 최대값 찾기 - 교재 149 페이지의 배열 길이: length 사용
 * 출력 내용:
 *   배열 price는 확장형 for 문으로 출력, 출력 형태는 다음과 같다:
 *   [1,2,3,4,5]
 *   최대값 출력은 다음과 같다
 *   최대값 = **
 *   최소값, 평균값 출력은 최대값 출력과 같다.
 *   


 */
public class 실습_4_4_배열생성최대값 {
	public static void main(String[] args) {
		int price[] = new int[10];
		int max = price[0];
		int min = price[0];
		int sum = 0;
		double avg = 0.0;
		Random rd = new Random();
		for (int i = 1; i < price.length; i++) {
			price[i] = rd.nextInt(100);
			sum += price[i];
			if(price[i] > max)
				max = price[i];
			if(price[i] < min)
				min = price[i];
			avg = (double)sum/price.length;
		}for(int num1 : price){
			if(num1 == max)
				System.out.println("최대값 = " + num1);	
		}for(int num2 : price) {
			if(num2 == min)
				System.out.println("최소값 = " + num2);	
		}
		System.out.println("평균값 = " + avg);
		}
}