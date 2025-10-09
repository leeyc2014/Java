package edu;
public class Gugudan {
	public static void printVertical() {
		for (int i = 2; i < 10; i++) {
			System.out.println(i + "단");
			for (int j = 1; j < 10; j++) {
				System.out.println(i + " * " + j + " = " + i * j);
			}
			System.out.println("-".repeat(20));
		}
	}

	public static void printHorizontal() {
		for (int i = 1; i < 10; i++) {
			System.out.print("\n");
			for (int j = 2; j < 10; j++) {
				System.out.print(j + " * " + i + " = " + i * j + "\t");
			}
		}System.out.print("\n");
	}

	public static void printColumn(int col) {	
		if(col <=0) {
			System.out.println("출력안됨");
		}
		if(col >= 9) {
			col = 8;
		}
		for (int start = 2; start <= 9; start += col) { 
	        for (int i = 1; i < 10; i++) {
	            System.out.println();
	            for (int j = start; j < start + col && j < 10; j++) {
	                System.out.print(j + " * " + i + " = " + (j * i) + "\t");
	            }
	        }
	        System.out.println();
	    }
	}
	public static void printColumn2(int col2) {
		if (col2 < 1 || 9 < col2) {
			System.out.println("col is not valid![1~9]");
			return;
		}

		for(int i = 2 ; i < 10 ; i+=col2) {
			for(int j = 0 ; j < 10 ; j++) {
				for (int k = 0 ; k < col2 ; k++) {

					if (10 <= i+k) {
						System.out.print("\n");
						break;
					}
					if (j == 0) {
						System.out.print((i+k) + "단\t");
					}
					else {
						System.out.printf("%d * %d = %d", (i+k), j, (i+k)*j);
					}
					if (k < col2-1)	System.out.print("\t");
					else			System.out.print("\n");
				}
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		printVertical();
		printHorizontal();
		printColumn(3);
		printColumn2(5);
	}
}
