package 자료구조ch06;

public class Term implements Comparable<Term> {
	double coef; // 계수
	int exp; // 지수

	Term() {
	}

	// --- 생성자(constructor) ---//
	public Term(double coef, int exp) {
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

