package 자료구조ch03;

import java.util.Arrays;
import java.util.Comparator;

class Student2 implements Comparator<Student2>{
	private String sid; //(학번)
	private String sname; //(이름)
	private String dept; //(학과)

	public Student2(String sid, String sname, String dept) {
		this.sid = sid;
		this.sname = sname;
		this.dept = dept;
	}
	
	public String getSid() {
		return sid;
	}

	public String getSname() {
		return sname;
	}

	public String getDept() {
		return dept;
	}

	public int compare(Student2 a, Student2 b) {
		return a.getSid().compareTo(b.getSid());
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", dept=" + dept + "]";
	}
}

public class train_실습3_10_객체comparator구현 {

/*
 * 문제 : Comparable 구현 
다음과 같은 정보를 저장하는 Student 클래스를 정의하고, 고정된 학생 배열을 학번(sid) 기준으로 정렬한 뒤,
탐색 대상 학생 객체 배열에 대해 Arrays.binarySearch()를 이용하여 해당 학번을 가진 학생이 배열에 존재하는지 판단하는 프로그램을 작성하시오.

✅ 구현 조건
Student 클래스는 다음과 같은 멤버 변수와 메서드를 반드시 포함해야 한다:
*/

	private static void show(Student2[] arr) {
		System.out.println("\"=== 정렬 전 학생 목록 ===\"");
		for(Student2 st : arr) {
			System.out.printf("%s, %s, %s\n", st.getSid(), st.getSname(), st.getDept());
		}
		System.out.println("-".repeat(30));
		System.out.println();
	}
	
	public static void main(String[] args) {
	// Student 클래스는 Comparable<Student> 인터페이스를 구현해야 한다.
		Comparator<Student2> sidCom = (a, b) -> a.getSid().compareTo(b.getSid());
	// 메인 메서드에서 다음 학생 배열을 정의한다 (정렬 전 상태):

		Student2[] students = {
			new Student2("S001", "영희", "Math"),
			new Student2("S003", "민수", "Computer"),
			new Student2("S002", "철수", "Physics"),
			new Student2("S005", "지영", "Biology"),
			new Student2("S004", "준호", "Chemistry")
		};	
		Arrays.sort(students, sidCom);
		show(students);
	// 위 배열을 **Arrays.sort()**로 정렬한 후, 다음과 같은 탐색 대상 객체 배열을 정의하고 반복문으로 탐색한다:

		Student2[] targets = {
			new Student2("S002", "철수", "Physics"),
			new Student2("S006", "홍길동", "Law"),
			new Student2("S004", "준호", "Chemistry")
		};
		System.out.println("=== 이진 탐색 결과 ===");
		for (Student2 st : targets) {
			int binSearch = Arrays.binarySearch(students, st, sidCom);
			if (binSearch >= 0) {
				Student2 target = students[binSearch];
				System.out.printf("찾은 학생: %s, %s, %s\n", target.getSid(), target.getSname(), target.getDept());
			} 
			else {
				System.out.printf("학번 %s인 학생은 존재하지 않습니다.\n", st.getSid());
			}
		}
	// 위 배열을 확장형 for문으로 순회하면서 Arrays.binarySearch()를 통해 각 객체를 탐색하고 결과를 출력한다. 
	// 출력 형식은 다음 중 하나로 한다:
		
	// "찾은 학생: S002, 철수, Physics"

	// "학번 S006인 학생은 존재하지 않습니다."	
	}
}

/*=== 정렬 전 학생 목록 ===
S001, 영희, Math
S003, 민수, Computer
S002, 철수, Physics
S005, 지영, Biology
S004, 준호, Chemistry

=== 이진 탐색 결과 ===
찾은 학생: S002, 철수, Physics
학번 S006인 학생은 존재하지 않습니다.
찾은 학생: S004, 준호, Chemistry

 */
	