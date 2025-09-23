package 자료구조ch02;
/*
 * 2장 - 정수 배열 정렬
 */

import java.util.Arrays;
//교재 67 - 실습 2-5
//2번 실습
import java.util.Random;
public class train_실습2_5정수배열정렬 {
	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data); //난수를 10 ~ 60 사이에 생성
		showData("난수 입력", data);
		/*
		sortData(data);
		showData("정렬후", data);
		*/
		reverse(data);//역순으로 재배치 - 정렬 아님 
		showData("역순 재배치", data);

		reverseSort(data);//역순으로 재배치 - 정렬 아님 
		showData("역순 정렬후", data);
		sortData(data);
		int realData[] = {5, 15, 99};
		for (int newData: realData) {
			int []result = insertData(data, newData);//입력 실수보다 큰 숫자를 우측으로 이동
			System.out.print("\n\n"+ newData+ " : ");
			showData("실수 삽입후", result);
		}
	}
	
	/*
	 * 난이도가 매우 높은 알고리즘 구현
	 * 정렬된 기존 배열에 임의 값을 추가하는 알고리즘 > 새 배열의 크기는 기존 배열보다 +1로 만들고 기존 배열을 copy할 때
	 * 삽입된 값이 중간에 들어가는 알고리즘 구현하기
	 * O(n) 알고리즘으로 구현 
	 */
	private static int[] insertData(int []data, int value) {//insert되는 실수 값이 insert될 위치를 찾아 보다 큰 값은 우측으로 이동
		int newData[] = new int[data.length + 1];
		int newIndex = newData.length / 2; 
		int t = 0;
		for(int i = 0; i < newData.length; i++) {
			if(i == newIndex) {
				newData[i] = value;
			}
			else {
				newData[i] = data[t++];
			}
		}
		return newData;
	}
	
	private static void inputData(int[] data) {
		Random rd = new Random();
		for(int i = 0; i < data.length; i++) {
			data[i] = rd.nextInt((51) + 10);
		}
	}
	
	private static void showData(String msg, int[] data) {
		System.out.print(msg + "[");
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			if(i < data.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}
	
	private static void reverse(int[] data) {
		for(int i = 0; i < data.length / 2; i++) {
			int num = data[i];
			data[i] = data[data.length - i - 1];
			data[data.length - i - 1] = num;
		}
	}

	private static void sortData(int[] data) {
		Arrays.sort(data);
	}
	
	private static void reverseSort(int[] data) {
		Arrays.sort(data);
		for(int i = 0; i < data.length / 2; i++) {
			int num = data[i];
			data[i] = data[data.length - i - 1];
			data[data.length - i - 1] = num;
		}
	}
}
