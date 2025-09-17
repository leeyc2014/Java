package com.ruby.java.ch13제네릭_어노테이션;

class Bag<T> {
	private T thing;
	
	public Bag(T thing) {
		this.thing = thing;
	}
	
	public T getThing() {
		return thing;
	}
	
	public void setThing(T thing) {
		this.thing = thing;
	}
	
	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}
}

class Book0 { }
class PencilCase { }
class Notebook { }

public class BagTest {
	public static void main(String[] args) {
		Bag<Book0> bag = new Bag<>(new Book0());
		Bag<PencilCase> bag2 = new Bag<>(new PencilCase());
		Bag<Notebook> bag3 = new Bag<>(new Notebook());
		
		bag.showType();
		bag2.showType();
		bag3.showType();
		
	}
}
