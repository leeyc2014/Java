package com.ruby.java.ch04배열;

/*
 * 배열 사용없이 변수 5개를 사용하여 5명 점수의 평균 구하기
 * int score1,score2,score3, score4, score5;
 */
public class 실습_4_1_변수들사용 {
	public static void main(String[] args) {
		int score1 = 49;
		int score2 = 91;
		int score3 = 87;
		int score4 = 67;
		int score5 = 73;
		int max = 0;
		int min = 999;
		double avg = 0.0;
		if (score1 > max && score1 > score2 && score1 > score3 && score1 > score4 && score1 > score5)
			max = score1;
		else if (score2 > max && score2 > score1 && score2 > score3 && score2 > score4 && score2 > score5)
			max = score2;
		else if (score3 > max && score3 > score1 && score3 > score2 && score3 > score4 && score3 > score5)
			max = score3;
		else if (score4 > max && score4 > score1 && score4 > score2 && score4 > score3 && score4 > score5)
			max = score4;
		else if (score5 > max && score5 > score1 && score5 > score2 && score5 > score3 && score5 > score4)
			max = score5;
		
		if (score1 < min && score1 < score2 && score1 < score3 && score1 < score4 && score1 < score5)
			min = score1;
		else if (score2 < max && score2 < score1 && score2 < score3 && score2 < score4 && score2 < score5)
			min = score2;
		else if (score3 < max && score3 < score1 && score3 < score2 && score3 < score4 && score3 < score5)
			min = score3;
		else if (score4 < max && score4 < score1 && score4 < score2 && score4 < score3 && score4 < score5)
			min = score4;
		else if (score5 < max && score5 < score1 && score5 < score2 && score5 < score3 && score5 < score4)
			min = score5;
		avg = (double) (score1 + score2 + score3 + score4 + score5) / 5;
		System.out.println("최대 점수 : " + max);
		System.out.println("최소 점수 : " + min);
		System.out.println("평균 점수 : " + avg);
	}
	// 5명 점수를 score1 등의 변수로 초기화: 49, 91, 87, 67, 73
	// 최대 점수, 최소 점수, 평균 점수 계산하는 코드 구현
}
