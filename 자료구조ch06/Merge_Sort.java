package 자료구조ch06;

public class Merge_Sort {
	public static void merge(Term[] p, int lefta, int righta, int leftb, int rightb) {
		// body를 지우고 작성 훈련 연습이 도움이 된다
		Term temp[] = new Term[30];
		// 구현코드
		int i = lefta;
		int j = leftb;
		int k = 0;

		while (i <= righta && j <= rightb) {
			if (p[i].compareTo(p[j]) < 0) {
				temp[k++] = p[i++];
			} else if (p[i].compareTo(p[j]) > 0) {
				temp[k++] = p[j++];
			} else {
				temp[k++] = p[i++];
				temp[k++] = p[j++];
			}
		}
		while (i <= righta) {
			temp[k++] = p[i++];
		}
		while (j <= rightb) {
			temp[k++] = p[j++];
		}

		for (int a = 0; a < k; a++) {
			p[lefta + a] = temp[a];
		}
	}

	// --- 퀵 정렬(비재귀 버전)---//
	public static void MergeSort(Term[] p, int left, int right) {
		int mid = (left + right) / 2;
		if (left == right)
			return;
		MergeSort(p, left, mid);
		MergeSort(p, mid + 1, right);
		merge(p, left, mid, mid + 1, right);
		return;
	}

	public static void ShowPolynomial(String msg, Term[] x, int count) {
		// str 변수는 다항식 이름으로 스트링이다
		// count가 -1이면 다항식 x의 length로 계산하고 -1이면 count가 다항식 항의 숫자이다
		// 정렬후 다항식 x = 2.5x**7 + 3.8x**5 + 3.1x**4 + 1.5x**3 + 3.3x**2 + 4.0x**1 +
		// 2.2x**0
		System.out.println("\n" + msg + " : ");
		int length = (count == -1) ? x.length : count;
		for (int i = 0; i < length; i++) {
			if (i > 0 && x[i].coef > 0) {
				System.out.print(" + ");
			} else if (x[i].coef < 0) {
				System.out.print(" ");
			}
			//System.out.print(x[i].coef + "x**" + x[i].exp);
			System.out.printf("%.2fx^%d", x[i].coef, x[i].exp);
		}
		System.out.println();
		// 구현코드
	}
}
