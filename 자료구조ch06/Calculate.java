package 자료구조ch06;

public class Calculate {
	public static int AddPolynomial(Term[] p1, Term[] p2, Term[] result) {
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

	public static int addTerm(Term[] p, Term term, int currentTerms) {
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

	public static int MultiplyPolynomial(Term[] p1, Term[] p2, Term[] result) {
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

	public static double EvaluatePolynomial(Term[] p, int pTerms, double value) {
		// pTerms는 다항식 p의 항의 수, value는 f(x)를 계산하기 위한 x 값
		// 다항식 계산 결과를 double로 리턴한다
		double result = 0.0;
		// 구현 코드
		for (int i = 0; i < pTerms; i++) {
			result += p[i].coef * Math.pow(value, p[i].exp);
		}

		return result;
	}

}
