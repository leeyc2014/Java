package com.ruby.java.ch14람다식;


interface Verify2 {
	boolean check(int n, int d);
}

/*class Verify02 implements Verify2 {
	public boolean check(int n, int d) {
		return (n % d) == 0;
	}
}*/

public class Test04 {
	public static void main(String[] args) {
		Verify2 vf = (n, d) -> (n % d) == 0;
		System.out.println(vf.check(24, 3));
		//System.out.println((24, 3) -> (n % d) == 0);
	}
	/*public static void main(String[] args) {
		Verify02 mv = new Verify02();
		System.out.println(mv.check(24, 3));
	}*/
}
