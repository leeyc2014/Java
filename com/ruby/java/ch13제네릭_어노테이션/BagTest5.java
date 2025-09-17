package com.ruby.java.ch13제네릭_어노테이션;

class Bag4<T extends Solid> {
	private T thing;
	private String owner;
	
	public Bag4(T thing) {
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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	boolean isSameOwner(Bag4<?> obj) {
		if(this.owner.equals(obj.getOwner()))
			return true;
		return false;
	}
}
public class BagTest5 {
	public static void main(String[] args) {
		Bag4<Book3> bag = new Bag4<>(new Book3());
		Bag4<PencilCase3> bag2 = new Bag4<>(new PencilCase3());
		
		bag.setOwner("김푸름");
		bag2.setOwner("김푸름");
		
		boolean result = bag.isSameOwner(bag2);
		if(result) System.out.println("소유자가 동일합니다.");
		else System.out.println("소유자가 다릅니다");
	}
}
