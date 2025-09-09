package com.ruby.java.ch06객체구현;

public class Armor {
	private String name;
	int height;

	public String getName() { //getter(게터) : 값을 가져옴
		return name;
	}

	public void setName(String value) { //setter(세터) : 값을 설정함
		name = value;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int value) {
		height = value;
	}
}