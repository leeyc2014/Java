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
		Random rd = new Random();
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[0].length; j++) {
				data[i][j] = rd.nextInt(0, 100);
			}
		}
	}
	
	public static void showData(String msg, int[][] data) {
		System.out.print(msg + "[");
        for (int i = 0; i < data.length; i++) {
            System.out.print("{");
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j]);
                if (j < data[i].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("}");
            if (i < data.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
	}
	
	public static int[][] addMatrix(int[][] data1, int[][] data2) {
		int[][] sum = new int[data1.length][data1[0].length];
		for(int i = 0; i < data1.length; i++) {
			for(int j = 0; j < data1[0].length; j++) {
				sum[i][j] = data1[i][j] + data2[i][j];
			}
		}
		return sum;
	}
	
	public static int[][] multiplyMatrix(int[][] data1, int[][] data2) {
		int[][] mul = new int[data1.length][data2[0].length];		
		for(int i = 0; i < data1.length; i++) {
			for(int j = 0; j < data2[0].length; j++) {
				for(int k = 0; k < data1[0].length; k++)
				mul[i][j] = data1[i][k] * data2[k][j];
			}
		}
		return mul;
	}
	
	public static int[][] transposeMatrix(int[][] data) {
		int[][] newData = new int[data[0].length][data.length];
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[0].length; j++) {
				newData[j][i] = data[i][j];
			}
		}
		return newData;
	}
	
	public static int[][] multiplyMatrixTransposed(int[][] data1, int[][] data2) {
		int[][] transMul = new int [data2[0].length][data1.length];
		for(int i = 0; i < data1.length; i++) {
			for(int j = 0; j < data2[0].length; j++) {
				for(int k = 0; k < data1[0].length; k++) {
					transMul[j][i] = data1[i][k] * data2[k][j];
				}				
			}
		}
		return transMul;
	}
	
	public static boolean equals(int[][] data1, int[][] data2) {
		if(data1.length != data2.length || data1[0].length != data2[0].length) {
			return false;
		}
		for(int i = 0; i < data1.length; i++) {
			for(int j = 0; j < data1[0].length; j++) {
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

