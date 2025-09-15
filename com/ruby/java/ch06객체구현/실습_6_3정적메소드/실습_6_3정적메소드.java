package com.ruby.java.ch06객체구현.실습_6_3정적메소드;

class Student {
	// 필드
	
	//name, age, subjects[], scores[], passFail[], count를 private으로 선언
	private String name;
	private int age;
	private String [] subjects;
	private int [] scores;
	private int [] passFails;
	private int count;
	//count는 배열의  index로 사용
	//numberStudents를 정적 필드로 선언
	static int numberStudents;	
	// 생성자
	public Student(String name, int age, String[] subjects, int[] scores, int[] passFails, int count) {
		this.name = name;
		this.age = age;
		this.subjects = subjects;
		this.scores = scores;
		this.passFails = passFails;
		this.count = count;
	}
	
	//name, age, subjects[], scores[], passFail[], count를 매개변수로 전달받는 생성자 정의	

	// 학생 수를 반환하는 정적 메소드getNumberStudents()
		static int getnumberStudents() {
			return numberStudents;
		}
	// setter 메소드: setName(String name), setAge(int age), setSubjects(String subjects[]), setScores(int scores[]), setCount(int num)
		public void setName(String name) {
			this.name = name;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public void setSubjects(String[] subjects) {
			this.subjects = subjects;
		}

		public void setScores(int[] scores) {
			this.scores = scores;
		}

		public void setPassFails(int[] passFails) {
			this.passFails = passFails;
		}

		public void setCount(int count) {
			this.count = count;
		}
	// 학생 정보를 출력하는 메소드 (예시용)
	public void printStudent() {
		System.out.println("이름 = " + name + ", 나이 = " + age);
		for(int i = 1; i <= subjects.length; i++) {
			System.out.println("과목" + i + " = " + subjects[i - 1] + ", 점수" + i + " = " + scores[i - 1]);
		}
		  //이름 = **, 나이 = **
		  //과목1 = **, 점수1 = **
		  //과목2 = **, 점수2 = **
		  //... 등으로 출력
	}

	// 통과 여부 (모든 과목을 통과했는지 확인)
	public boolean isPassed() {
		//주어진 학생이 모든 과목 통여 여부를 반환
		for(int i = 1; i < scores.length; i++) {
			if(scores[i - 1] < passFails[i - 1])
				return false;
		}
		return true;
	}

	// 6.2.2 각 학생의 성적 테이블을 출력하는 정적 메소드
	public static void printAllStudents(Student[] students) {
		//학생 이름 + 과목명, 과목 점수 .... + 과목통과여부:pass or fail
		for(Student s : students) {
			System.out.println("이름 = " + s.name + ", 나이 = " + s.age);
			for(int i = 1; i <= s.subjects.length; i++) {			
				String result = (s.isPassed()) ? "Pass" : "Fail";
				System.out.println("과목" + i + " = " + s.subjects[i - 1] + ", 점수" + i + " = " + s.scores[i - 1] + ", 통과기준 = " + s.passFails[i - 1] + " -> " + result);
			}
			System.out.println();
		}
	}
	
	// 6.2.2 과목별 최대/최소 점수 및 해당 학생을 출력하는 정적 메소드
	/*public static void printSubjectStats(Student[] students) {
		for (int i = 0; i < subjects.length; i++) {
			int max = 0;
			int min = 101;
			String maxSt = "";
			String minSt = ""; 
			for (Student s : students) {			
				if (s.scores[i] > max) {
					max = s.scores[i];
					maxSt = s.name;
				}
				if (s.scores[i] < min) {
					min = s.scores[i];
					minSt = s.name;
				}
			}
			System.out.println("과목 = " + s.subjects[i]);
			System.out.println("최고 점수 = " + max, ", 학생 = " + maxSt);
			System.out.println("최소 점수 = " + min, ", 학생 = " + minSt);
			System.out.println();
		}
	}*/
}
public class 실습_6_3정적메소드 {
	static void showStudents(Student[] students) {
		for(Student s : students) {
			s.printStudent();
			System.out.println();
		}
	}
	public static void main(String[] args) {
		String[] subjects = {"수학", "국어", "영어", "과학", "역사"};
		int []passFails = {40,70,60,55,80};
		Student[] students = { 
				//생성자를 사용하여 객체 생성
				new Student("홍길동", 21, subjects, new int[]{85, 90, 78, 88, 92},passFails, -1),
				new Student("김유신", 22, subjects, new int[]{75, 80, 85, 90, 95}, passFails,-1),
				new Student("계백", 23, subjects, new int[]{65, 70, 75, 80, 85}, passFails,-1),
				new Student("강감찬", 24, subjects, new int[]{95, 92, 88, 84, 91}, passFails,-1),
				new Student("을지문덕", 25, subjects, new int[]{88, 76, 85, 79, 90}, passFails,-1)					 
		};
		// 학생 수를 정적 메소드 호출로 처리
		Student.numberStudents = students.length;
		System.out.println("학생수 = " + Student.numberStudents + "명");
		System.out.println();
		// 학생 정보 출력 (예시)
		showStudents(students);
		// 각 학생의 성적 테이블 출력
		Student.printAllStudents(students);
		// 과목별 최대/최소 점수 및 해당 학생 출력
		//Student.printSubjectStats(students);
		}
	}