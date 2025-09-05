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
		if (col == 1)
			for (int i = 2; i < 10; i++) {
				System.out.print("\n");
				for (int j = 1; j < 10; j++) {
					System.out.println(i + " * " + j + " = " + i * j);
				}
			}
		else if (col == 2) {
			for (int i = 1; i < 10; i++) {
				System.out.print("\n");
				for (int j = 2; j < 4; j++) {
					System.out.print(j + " * " + i + " = " + i * j + "\t");
				}
			}System.out.println();
			for	(int k = 1; k < 10; k++) {
				System.out.print("\n");
				for (int l = 4; l < 6; l++) {
					System.out.print(l + " * " + k + " = " + k * l + "\t");
				}
			}System.out.println();
			for (int m = 1; m < 10; m++) {
				System.out.print("\n");
				for (int n = 6; n < 8 ; n++) {
					System.out.print(n + " * " + m + " = " + m * n + "\t");
				}
			}System.out.println();
			for (int o = 1; o < 10; o++) {
				System.out.print("\n");
				for (int p = 8; p < 10 ; p++) {
					System.out.print(p + " * " + o + " = " + o * p + "\t");
				}
			}System.out.println();
		}
		else if(col == 3) {
			for (int i = 1; i < 10; i++) {
				System.out.print("\n");
				for (int j = 2; j < 5; j++) {
					System.out.print(j + " * " + i + " = " + i * j + "\t");
				}
			}System.out.println();
			for	(int k = 1; k < 10; k++) {
				System.out.print("\n");
				for (int l = 5; l < 8; l++) {
					System.out.print(l + " * " + k + " = " + k * l + "\t");
				}
			}System.out.println();
			for (int m = 1; m < 10; m++) {
				System.out.print("\n");
				for (int n = 8; n < 10 ; n++) {
					System.out.print(n + " * " + m + " = " + m * n + "\t");
				}
			}System.out.println();
		}
		else if(col == 4) {
			for (int i = 1; i < 10; i++) {
				System.out.print("\n");
				for (int j = 2; j < 6; j++) {
					System.out.print(j + " * " + i + " = " + i * j + "\t");
				}
			}System.out.println();
			for	(int k = 1; k < 10; k++) {
				System.out.print("\n");
				for (int l = 6; l < 10; l++) {
					System.out.print(l + " * " + k + " = " + k * l + "\t");
				}
			}System.out.println();
		}
		else if(col == 5) {
			for (int i = 1; i < 10; i++) {
				System.out.print("\n");
				for (int j = 2; j < 7; j++) {
					System.out.print(j + " * " + i + " = " + i * j + "\t");
				}
			}System.out.println();
			for	(int k = 1; k < 10; k++) {
				System.out.print("\n");
				for (int l = 7; l < 10; l++) {
					System.out.print(l + " * " + k + " = " + k * l + "\t");
				}
			}System.out.println();
		}
		else if(col == 6) {
			for (int i = 1; i < 10; i++) {
				System.out.print("\n");
				for (int j = 2; j < 8; j++) {
					System.out.print(j + " * " + i + " = " + i * j + "\t");
				}
			}System.out.println();
			for	(int k = 1; k < 10; k++) {
				System.out.print("\n");
				for (int l = 8; l < 10; l++) {
					System.out.print(l + " * " + k + " = " + k * l + "\t");
				}
			}System.out.println();
		}
		else if(col == 7) {
			for (int i = 1; i < 10; i++) {
				System.out.print("\n");
				for (int j = 2; j < 9; j++) {
					System.out.print(j + " * " + i + " = " + i * j + "\t");
				}
			}System.out.println();
			for	(int k = 1; k < 10; k++) {
				System.out.print("\n");
				for (int l = 9; l < 10; l++) {
					System.out.print(l + " * " + k + " = " + k * l + "\t");
				}
			}System.out.println();
		}
		else if(col == 8) {
			for (int i = 1; i < 10; i++) {
				System.out.print("\n");
				for (int j = 2; j < 10; j++) {
					System.out.print(j + " * " + i + " = " + i * j + "\t");
				}
			}System.out.println();
		}
		else if(col >= 8) {
			for (int i = 1; i < 10; i++) {
				System.out.print("\n");
				for (int j = 2; j < 10; j++) {
					System.out.print(j + " * " + i + " = " + i * j + "\t");
				}
			}System.out.println();
		}
		else if(col <=0) {
			System.out.println("출력안됨");
		}
	}

	public static void main(String[] args) {
		printVertical();
		printHorizontal();
		printColumn(1);
	}
}
