package 자료구조ch06;

/*
 * 6장 구현 실습과제2
 */

class PhyscData implements Comparable<PhyscData>{
    String name;              // 이름
    int    height;            // 키
    double vision;            // 시력
      
	public PhyscData(String name, int height, double vision) {
		super();
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override
	public int compareTo(PhyscData o) {
		return name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return "PhyscData [name=" + name + ", height=" + height + ", vision=" + vision + "]";
	}
}

public class train_실습과제6_2_객체merge정렬 {
	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(PhyscData[] a, int lefta, int righta, int leftb, int rightb) {
		int n = a.length;
		PhyscData[] b = new PhyscData[n];
		int p = lefta;
		int q = leftb;
		int ix = 0;
		// 정렬 코드
		while(p <= righta && q <= rightb) {
			if(a[p].compareTo(a[q]) < 0) {
				b[ix++] = a[p++];
			}
			else if(a[p].compareTo(a[q]) > 0) {
				b[ix++] = a[q++];
			}
			else {
				b[ix++] = a[p++];
				b[ix++] = a[q++];
			}
		}
		while(p > righta && q <= rightb) {
			b[ix++] = a[q++];
		}
		while(p <= righta && q > rightb) {
			b[ix++] = a[q++];
		}
		System.out.println();
		for (int i = 0; i < ix; i++) {
			// 배열  temp을 배열 a에 복사
			a[lefta + i] = b[i];
		}
		/*for(int i = lefta, k = 0; i <= rightb; i++, k++) {
			a[i] = b[k];
		}*/
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(PhyscData[] a, int left, int right) {
		int mid = (left+right)/2;
		if (left == right) return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right);
		return;
	}

	public static void main(String[] args) {
		PhyscData[] x = {
		         new PhyscData("강민하", 162, 0.3),
		         new PhyscData("김찬우", 173, 0.7),
		         new PhyscData("박준서", 171, 2.0),
		         new PhyscData("유서범", 171, 1.5),
		         new PhyscData("이수연", 168, 0.4),
		         new PhyscData("장경오", 171, 1.2),
		         new PhyscData("황지안", 169, 0.8),
		     };
		int nx = x.length;

		   MergeSort(x, 0, nx - 1); // 배열 x를 퀵정렬
			System.out.println("오름차순으로 정렬했습니다.");
		     System.out.println("■ 신체검사 리스트 ■");
		     System.out.println("이름       키   시력");
		     System.out.println("------------------");
		     for (int i = 0; i < x.length; i++)
		         System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
	}
}
