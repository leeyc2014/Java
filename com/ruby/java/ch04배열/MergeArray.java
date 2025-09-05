package com.ruby.java.ch04배열;
import java.util.Random;

public class MergeArray {	
	public static void main(String[] args) {
		// 랜덤 입력 변수 설정
		// 배열 A[5], B[5], C[10] 선언
		// 랜덤으로 값 입력
		// 합치기
		Random rd = new Random();
		int [] A = new int [5];
		int [] B = new int [5];
		int [] C = new int [10];
		int [] D = new int [10];
		for(int i = 0; i < A.length; i++) {
			A[i] = rd.nextInt(100);
		}
		for(int i = 0; i < B.length; i++) {
			B[i] = rd.nextInt(100);
		}
		for(int i = 0; i < A.length; i++) {
			C[i] = A[i];
		}
		for(int i = 0; i < B.length; i++) {
			C[i+A.length] = B[i];
		}
		for(int i = 0; i < A.length; i++) {
			D[i*2] = A[i];
		}
		for(int i = 0; i < B.length; i++) {
			D[i*2+1] = B[i];
		}
		System.out.print("A = {");
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		int cnt4 = 0;
		for(int arr : A) {
			System.out.print(arr);
			if (++cnt1 < A.length)
				System.out.print(",");
		}System.out.print("} \n");
		System.out.print("B = {");
		for(int arr : B) {
			System.out.print(arr);
			if (++cnt2 < B.length)
				System.out.print(",");
		}
		System.out.print("} \n");
		System.out.print("C = {");
		for(int arr : C) {
			System.out.print(arr);
			if (++cnt3 < C.length)
				System.out.print(",");
		}System.out.print("} \n");
		System.out.print("D = {");
		for(int arr : D) {
			System.out.print(arr);
			if (++cnt4 < D.length)
				System.out.print(",");
		}System.out.print("} \n");
	}
	
}