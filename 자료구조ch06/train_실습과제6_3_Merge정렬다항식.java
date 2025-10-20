package 자료구조ch06;

import static 자료구조ch06.Calculate.*;
import static 자료구조ch06.Merge_Sort.*;
/*
 * 6장 구현과제 - 다항식 add, multiply
 */
public class train_실습과제6_3_Merge정렬다항식 {
	// --- 배열 요소 p[idx1]와 p[idx2]의 값을 교환 ---//
	public static void main(String[] args) {
		Term[] p1 = { new Term(1.5, 3), new Term(2.5, 7), new Term(3.3, 2), new Term(4.0, 1), new Term(2.2, 0),
				new Term(3.1, 4), new Term(3.8, 5), };
		Term[] p2 = { new Term(1.5, 1), new Term(2.5, 2), new Term(3.3, 3), new Term(4.0, 0), new Term(2.2, 4),
				new Term(3.1, 5), new Term(3.8, 6), };
		int nx = p1.length;

		ShowPolynomial("다항식 p1 = ", p1, -1);
		ShowPolynomial("다항식 p2 = ", p2, -1);
		MergeSort(p1, 0, p1.length - 1); // 배열 p1를 퀵정렬
		MergeSort(p2, 0, p2.length - 1); // 배열 p1를 퀵정렬
		ShowPolynomial("정렬후 다항식 p1 = ", p1, -1);
		ShowPolynomial("정렬후 다항식 p2 = ", p2, -1);

		Term[] result = new Term[50];

		for (int i = 0; i < result.length; i++) {
			result[i] = new Term();
		}

		int resultTerms = AddPolynomial(p1, p2, result);// 다항식 덧셈 result = p1 + p2
		ShowPolynomial("덧셈후 다항식 result = ", result, resultTerms);

		Term[] result2 = new Term[30];

		resultTerms = MultiplyPolynomial(p1, p2, result2);// 다항식 곱셈 result = p1 * p2
		MergeSort(result2, 0, resultTerms - 1); // 배열 p1를 퀵정렬
		ShowPolynomial("곱셈후 다항식 result = ", result2, resultTerms);

		double resultValue = EvaluatePolynomial(result2, resultTerms, 1.5);// 다항식 값 계산 함수 z(10) 값 계산한다
		System.out.println("\n result = " + resultValue);
	}
}
