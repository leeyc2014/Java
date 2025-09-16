package com.ruby.java.ch11예외;
/*
public interface Comparable<T> {
    /**
     * 이 객체와 지정된 객체의 순서를 비교합니다.
     * 이 객체가 지정된 객체보다 작으면 음의 정수를,
     * 같으면 0을, 크면 양의 정수를 반환합니다.
     *
     * @param o 비교할 객체
     * @return 이 객체가 지정된 객체보다 작으면 음의 정수,
     * 같으면 0, 크면 양의 정수
     */
/*
    public int compareTo(T o);
}
 */
import java.util.ArrayList;
import java.util.Arrays;
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

//Book 클래스
class Book implements Comparable<Book> {
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;
	
	public Book() {
		
	}
	public Book(String title, String author, int publicationYear, String isbn) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}
		
	public String getTitle() {
		return title;
	}

	public String getIsbn() {
		return isbn;
	}

	@Override
	public String toString() {
		return String.format("도서명:\t%s\t저자:\t%s\t출판연도:\t%d\tISBN:\t%s", title, author, publicationYear, isbn);
	}
	
	public int compareTo(Book o) {
		return this.title.compareTo(o.title);
	}

}

class Library {
	static final int CAPACITY = 5; // 기본 용량을 5로 설정
	private ArrayList<Book> books;
	public Library() {
		books = new ArrayList<>();
	}

	// 책 추가 (용량 초과 시 OverflowException 발생)
	public void addBook(Book book) {
		if(books.size() > CAPACITY)	{
			throw new OverflowException("책 용량 초과");
		}
		books.add(book);
	}

	// 책 삭제 (빈 목록에서 삭제 시 UnderflowException 발생)
	public Book removeBook() {
		if(books.size() == 0) {
			throw new UnderflowException("빈 목록에서 삭제");
		}
		return books.removeFirst();
	}

	public void printBooks(String msg) {
		System.out.println(msg);	 
		if(books.size() == 0)	return ;
		else {	
			Object obj[] = books.toArray();
			for(int i = 0; i < obj.length; i++) {
				System.out.println(obj[i]);
			}
		}
	}

	public void sortBooksByTitle() {
		Collections.sort(books);
	}

	public void sortBooksByISBN() {
		Collections.sort(books, (b1, b2)->b1.getIsbn().compareTo(b2.getIsbn()));
	}

	public Book searchBookByTitle(String title) {
		Object obj[] = books.toArray();
		for(int i = 0; i < obj.length; i++) {
			if(((Book) obj[i]).getTitle().compareTo(title) == 0)	return ((Book) obj[i]); 
		}
		return null;
	}
}

public class 실습11_C3_예외처리_과제 {
	public static void main(String[] args) {
		try {
			String s = new String("java");
			System.out.println(s.length());
			//s = null;
			//System.out.println(s.length());
			int[] arr = new int[2];
			arr[2] = 10;
		} catch (ArrayIndexOutOfBoundsException e1) {// 교재534
			System.out.println("***배열 색인 예외 발생");
			System.out.println(e1.getMessage());
		} catch (NullPointerException e2) {
			System.out.println("***널 포인터 예외 발생");
			e2.printStackTrace();
		} catch (Exception e) {
			System.out.println("***예외 발생");
		} finally {
			System.out.println("***모든 것이 ok\n\n");// 교재 543
			// 할당된 자원을 자동으로 해제가 아니고 close(file)을 포함해야 한다
		}

		Library library = new Library();

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
			/*Book book7 = new Book("자바", "강감찬", 1995, "12");
			library.addBook(book7);*/
		} catch (OverflowException e) {
			System.out.println(e.getMessage());
		}

		// 도서 목록 출력
		library.printBooks("\n\n현재 도서 목록:");

		try {
			library.removeBook();
			library.removeBook();
			library.removeBook();
			library.removeBook();
			library.removeBook();
			library.removeBook();
			// 빈 도서관에서 책을 삭제 (예외 발생)
			//library.removeBook();
		} catch (UnderflowException e) {
			System.out.println(e.getMessage());
		}

		// 최종 도서 목록 출력
		library.printBooks("\n최종 도서 목록:");
	}
}