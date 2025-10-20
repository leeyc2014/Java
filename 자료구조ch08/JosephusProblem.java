package 자료구조ch08;

// 문제1) 조세푸스 문제(Josephus Problem)

/*고전적인 수학 퍼즐로, 원형으로 앉아 있는 사람들 중에서 특정 규칙에 따라 사람들을 제거하면서 마지막으로 남는 사람을 찾는 문제이다. 
 이 문제는 다음과 같은 이야기에서 유래되었다.
1.	문제 배경:
고대 유대의 역사가 요세푸스(Josephus)와 그의 동료들이 로마군에게 포위당한 상황에서 자살을 결심하게 된다. 
그들은 자살할 순서를 정하기 위해 원을 만들고, 특정 간격마다 사람을 제거하는 방식으로 마지막 사람을 남기는 방법을 선택한다.   
요세푸스는 이 방법을 통해 마지막에 살아남을 위치를 계산해 자신은 자살을 피했다.

문제 설명:
N명의 사람이 원형으로 앉아 있다.
K번째 사람을 반복적으로 제거한다.
이 과정을 N-1명이 제거될 때까지 반복한다. 3번째가 제거 대상이면 2명(A> B)이면 A가 자살 대상이다
마지막으로 남는 사람의 위치를 구하는 문제이다.

입력:
N: 사람의 수(각 사람의 id는 정수 난수로 생성- 생성 순서로 원형 singly linked list에 id의 올림차순으로 정렬되게 삽입)
K: 제거할 사람의 순서

출력:
1.	올림차순으로 정렬된 사람 id 순서를 출력
2.	제거되는 k 번째 id 순서대로 출력
3.	마지막으로 남는 사람의 id를 출력


순환하는 Queue[LinkedList] => "원형 LinkedList"

1. LinkedList
2. (%, mod)연산
3. 재귀


Stack / Queue / LinkedList

입력 : push(item) / enqueue(item) / {add(item), insert(index, item)}
삭제 : pop() / dequeue() / {remove(item), remove(First, Last)(), delete(index, item)}
조회 : {peek(), (top, peek())} / front() / get(item)
검색 : - / - / search(item)
크기 : size() / size() / size()
상태 : isEmpty() / isEmpty() / isEmpty()
*/

import java.util.Random;

class Node {
	int id;
	Node next;
	
	Node(int id) {
		this.id = id;
	}
}

class singlyLinkedList {
	Node head;
	public void insertSorted(int id) {
		// head -> 3 -> 5 -> 8
		// insertSorted(2)
		// head -> 2 -> 3 -> 5 -> 8 -> null
		// insertSorted(4)
		// head -> 3 -> 4 -> 5 -> 8 -> null
		//
		// 1) head == null
		// 2) 새 head가 기존의 head 앞에 위치
		// 3) 기존 head 뒤 어딘가에 위치
		//
		Node newNode = new Node(id);
	}
	public void showList() {
		Node current = head;
		System.out.print("{");
		while(current != null) {
			System.out.print(current.id);
			if(current.next != null) {
				System.out.print(", ");
			}
			current = current.next;
		}
		System.out.print("}");
		System.out.println();
	}
}
public class JosephusProblem {
	public static void main() {
		// 출력 : (7, 3)
		System.out.print("Josephus (7, 3)");
		// index / item (N개가 LinkedList(단방향)에 저장, K를 선택)
		int n = 7;
		int k = 3;
		
		Random rd = new Random(42);
		singlyLinkedList sll = new singlyLinkedList();
		for(int i = 0; i < n; i++) {
			// id를 정렬해서 추가
			int id = rd.nextInt(1000) + 1;
			sll.insertSorted(id);
		}
		sll.showList();
		// 제거 순서를 출력
		/*item solve(K, N) {
			
		}*/
	}
}

