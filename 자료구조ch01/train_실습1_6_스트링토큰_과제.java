package 자료구조ch01;

import java.util.Arrays;
import java.util.StringTokenizer;

public class train_실습1_6_스트링토큰_과제 {
/*
 * StringTokenizer(input), countTokens(), hasMoreTokens(), nextToken()
 * parseDouble(stringArray[i])
 */
  
	public static String[] extractSortStrings(String msg) {
		StringTokenizer st = new StringTokenizer(msg);
		int count = st.countTokens();
		String[] result = new String[count];
		for(int i = 0; i < count; i++) {
			result[i] = st.nextToken();
		}
		Arrays.sort(result);
		return result;
	}
	
	public static void printStringArray(String[] s) {
		for(int i = 0; i < s.length; i++) {
			System.out.print(s[i] + " ");
		}
		System.out.println();
	}
	
	public static double[] convertSortToDouble(String[] in) {
		double[] s = new double[in.length];
		for(int i = 0; i < in.length; i++) {
			s[i] = Double.parseDouble(in[i]);		
		}
		Arrays.sort(s);
		return s;
	}
	
	public static void printDoubleArray(double[] s) {
		for(int i = 0; i < s.length; i++) {
			System.out.print(s[i] + " ");
		}
	}
  
    public static void main(String[] args) {
        String msg = "3.24 3.34156 1141.56 214. 0.0314156 54.12f";
        
        // 실수를 문자열로 추출하고 정렬 후 출력
        String[] sortedStringArray = extractSortStrings(msg);
        System.out.println("정렬 스트링 배열:");
        printStringArray(sortedStringArray);
        
        // 문자열 배열을 실수 배열로 변환하고 정렬 후 출력
        double[] sortedDoubleArray = convertSortToDouble(sortedStringArray);
        System.out.println("정렬 실수 배열:");
        printDoubleArray(sortedDoubleArray);
    }
}
