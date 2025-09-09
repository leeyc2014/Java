package com.ruby.java.ch06객체구현;
/*
 * 하나의 자바 파일(.java)에는 단 하나의 public 클래스만 선언해야 한다
 * 
 * 자바 언어의 규칙에 따라, public으로 선언된 클래스가 있을 경우 해당 클래스의 이름과 
 * 소스 파일의 이름은 반드시 같아야 한다.
 * 
 * JVM 입장에서는 public 클래스가 하나도 없어도 .class 파일만 정상적으로 존재한다면 
 * 전혀 문제가 되지 않는다
 */
class Student2 {
//public class Student2 {
	int a;
	int b;
}
//public class ArmorTest {
public class ArmorTest {
	public static int sum(int data1, int data2) {
		int result = data1 + data2;
		return result;
	}
	public static void main(String[] args) {
		String st;
		st = "hello"; //String literal은 메소드 영역의 constant pool에 저장
		st.toString();
		int result = sum(10, 20);
		Armor am; //am은 로컬변수로서 참조변수
		am = new Armor(); //생성자 호출
		Armor am2 = new Armor();
		Armor am3 = new Armor();
		Armor am4 = new Armor();
		
		am2.getHeight();
		int n = 10;
		Armor a = new Armor();//클래스로 변수 선언시 초기화가 필요하다.
		a.height = 0;//not visible(Armor 클래스의 height 필드가 private으로 설정) - Armor 클래스 내에서만 사용 가능
		a.setHeight(n);
		a = new Armor();
		/*
		 * new 키워드는 힙(Heap) 영역에 객체를 저장할 공간을 동적으로 할당
		 * 필드는 힙에 저장되고, 힙 메모리를 동적으로 할당하는 것은 new 키워드의 역할
		 * 
		 * 생성자는 할당된 메모리 공간에 있는 인스턴스 변수들을 사용자가 정의한 초기값으로 초기화하는 역할
		 */
		//System.out.println(a.name + " : " + a.getHeight());//220페이지 표 참조

		Armor suit1 = new Armor();
		Armor suit2 = new Armor();
		Armor suit3 = new Armor();
		/*
		 *  JVM이 .java 파일을 컴파일한 .class 파일을 로드할 때, 클래스 정보, 필드, 
		 *  그리고 메소드에 대한 정의는 **메소드 영역(Method Area)**에 저장
		 *  
		 *  JVM 내에서 클래스당 하나만 존재하며, 모든 인스턴스가 공유하는 공간
		 *  
		 *  heap의 객체 인스턴스에는 메소드 코드가 포함되지 않는다(215페이지 그림)
		 *  
		 */
		suit1.setName("mark611");
		suit1.setHeight(180);

		suit2.setName("mark16");
		suit2.setHeight(220);

		suit3.setName("mark38");
		suit3.setHeight(200);

		System.out.println(suit1.getName() + " : " + suit1.getHeight());
		System.out.println(suit2.getName() + " : " + suit2.getHeight());
		System.out.println(suit3.getName() + " : " + suit3.getHeight());
	}
}