package com.ruby.java.ch07상속;

//Discountable 인터페이스 정의 -시즌 할인율 적용
interface Discountable {
	double getDiscountedPrice(double price);
}

//SeasonalDiscount 클래스: Discountable 인터페이스 구현
class SeasonalDiscount implements Discountable {
	private double seasonalDiscountRate;

	// 생성자
	
	
	// Getter
	
	
	@Override
	public double getDiscountedPrice(double price) {
		return 0.0;
	}
}

//Item 추상 클래스
abstract class Item3 {
	private String name; // 제품명
	private double price; // 제품 가격
	private int stockQuantity; // 재고량

	// 생성자
	
	
	// Getter
	

	public void reduceStock(int quantity) {

	}
}

//Electronics 클래스: Item 클래스 상속
class Electronics3 extends Item3 {
	private int madeYear;

	// 생성자
	
}

//Clothing 클래스: Item 클래스 상속
class Clothing3 extends Item3 {
	private int size;

	// 생성자

}

//Order 클래스
class Order3 extends SeasonalDiscount {
	private final int N = 20;
	private Customer3 customer; // 고객명
	private Item3[] items; // 주문 제품들
	private int[] quantities; // 주문 제품 수량들
	private String[] orderDates; // 주문일자들
	private int count;

	// 생성자
	
	
	public void addItem(Item3 item, int quantity, String date) {

	}

	private double calculateTotal() {
		return 0.0;
	}

	public void printOrderSummary() {

	}

	// 할인된 내역을 출력하는 메소드
	public void printDiscountDetails() {
		/*
		 * 정가 - 시즌 할인 적용 - 고객 할인 적용 => 할인된 가격 * 수량 > 총 지불 금액
		 */
	}
}

//Customer 추상 클래스 정의
abstract class Customer3 {
	private String name;

	// 생성자
	

	@Override
	public String toString() {
		return "고객명:" + name;
	}
	
	abstract double applyDiscount(double totalAmount);
	abstract double getDiscountRate();
}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer3 extends Customer3 {
	static final double REGULARDISCOUNT_RATE = 0.03;

	// 생성자
	

	@Override
	double applyDiscount(double totalAmount) {
		// 일반 고객은 추가 할인 없음
		return 0.0;
	}
	
	@Override
	double getDiscountRate() {
		return 0.0;
	}
}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer3 extends Customer3 {
	static final double PREMIUMDISCOUNT_RATE = 0.1;

	// 생성자
	
	@Override
	double applyDiscount(double totalAmount) {
		return 0.0;
	}
	
	@Override
	double getDiscountRate() {
		return 0.0;
	}
}

public class 실습_7_3_인터페이스 {
	public static void main(String[] args) {
/*
		// 배열에 전자제품과 의류패션 객체 추가
		Item3 note = new Electronics3("노트북", 1500, 24, 23);
		Item3 clothe = new Clothing3("티셔츠", 50, 50, 95);

		// 고객 생성
		Customer3 regularCustomer = new RegularCustomer3("홍길동");
		Customer3 premiumCustomer = new PremiumCustomer3("강감찬");

		// 주문 생성 및 계산 (RegularCustomer)
		Order3 regularOrder = new Order3(regularCustomer);
		regularOrder.addItem(note, 1, "240901");
		regularOrder.addItem(clothe, 2, "240902");

		regularOrder.printOrderSummary();
		regularOrder.printDiscountDetails(); // 할인된 내역 출력

		// 주문 생성 및 계산 (PremiumCustomer)
		Order3 premiumOrder = new Order3(premiumCustomer);
		premiumOrder.addItem(note, 1, "240901");
		premiumOrder.addItem(clothe, 2, "240903");

		premiumOrder.printOrderSummary();
		premiumOrder.printDiscountDetails(); // 할인된 내역 출력
*/
		/*
		 * 출력 결과 예시
		 * 
		고객명:홍길동
		제품명:노트북, 단가:1500.0, 수량:1, 가격:1500.0
		제품명:티셔츠, 단가:50.0, 수량:2, 가격:100.0
		구매총액:1600.0
		---------------------------------------------
		할인율:0.03
		할인가격:1552.0
		=============================================
		고객명:강감찬
		제품명:노트북, 단가:1500.0, 수량:1, 가격:1500.0
		제품명:티셔츠, 단가:50.0, 수량:2, 가격:100.0
		구매총액:1600.0
		---------------------------------------------
		할인율:0.1
		할인가격:1440.0
		시즌할인율:0.05
		시즌할인:1368.0
		=============================================
		 */
	}
}
