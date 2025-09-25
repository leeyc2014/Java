package 자료구조ch03;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 3장 4번 실습과제 - 객체 배열의 정렬과 이진검색 - Comparator 구현
 * 3장 실습 3-8를 수정하여 객체 배열의 정렬 구현
 */

class PhyscData3 {
	private String name;
	private int height;
	private double vision;
	
	public PhyscData3(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	public String getName() {
		return name;
	}
	
	public int getHeight() {
		return height;
	}
	
	public double getVision() {
		return vision;
	}

	@Override
	public String toString() {
		return "PhyscData3 [name=" + name + ", height=" + height + ", vision=" + vision + "]";
	}
}

class NameHeightVision implements Comparator<PhyscData3>{
	public int compare(PhyscData3 a, PhyscData3 b) {
		int comName = a.getName().compareTo(b.getName());
		int comHeight = a.getHeight() - b.getHeight();
		int comVision = Double.compare(a.getVision(), b.getVision());
		if(comName == 0) {
			return comHeight;
		}
		if(comHeight == 0) {
			return comVision;
		}
		return comName;
	}
}

class NameOrder implements Comparator<PhyscData3>{ 
	public int compare(PhyscData3 a, PhyscData3 b) {
		return a.getName().compareTo(b.getName());
	}
}

class HeightOrder implements Comparator<PhyscData3>{
	public int compare(PhyscData3 a, PhyscData3 b) {
		return a.getHeight() - b.getHeight();
	}
}
class VisionOrder implements Comparator<PhyscData3>{
	public int compare(PhyscData3 a, PhyscData3 b) {
		return Double.compare(a.getVision(), b.getVision());
	}
}
public class train실습3_8객체비교연산자들정의 {	
	static final Comparator<PhyscData3> HEIGHT_ORDER = new HeightOrder();
	
	public static void showData(String msg, PhyscData3[] data) {
		System.out.print(msg + ": \n");
		System.out.println("-".repeat(30));
		for(PhyscData3 arr : data) {
			System.out.printf("%s\t%d\t%.2f\n", arr.getName(), arr.getHeight(), arr.getVision());
		}
		System.out.print("-".repeat(30));
		System.out.println();
	}

	public static void main(String[] args) {
		PhyscData3[] data = {
				new PhyscData3("홍길동", 162, 0.3),
				new PhyscData3("나가자", 164, 1.3),
				new PhyscData3("다정해", 152, 0.7),
				new PhyscData3("소주다", 172, 0.4),
				new PhyscData3("사이다", 182, 0.6),
				new PhyscData3("신정신", 166, 1.2),
				new PhyscData3("이기자", 167, 1.5),
		};
		showData("정렬전 객체 배열", data);
		Arrays.sort(data, HEIGHT_ORDER);	
		showData("height로 정렬후 객체 배열", data);
		
		PhyscData3 key = new PhyscData3("길동", 167, 0.2);
		
		int idx = Arrays.binarySearch(data, key, HEIGHT_ORDER);
		System.out.println("\nArrays.binarySearch(data, key, HEIGHT_ORDER): result = " + idx);
		
		Arrays.sort(data, new VisionOrder());
		showData("vision로 정렬후 객체 배열", data);
		
		Arrays.sort(data, new Comparator<PhyscData3>() {
			@Override
			public int compare(PhyscData3 a1, PhyscData3 a2) {
				return a1.getName().compareTo(a2.getName());
			}
		});
		showData("name로 정렬후 객체 배열", data);
	}

}
