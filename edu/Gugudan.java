package edu;
public class Gugudan {
	public static void printVertical() {
		for(int i = 2; i < 10 ; i++) {
			System.out.println(i + "단");
			for(int j = 1; j < 10; j++) {
				System.out.println(i + " * " + j + " = " + i*j);
			}
			System.out.println("-".repeat(20));
		}
	}
	public static void printHorizontal() {
		for(int i = 1; i < 10 ; i++) {
			System.out.print("\n");
			for(int j = 2; j < 10; j++) {
				System.out.print(j + " * " + i + " = " + i*j + "\t");
			}			
		}
	}
	public static void printolumn(int col) {
		
	}
	public static void main(String[] args) {
		printVertical();
		printHorizontal();
		printolumn(3);
	}
}
