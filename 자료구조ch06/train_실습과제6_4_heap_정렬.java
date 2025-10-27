package 자료구조ch06;
//heap의 full, empty에 대한 예외처리 구현 권장 
import java.util.Random;
import java.util.Scanner;

interface MaxHeap {
	public void insert(int x);
	public int deleteMax();
}

class Heap implements MaxHeap {
	final int heapSize = 100;
	private int[] heap;
	private int n; // MaxHeap의 현재 입력된 element 개수
	private int maxSize; // Maximum allowable size of MaxHeap
	
	public Heap(int sz) {
		maxSize = sz;
		n = 0;
		heap = new int[maxSize + 1];
	}

	public void display() {//heap 배열을 출력한다. 배열 인덱스와 heap[]의 값을 출력한다.
		int i;
		System.out.println("힙 배열 상태: ");
		for(i = 1; i <= n; i++) {
			System.out.print("[" + i + "]: " + heap[i] + " ");
		}
		System.out.println();
	}
	@Override
	public void insert(int x) {//max heap이 되도록 insert한다. 삽입후 complete binary tree가 유지되어야 한다.
		int i;
		if (n == maxSize) {
			heapFull();
			return;
		}
		n++;
		// 새 원소를 마지막 위치에 추가 후 위로 올라가면서 정렬
		for(i = n; i > 1;) {
			int parent = i / 2;		// 부모 노드 인덱스
			if(x <= heap[parent]) {	// 부모가 더 크거나 같으면 "종료"
				break;
			}
			heap[i] = heap[parent];
			i = parent;
		}
		heap[i] = x;

	}
	@Override
	public int deleteMax() {//heap에서 가장 큰 값을 삭제하여 리턴한다. 
		int x;
		int i, j;
		if (n == 0) {
			heapEmpty();
			int elm = 0;
			return elm;
		}
		
		x = heap[1];
		int temp = heap[n];		// 마지막 원소를 임시 저장
		n--;
		
		// 마지막 원소를 적절한 위치로 내려보냄(top-down)
		i = 1;	// (i = 1) => 루트 
		j = 2;	// (j = 2) => 왼쪽
		
		while(j <= n) {
			// 오른쪽이 존재하고 더 크면 오른쪽 선택
			if(j < n && heap[j] < heap[j + 1]) {
				j++;
			}
			// 마지막 원소가 자식보다 크거나 같으면 종료
			if(temp >= heap[j]) {
				break;
			}
			heap[i] = heap[j];
			i = j;
			j = 2 * i;
			// 자식을 위로 올림
		}
		heap[i] = temp;
		return x;
	}

	private void heapEmpty() {
		System.out.println("Heap Empty");
	}

	private void heapFull() {
		System.out.println("Heap Full");
	}
}
public class train_실습과제6_4_heap_정렬 {
	 static void showData(int[] d) {
		 for(int i = 1; i < d.length; i++) {
			 System.out.print(d[i] + " ");
		 }
		 System.out.println();
	 }
	public static void main(String[] args) {
		Random rnd = new Random(42);
		//int select = 0;
		//Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
	    final int count = 10;//난수 생성 갯수
	    int[] x = new int[count + 1];//x[0]은 사용하지 않으므로 11개 정수 배열을 생성한다 
	    int [] sorted = new int[count];//heap을 사용하여 정렬한다
	    System.out.println("1: 난수 생성 및 힙 삽입");
	    for(int i = 1; i <= count; i++) {
	    	x[i] = rnd.nextInt(100);
	    }
	    showData(x);
	    for(int i = 1; i <= count; i++) {
	    	heap.insert(x[i]);
	    	System.out.println(x[i] + " 삽입");
	    }
	    System.out.println("힙에 추가 완료");
	  
	    System.out.println("2: 힙 상태 출력");
	    heap.display();
	    
	    System.out.println("3: 힙 정렬");
	    System.out.println("deleteMax를 반복 호출하여 정렬");
	    for(int i = 0; i < count; i++) {
	    	sorted[i] = heap.deleteMax();
	    	System.out.println(" 삭제된 최대값: " + sorted[i]);
	    }
	    
	    System.out.println("4: 확인");
	    for(int i = 0; i < count; i++) {
	    	System.out.print(sorted[i] + " ");
	    }
	    System.out.println();
	    System.out.println("종료");

		/*do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1://난수를 생성하여 배열 x에 넣는다 > heap에 insert한다.

			     showData(x);
				break;
			case 2:	//heap 트리구조를 배열 인덱스를 사용하여 출력한다.
				heap.display();
				break;
			case 3://heap에서 delete를 사용하여 삭제된 값을 배열 sorted에 넣는다 > 배열 sorted[]를 출력하면 정렬 결과를 얻는다 
	
				break;

			case 4:
				return;

			}
		} while (select < 5);*/

		return;
	}
}

