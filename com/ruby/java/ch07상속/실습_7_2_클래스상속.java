package com.ruby.java.ch07상속;

//Item 클래스
class Item2 {
	private String name;
	private double price;
	private int stockQuantity;

	// 생성자
	
	
	// Getter
	
	
	public void reduceStock(int quantity) {
	
	}

	public void increaseStock(int quantity) {

	}
	
	@Override
	public String toString() {
		return null;
	}
}

//Electronics 클래스 (Item 클래스를 상속)
class Electronics extends Item2 {
	private int warranty; // 제품 보증 기간

	// 생성자
	
	@Override
	public String toString() {
		return null;
	}
}

//Clothing 클래스 (Item 클래스를 상속)
class Clothing extends Item2 {
	private String size;
	private String color;

	// 생성자
	
	
	@Override
	public String toString() {
		return null;
	}
}

//Customer 추상 클래스 정의
abstract class Customer2 {
	private String cname;
	private String city;
	private int age;

	// 생성자
	
	
	@Override
	public String toString() {
		return null;
	}

	abstract double getDiscountRate();
	abstract double applyDiscount(double totalAmount);
}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer extends Customer2 {
	static final double REGULARDISCOUNT_RATE = 0.03;

	public RegularCustomer(String name, String city, int age) {

	}

	@Override
	double applyDiscount(double totalAmount) {
		// 일반 고객 할인 적용
		return 0.0;
	}

	@Override
	double getDiscountRate() {
		return 0.0;
	}
}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer extends Customer2 {
	static final double PREMIUMDISCOUNT_RATE = 0.1;

	@Override
	double applyDiscount(double totalAmount) {
		return 0.0;
	}
	
	@Override
	double getDiscountRate() {
		return 0.0;
	}
}

//Order 클래스
class Order2 {
	private Customer2 customer;
	private Item2[] items;
	private int[] quantities;
	private int itemCount;

	// 생성자
	
	
	public void addItem(Item2 item, int quantity) {

	}

	private double calculateTotal() {
		return 0.0;
	}

	private double calculateDiscountedTotal() {
		return 0.0;
	}

	public void printOrderSummary() {
		/*
		 * 할인된 가격의 합계 출력 할인 금액 합계 출력
		 */
	}
}

public class 실습_7_2_클래스상속 {

	public static void main(String[] args) {
/*
		// 의류 및 전자제품 생성
		Item2 laptop = new Electronics("노트북", 1200.00, 10, 24);
		Electronics phone = new Electronics("휴대폰", 800.00, 30, 12);
		Clothing tshirt = new Clothing("티셔츠", 20.00, 50, "M", "Blue");
		Clothing jacket = new Clothing("자켓", 80.00, 20, "L", "Black");

		// 고객 생성
		PremiumCustomer premiumCustomer = new PremiumCustomer("홍길동", "부산", 30);
		RegularCustomer regularCustomer = new RegularCustomer("계백", "양산", 25);

		// 주문 생성
		Order2 order1 = new Order2(premiumCustomer, 4);
		order1.addItem(laptop, 1);
		order1.addItem(tshirt, 2);

		Order2 order2 = new Order2(regularCustomer, 4);
		order2.addItem(phone, 1);
		order2.addItem(jacket, 1);

		// 주문 요약 출력
		System.out.println("Premium Customer Order:");
		order1.printOrderSummary();

		System.out.println("Regular Customer Order:");
		order2.printOrderSummary();
 */
		/*
		 * 출력 결과 예시
		 * 
		Premium Customer Order:
		고객정보 : 고객명:홍길동, 도시:부산, 나이:30
		제품명 : 노트북, 단가 : 1200.0, 개수 : 1 ==> 가격 : 1200.0
		제품명 : 티셔츠, 단가 : 20.0, 개수 : 2 ==> 가격 : 40.0
		총액:1240.0, 할인율:0.1, 할인금액:-124.0
		할인 후 총액:1116.0
		-------------------------------------------------------
		Regular Customer Order:
		고객정보 : 고객명:계백, 도시:양산, 나이:25
		제품명 : 휴대폰, 단가 : 800.0, 개수 : 1 ==> 가격 : 800.0
		제품명 : 자켓, 단가 : 80.0, 개수 : 1 ==> 가격 : 80.0
		총액:880.0, 할인율:0.03, 할인금액:-26.399999999999977
		할인 후 총액:853.6
		-------------------------------------------------------
		*/
	}
}