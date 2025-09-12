package com.ruby.java.ch08다형성.innerClass;
/*
 * 외부 클래스 구현 
 */
class Node3 {
	int data;
	Node3 link;
	public Node3(int data) {
		this.data = data; link = null;
	}
}
class LinkedList3 {
	Node3 first;
	void append(int data) { // 값에 상관없이 뒤에 갖다 붙힘
		Node3 p = first, q = null;			
	}
	void showList() {
		System.out.println();
		Node3 p = first;
	}
	void insert(int data) { // 올림차순으로 정렬
		Node3 newNode = new Node3(data);
		Node3 p = first, q = null;
	}
}

public class 실습과제_ch08_연결리스트와배열 {
	static int getList(int[]data) {
		int count = 0;
		int mid = data.length/2;
		for (int i = 0; i <= mid; i++) {
			data[i] = i * 5; count++;
		}
		return count;
	}
	static void showList(int[]data) {
		System.out.println();
		for (int i=0; i < data.length; i++)
			System.out.print(" " + i + " ");
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			if (data[i] < 10)
				System.out.print(" ");
			System.out.print(data[i]+ " ");
		}
	}
	static int insertList(int[] data, int count, int x) {
		int indx = 0;
		return indx;

	}
	public static void main(String[] args) {
		int[]list = new int[10];
		int count = 0;
		System.out.println("배열로 리스트::");
		count = getList(list);
		showList(list);
		count = insertList(list, count, 3);
		showList(list);
		count = insertList(list, count, 7);
		showList(list);
	
		LinkedList3 ll = new LinkedList3();
		ll.append(45);
		ll.append(10);
		ll.append(115);
		ll.append(20);
		ll.append(25);
		
		LinkedList3 ll2 = new LinkedList3();
		ll2.showList();
		ll2.insert(3);
		ll2.showList();
		ll2.insert(7);
		ll2.showList();
	}
}
