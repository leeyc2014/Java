package 자료구조ch10;

public class SeparateChaining {
	// MG = 10
	// MI = 10
	// Q = 15
	
	// ex)
	// "ADD apple" => 그룹 "a"에 "apple"을 추가, 해시 충돌 없음
	// "ADD ant" => 그룹 "a"에 "ant"를 추가, 정렬 위치에 삽입
	// "ADD ball" => 그룹 "b"에 "ball"을 추가
	// "ADD bat" => 그룹 "b"
	// "ADD cat" => 그룹 "c"
	// "FIND a" => "apple ant"
	// "FIND b" => "ball bat"
	// "COUNT a" => 2
	// "COUNT b" => 2
	// "ADD ace" => A에 추가 "정렬 위치"
	// "COUNT a" => 3
	// "DEL ant" => a에 "ant" 삭제
	// "COUNT a" => 2
	// "BUCKETG 1" => a, b, c
	// "BUCKETI 2" => a:ant, b:bat
	
	class GroupNode {
		char groupChar;
		ItemNode items;
		GroupNode next;
	}
	
	class ItemNode {
		String key;
		ItemNode next;
	}
	
	class KeyNode {
		String key;
		char group;
		KeyNode next;
	}
}
