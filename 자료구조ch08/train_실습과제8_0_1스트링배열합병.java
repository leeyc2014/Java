package 자료구조ch08;
/*
 * 8장: 스트링 배열 합병 정렬
 */
import java.util.Arrays;
import java.util.List;
public class train_실습과제8_0_1스트링배열합병 {
	
	private static void showList(String msg, String[] arr) {
		int idx = 0;
		System.out.print(msg + "{");
		for(String data : arr) {
			System.out.print(data);
			if(idx < arr.length - 1) {
				System.out.print(", ");
			}
			idx++;
		}
		System.out.print("}");
		System.out.println();
		
	}
	
	private static String[] mergeList(String[] s1, String[] s2) {
		String[] s = new String[s1.length + s2.length];
		for(int i = 0; i < s1.length; i++) {
			s[i] = s1[i];
		}
		for(int i = 0; i < s2.length; i++) {
			s[s1.length + i] = s2[i];
		}
		Arrays.sort(s);
		return s;
	}

    public static void main(String[] args) {
	String[] s1 = {"홍길동", "강감찬", "을지문덕", "계백", "김유신", "최치원" };
	String[] s2 = {"독도", "울릉도", "한산도", "영도", "오륙도", "동백섬"};
	Arrays.sort(s1);
	Arrays.sort(s2);
	
	showList("s1배열 = ", s1);
	showList("s2배열 = ", s2);

	String[] s3 = mergeList(s1,s2);//정렬된 s1[], s2[]을 합병하여 다시 정렬된 결과를 만드는 함수 구현
	showList("스트링 배열 s3 = s1 + s2:: ", s3);
    }
}
