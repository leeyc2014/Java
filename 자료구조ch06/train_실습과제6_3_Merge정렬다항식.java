package 자료구조ch06;
/*
 * 6장 구현과제3
 */

/*
 * 6장 구현과제 - 다항식 add, multiply
 */

class Term implements Comparable<Term> {
	double coef; // 계수
	int exp; // 지수

	Term() {
	}

	// --- 생성자(constructor) ---//
	Term(double coef, int exp) {
		this.coef = coef;
		this.exp = exp;
	}

	// --- 신체검사 데이터를 문자열로 반환 --//
	@Override
	public String toString() {
		return coef + "x**" + exp + " ";
	}

	@Override
	public int compareTo(Term d2) { // 지수가 같으면 계수로 비교
		if (this.exp != d2.exp) {
			return d2.exp - this.exp; // 내림차순
		}
		return Double.compare(d2.coef, this.coef);
	}
}

public class train_실습과제6_3_Merge정렬다항식 {
	// --- 배열 요소 p[idx1]와 p[idx2]의 값을 교환 ---//
	static void merge(Term[] p, int lefta, int righta, int leftb, int rightb) {
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
	static void MergeSort(Term[] p, int left, int right) {
		int mid = (left + right) / 2;
		if (left == right)
			return;
		MergeSort(p, left, mid);
		MergeSort(p, mid + 1, right);
		merge(p, left, mid, mid + 1, right);
		return;
	}

	static void ShowPolynomial(String msg, Term[] x, int count) {
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
			System.out.print(x[i].coef + "x**" + x[i].exp);
		}
		System.out.println();
		// 구현코드
	}

	static int AddPolynomial(Term[] p1, Term[] p2, Term[] result) {
		// result = p1 + p2, 다항식 덧셈 결과를 result로 주고 result의 항의 수 terms을 리턴한다
		int p = 0, q = 0, r = 0;
		int terms = 0;
		// 구현코드
		while (p < p1.length && q < p2.length) {
			if (p1[p].exp > p2[q].exp) {
				result[r++] = new Term(p1[p].coef, p1[p].exp);
				p++;
				terms++;
			} else if (p1[p].exp < p2[q].exp) {
				result[r++] = new Term(p2[q].coef, p2[q].exp);
				q++;
				terms++;
			} else {
				double sumCoef = p1[p].coef + p2[q].coef;
				if (sumCoef != 0) {
					result[r++] = new Term(sumCoef, p1[p].exp);
				}
				p++;
				q++;
				terms++;
			}
		}
		while (p < p1.length) {
			result[r++] = new Term(p1[p].coef, p1[p].exp);
			p++;
			terms++;
		}
		while (q < p2.length) {
			result[r++] = new Term(p2[q].coef, p2[q].exp);
			q++;
			terms++;
		}
		return terms;
	}

	static int addTerm(Term[] p, Term term, int currentTerms) {
		// 다항식 p에 새로운 항 term을 추가한다. 지수가 같은 항이 있으면 계수만 합한다
		// 추가된 항의 숫자를 리턴한다. 마지막 배열에 추가하므로 정렬이 되지 않는다.
		// 구현코드
		for (int i = 0; i < currentTerms; i++) {
			if (p[i].exp == term.exp) {
				p[i].coef += term.coef;
				return currentTerms;
			}
		}
		p[currentTerms] = term;
		return currentTerms + 1;
	}

	static int MultiplyPolynomial(Term[] p1, Term[] p2, Term[] result) {
		// result = p1 * p2, 다항식 result의 항의 수는 terms으로 리턴한다
		// terms = addTerm(result, term, terms);사용하여 곱셈항을 추가한다.
		int terms = 0;
		for (int i = 0; i < p1.length; i++) {
			for (int j = 0; j < p2.length; j++) {
				double coef = p1[i].coef * p2[j].coef;
				int exp = p1[i].exp + p2[j].exp;
				Term term = new Term(coef, exp);
				terms = addTerm(result, term, terms);
			}
		}
		return terms;
	}

	static double EvaluatePolynomial(Term[] p, int pTerms, double value) {
		// pTerms는 다항식 p의 항의 수, value는 f(x)를 계산하기 위한 x 값
		// 다항식 계산 결과를 double로 리턴한다
		double result = 0.0;
		// 구현 코드
		for (int i = 0; i < pTerms; i++) {
			result += p[i].coef * Math.pow(value, p[i].exp);
		}

		return result;
	}

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
