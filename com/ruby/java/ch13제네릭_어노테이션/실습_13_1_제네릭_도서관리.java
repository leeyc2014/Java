package com.ruby.java.ch13제네릭_어노테이션;

import java.util.ArrayList;
import java.util.Collections;

//Overflow 예외 클래스
class OverflowException extends RuntimeException { // 교재 553
	public OverflowException(String msg) {
		super(msg);
	}
}

//Underflow 예외 클래스
class UnderflowException extends RuntimeException {
	public UnderflowException(String msg) {
		super(msg);
	}
}

interface MediaBook {
	public String getTitle();
	public String getISBN();
}

//Book 클래스
class Book implements MediaBook, Comparable<Book> {
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;
	
	//생성자
	public Book(String title, String author, int publicationYear, String isbn) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}

	// Getter	
	public String getTitle() {
		return title;
	}

	public String getISBN() {
		return isbn;
	}

	@Override
	public int compareTo(Book o) {
		return this.title.compareTo(o.title);
	}

	@Override
	public String toString() {
		return "[제목 = " + title + ", 작가 = " + author + ", 출판연도 = " + publicationYear + ", isbn = " + isbn + "]";
	}
	
}

class Library<T extends MediaBook & Comparable<T>> {
	static final int CAPACITY = 5; // 기본 용량을 5로 설정
	private ArrayList<T> items = new ArrayList<>();
	
	// 책 추가 (용량 초과 시 OverflowException 발생)
	public void addBook(T book) {
		if(items.size() > CAPACITY) {
			throw new OverflowException("용량 초과");
		}
		items.add(book);
	}

	// 책 삭제 (빈 목록에서 삭제 시 UnderflowException 발생)
	public T removeBook() {
		if(items.size() == 0) {
			throw new UnderflowException("빈 목록");
		}return items.removeFirst();
	}

	public void printBooks(String msg) {
		System.out.println(msg);
		if(items.size() == 0) {
			System.out.println("저장된 책이 없습니다.");
		}else for(T book : items) {
			System.out.println(book);
		}
	}

	public void sortBooksByTitle() {
		Collections.sort(items);
	}

	public void sortBooksByISBN() {
		Collections.sort(items, (a1, b1) -> a1.getISBN().compareTo(b1.getISBN()));
	}

	public T searchBookByTitle(String title) {
		for (int i = 0; i < items.size(); i++) {
			if (title.equals(items.get(i).getTitle())) {
				return items.get(i);
			}
		}
		return null;
	}
}

public class 실습_13_1_제네릭_도서관리 {
	public static void main(String[] args) {
	
		Library<Book> library = new Library<>();

		// 5개의 Book 객체 초기화
		Book book1 = new Book("자바", "강감찬", 1995, "12");
		Book book2 = new Book("파이썬", "이순신", 2008, "9");
		Book book3 = new Book("C#", "을지문덕", 2008, "8");
		Book book4 = new Book("자료구조", "연개소문", 1994, "45");
		Book book5 = new Book("리액트", "김춘추", 1999, "7");
		Book book6 = new Book("스프링", "홍길동", 2025, "99");
		// 예외 처리를 적용한 책 추가 및 삭제
		try {
			library.addBook(book1);
			library.addBook(book2);
			library.addBook(book3);
			library.addBook(book4);
			library.addBook(book5);
			library.addBook(book6);

			// 도서관의 용량을 초과하여 책을 추가 (예외 발생)
			Book book7 = new Book("SQL", "이기자", 2024, "34");
			library.addBook(book7); // 이 부분에서 OverflowException 발생
		} catch (OverflowException e) {
			System.out.println(e.getMessage());// OverflowException 생성시 전달된 메시지 출력
		}
		
		// 도서 목록 출력
        library.printBooks("\n현재 도서 목록:");

        // **제목 기준 정렬 및 출력**
        System.out.println("\n=== 제목 기준 정렬 ===");
        library.sortBooksByTitle();
        library.printBooks("제목 정렬 후:");

        // **ISBN 기준 정렬 및 출력**
        System.out.println("\n=== ISBN 기준 정렬 ===");
        library.sortBooksByISBN();
        library.printBooks("ISBN 정렬 후:");

		try {
			// 책 삭제
			library.removeBook(); // 정상 삭제
			library.removeBook(); // 정상 삭제
			library.removeBook(); // 정상 삭제
			library.removeBook(); // 정상 삭제
			library.removeBook(); // 정상 삭제
			library.removeBook(); // 정상 삭제

			// 빈 도서관에서 책을 삭제 (예외 발생)
			library.removeBook(); // 이 부분에서 UnderflowException 발생
		} catch (UnderflowException e) {
			System.out.println(e.getMessage());
		}

		// 최종 도서 목록 출력
		library.printBooks("\n최종 도서 목록:");

	}
}