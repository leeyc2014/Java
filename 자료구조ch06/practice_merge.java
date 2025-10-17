package 자료구조ch06;

public class practice_merge {
	public static Term[] iMergeSort(Term[] terms) {
		if(terms == null || terms.length <= 1) {
			return terms;
		}
		int n = terms.length;
		Term[] temp = new Term[n];	//"공간을 사용함(시간 빠름)"
		
		// size = 1, n = 5
		for(int size = 1; size < n; size *= 2) {
			for(int left = 0; left < n; left += 2* size) {
				int mid = Math.min(left + size - 1, n - 1);
				int right = Math.min(left + 2 * size - 1, n - 1);
				merge(terms, temp, left, mid, right);
			}
		}		
		return terms;
	}
	
	private static void merge(Term[] terms, Term[] temp, int left, int mid, int right) {
		int i = left;	// 왼쪽 부분의 시작 인덱스
		int j = mid + 1;	// 오른쪽 부분의 시작 인덱스
		int k = left;	// 병합된 배열의 인덱스
		// 0, 0, 0
		while(i <= mid && j <= right) {
			
		}
	}
}
