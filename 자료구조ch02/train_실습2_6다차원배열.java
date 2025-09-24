package 자료구조ch02;

/*
 * 3번째 실습
 * 교재 83 - 배열 처리 + function parameter 전달 숙달 훈련 
 *  함수에서 배열을 리턴할 때 리턴 타입 정의할 수 있어야 한다
 */

import java.util.Arrays;
import java.util.Random;

class Data {
	private static int row;
	private static int col;
	
	public static void inputData(int[][] data) {
		int[][] arr = new int[row][col];
		Random rd = new Random();
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				arr[i][j] = rd.nextInt(0, 100);
			}
		}
	}
	
	public static void showData(String msg, int[][] data) {
		System.out.print(msg + "[");
		for(int i = 0; i < col; i++) {
			for(int j = 0; j < row; j++) {
				System.out.print(data[i][j]);
				if(i < data.length - 1) {
					System.out.print(",");
				}			
			}
		}
		System.out.println("]");
	}
	
	public static int[][] addMatrix(int[][] data1, int[][] data2) {
		int[][] sum = new int[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				sum[i][j] = data1[i][j] + data2[i][j];
			}
		}
		return sum;
	}
	
	public static int[][] multiplyMatrix(int[][] data1, int[][] data2) {
		int[][] mul = new int[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				mul[i][j] = data1[i][j] * data2[i][j];
			}
		}
		return mul;
	}
	
	public static int[][] transposeMatrix(int[][] data) {
		int[][] newData = new int[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				newData[i][j] = data[i][j];
			}
		}
		return newData;
	}
	
	public static int[][] multiplyMatrixTransposed(int[][] data1, int[][] data2) {
		int[][] transMul = new int [row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				transMul[j][i] = data1[i][j] * data2[i][j];
			}
		}
		return transMul;
	}
	
	public static boolean equals(int[][] data1, int[][] data2) {
		if(data1.length != data2.length) {
			return false;
		}
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(data1[i][j] == data2[i][j]) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return true;
	}
}

public class train_실습2_6다차원배열 extends Data{
	public static void main(String[] args) {
		int [][]A = new int[2][3];
		int [][]B = new int[3][4];
		int [][]C = new int[2][4];
		inputData(A);inputData(B);
		int [][]D = A.clone();//교재83 - 배열 복제
		System.out.println("A[2][3] = ");
		showData("행렬 A", A);
		System.out.println("D[2][3] = ");
		showData("행렬 D", D);
		System.out.println();
		System.out.println("B[3][4] = ");
		showData("행렬 B", B);
		int [][]E = addMatrix(A,D);
		System.out.println("E[2][3] = ");
		showData("행렬 E", E);
		C = multiplyMatrix(A,B);
		System.out.println("C[2][4] = ");
		showData("행렬 C", C);

		int [][]F = transposeMatrix(B);
		System.out.println("F[3][2] = ");
		showData("행렬 F", F);
		C= multiplyMatrixTransposed(A,F);
		showData("행렬 곱셈 결과-전치행렬 사용", C);
		boolean result = equals(A,C);
		if (result)
			System.out.println("행렬 A,C는 equal이다");
		else
			System.out.println("행렬 A,C는 equal 아니다");
	}
}

