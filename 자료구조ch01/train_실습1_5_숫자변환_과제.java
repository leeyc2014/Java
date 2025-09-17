package 자료구조ch01;

import java.util.Arrays;

public class train_실습1_5_숫자변환_과제 {
/*
 * split(" ")
 * parseInt(stringArray[i])
 */
	public static String[] splitSortString(String in) {
		String[] s = in.split(" ");
		Arrays.sort(s);
		return s;
	}
	
	public static void printStringArray(String[] s) {
		for(String st : s) {
			System.out.print(st + " ");
		}
		System.out.println();
	}
	
	public static int[] convertSortToIntArray(String[] in) {
		int[] s = new int[in.length];
		for(int i = 0; i < in.length; i++) {
			s[i] = Integer.parseInt(in[i]);		
		}
		Arrays.sort(s);
		return s;
	}
	
	public static void printIntArray(int[] s) {
		for(int st : s) {
			System.out.print(st + " ");
		}
	}
	
    public static void main(String[] args) {
        String input = "12 111 911 921 94 23 214 222";
        
        // 문자열 배열 정렬 및 출력
        String[] sortedStringArray = splitSortString(input);
        System.out.println("Sorted String Array:");
        printStringArray(sortedStringArray);
        
        // 문자열 배열을 정수 배열로 변환 및 정렬 후 출력
        int[] sortedIntArray = convertSortToIntArray(sortedStringArray);
        System.out.println("Sorted Integer Array:");
        printIntArray(sortedIntArray);
    }
}
