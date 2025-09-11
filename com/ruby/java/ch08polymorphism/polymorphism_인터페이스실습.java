package com.ruby.java.ch08polymorphism;

interface Shape {
	public double perimeter();
	public float area();
	@Override
	String toString();//추상 메소드로 body가 없어야 한다
}

class Triangle implements Shape {
	private int x1,y1,x2,y2,x3,y3;
	public Triangle(int x1,int y1,int x2,int y2,int x3,int y3 ) {
		this.x1=x1;this.y1=y1;
		this.x2=x2;this.y2=y2;
		this.x3=x3;this.y3=y3;
	}
	@Override
	public double perimeter() {
		return 0.0;
		}
	@Override
	public float area() {
		return 0.1f;
	}
	@Override
	public String toString() {
		return x1 + ", " + y1 + ", " + x2 + ", " + y2+ ", " + x3 + ", " + y3;
	}
}
class Rectangle implements Shape {
	int x1,y1,x2,y2,x3,y3,x4,y4;
	public Rectangle(int x1,int y1,int x2,int y2,int x3,int y3, int x4,int y4 ) {
		this.x1=x1;this.y1=y1;
		this.x2=x2;this.y2=y2;
		this.x3=x3;this.y3=y3;
		this.x4=x4;this.y4=y4;
	}
	@Override
	public double perimeter() {
		return 1.1;
		}
	@Override
	public float area() {
		return 1.2f;
	}
	@Override
	public String toString() {
		return x1 + ", " + y1 + ", " + x2 + ", " + y2+ 
				", " + x3 + ", " + y3+ ", "+ x4 + ", " + y4;
	}
}
class Square extends Rectangle {
	int side;
	public Square(int x1,int y1,int x2,int y2,int x3,int y3, int x4,int y4,int s) {
		super(x1,y1,x2,y2,x3,y3,x4,y4);
		side = s;
	}
	@Override
	public double perimeter() {
		return 2.2;
		}
	@Override
	public float area() {
		return 2.31f;
	}
	@Override
	public String toString() {
		return "side = " + side;
	}
}
class Pentagon implements Shape {
	private int x1,y1,x2,y2,x3,y3,x4,y4,x5,y5;
	public Pentagon(int x1,int y1,int x2,int y2,int x3,int y3, int x4,int y4, int x5,int y5  ) {
		this.x1=x1;this.y1=y1;
		this.x2=x2;this.y2=y2;
		this.x3=x3;this.y3=y3;
		this.x4=x4;this.y4=y4;
		this.x5=x5;this.y5=y5;
	}
	@Override
	public double perimeter() {
		return 0.0;
		}
	@Override
	public float area() {
		return 0.1f;
	}
	@Override
	public String toString() {
		return x1 + ", " + y1 + ", " + x2 + ", " + y2+ 
				", " + x3 + ", " + y3+ ", " + x4 + ", " + y4+
				", " + x5 + ", " + y5;
	}
}

public class polymorphism_인터페이스실습 {
	 static float sumArea(Shape[]data){
		 float sum = 0.0f;
		 for (Shape sx: data) {
			 sum += sx.area();
		 }
		 //면적의 합을 구한다
		 return sum;
	 }
	public static void main(String[] args) {
		Shape[]arr = new Shape[4];
		arr[0] = new Triangle(1,2,3,4,5,6);
		arr[1] = new Rectangle(1,2,3,2, 1,5,3,5);
		arr[2] = new Square(1,2,3,2,1,4,3,4,2);
		arr[3] = new Pentagon(5,1, 8,1,3,5,10,5,6,12);
		for(Shape p : arr) {
			System.out.println(p.toString());
		}
		for(Shape px : arr) {
			System.out.println("둘레=" + px.perimeter());
			
		}
		System.out.println("면적 = " + sumArea(arr));
	}

}

