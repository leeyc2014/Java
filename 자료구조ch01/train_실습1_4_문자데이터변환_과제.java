package 자료구조ch01;

import java.util.Arrays;

public class train_실습1_4_문자데이터변환_과제 {
	/*
	 * valueOf(boolVal) Arrays.sort(array)
	 */

	// 값을 문자열로 변환하여 배열에 저장하는 함수
	public static String[] convertValuesToString(boolean boolVal, char charVal, double doubleVal, int intVal, float floatVal) {
    	String[] s = new String[5];
		s[0] = String.valueOf(boolVal);
    	s[1] = String.valueOf(charVal);
    	s[2] = String.valueOf(doubleVal);
    	s[3] = String.valueOf(intVal);
    	s[4] = String.valueOf(floatVal);
    	return s;
    }
	
	// 배열을 정렬하는 함수
	public static void sortStringArray(String[] array) {
		Arrays.sort(array);
	}

	// 배열을 출력하는 함수
	public static void showAllString(String[] array) {
		for(String s : array) {
			System.out.print(s + "  ");
		}
	}

	public static void main(String[] args) {
		// 정수, float, double, boolean 값을 문자열로 변환하여 배열에 저장
		String[] stringArray = convertValuesToString(true, 'A', 3.14, 123, 45.67f);

		// 정렬 전 배열 출력
		System.out.println("정렬전:");
		showAllString(stringArray);

		// 배열 정렬
		sortStringArray(stringArray);

		// 정렬 후 배열 출력
		System.out.println("\n정렬후:");
		showAllString(stringArray);
	}
}
