package com.ruby.java.ch07상속;
abstract class Employee2 {//추상 클래스
	String name;
	int salary;
	public Employee2 () {} //Default 생성자(name = null, salary = 0로 초기화)
	public Employee2(String n, int s) {
		this.name = n;
		this.salary = s;
	}
	public abstract void calcSalary();//추상 메소드
	public abstract void calcBonus();//추상 메소드
}
abstract class Salesman extends Employee2 {//307페이지 하단 밑에서 두번째 문단
	int salesQty;	
	public Salesman() {
		super();
	}
	public Salesman(String name, int salary, int qty) {
	  	super(name, salary);
	  	salesQty = qty;
	}	 
	public void calcSalary() {
		System.out.println("Salesman 급여 = 기본급+판매수당*판매량");
	}
}
class DomesticSalesman extends Salesman {//concrete 클래스
	int domesticSalesQty;
	/*public DomesticSalesman() {
		super();
	}*/
	public DomesticSalesman(String name, int salary, int qty, int dqty) {
		super(name, salary, qty);
		//salesQty = qty;
		domesticSalesQty = dqty; 	
	}
	public void calcBonus() {
		System.out.println("DomesticSalesman 보너스 = 기본급* 0.01");
	}
}
class Consultant extends Employee2 {
	int consultingHours;
	public Consultant() {
		super();
	}//Default 생성자(자바 컴파일러가 자동 생성)
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급+컨설팅단가 * 컨설팅 시간");
	}
	public void calcBonus() {
		System.out.println("Consultant 보너스 = 기본급* 0.02");
	}
}
class Manager extends Employee2 {
	int teamNumbers;
	public void calcSalary() {
		System.out.println("Manager 급여 = 기본급+관리자단가 * 팀수");
	}
	public void calcBonus() {
		System.out.println("Manager 보너스 = 기본급* 0.03");
	}
}
public class HRSTest {
	
	public static void main(String[] args) {
		//Employee2 e2 = new Employee2();
		//Salesman s = new Salesman();//추상 클래스
		//DomesticSalesman s = new DomesticSalesman("홍길동", 10, 20, 30);
		Employee2 e2 = new DomesticSalesman("홍길동", 10, 20, 30);
		Consultant c = new Consultant();
		Manager m = new Manager();
		e2.calcSalary();
		//s.calcSalary();
		c.calcSalary();
		m.calcSalary();

	}

}
