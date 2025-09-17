package com.ruby.java.ch13제네릭_어노테이션;


class Bag1 {
	private Object thing;
	
	public Bag1(Object thing) {
		this.thing = thing;
	}
	
	public Object getThing() {
		return thing;
	}
	
	public void setThing(Object thing) {
		this.thing = thing;
	}
	
	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}
}

class Book1 { }
class PencilCase1 { }
class Notebook1 { }

public class BagTest2 {
	public static void main(String[] args) {
		Bag1 bag = new Bag1(new Book1());
		Bag1 bag2 = new Bag1(new PencilCase1());
		Bag1 bag3 = new Bag1(new Notebook1());
		
		Book1 book = (Book1) bag.getThing();
		PencilCase1 pc = (PencilCase1) bag2.getThing();
		Notebook1 nb = (Notebook1) bag3.getThing();
		/*Bag<Book> bag = new Bag<>(new Book());
		Bag<PencilCase> bag2 = new Bag<>(new PencilCase());
		Bag<Notebook> bag3 = new Bag<>(new Notebook());
		
		Book book = (Book) bag.getThing();
		PencilCase pc = (PencilCase) bag2.getThing();
		Notebook nb = (Notebook) bag3.getThing();*/
		
		bag = bag2;
	}
}
