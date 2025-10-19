package 자료구조ch05;

import java.util.Stack;

/*
 * Knight's Tour 문제는 체스판에서 나이트(Knight) 말이 모든 체스판의 칸을 한 번씩만 방문하면서
 * 체스판의 모든 방을 방문하면 종료. 
 * 나이트는 체스에서 "L" 모양으로 움직이는데, 두 칸 직진하고 한 칸 옆으로 이동하는 방식입니다.
 * 임의 위치에서 시작

문제 설명
체스판은 보통 8x8 크기이지만, 이 문제는 임의의 N x N 체스판에서 해결할 수 있습니다.
목표는 나이트가 시작점에서 출발하여 모든 칸을 한 번씩만 방문하면서 끝나는 경로를 찾는 것입니다.
종료조건: 모든 칸이 방문하였을 때 종료 > 방문한 순서를 출력

구현조건:
(x,y)를 저장하는 point 객체를 사용하여 스택으로 non-recursive backtracking 알고리즘으로 구현

1. 6*6 체스판에 나이트를 (0, 0) 위치에 지정
1-1. 시작 위치를 스택에 푸시
2. 나이트 이동(두 칸 직진 후 한 칸 옆으로 이동)
2-1. 이동 후 위치를 스택에 푸시
3. 이동 진행 하다가 더이상 진행할 방향이 없으면 backtracking
3-1. 이동 위치마다 스택에 푸시 하다가 막히면 팝으로 이전위치로 돌아가기(backtracking)
4. 나이트가 6*6 체스판을 모두 돌고난 후 더이상 이동할 곳이 없으면 프로그램 종료 후 방문 순서 출력
 */

enum knightMoves {NW, NE, EN, ES, SE, SW, WW, WN} // 나이트의 8가지 방향

class Offsets4 {	// 각 방향에서 x축(a), y축(b)으로 얼마나 움직일지를 저장하는 클래스
	int a;
	int b;
	public Offsets4(int a, int b) {
		this.a = a; this.b = b;
	}
}
public class train_5_7_1KnightTracking_실습 {
	static Offsets4[] moves = new Offsets4[8];	// static을 선언하는 이유를 알아야 한다 - main과 solveKnightTracking에서 호출해서 사용하기 위함, 프로그램 실행 중 정보가 변하지 않음 (나이트의 8가지 이동 방향 저장하는 배열)
    static final int N = 6;		// 체스판 크기 6*6 지정

	
    // 체스판 배열
    private static int[][] board = new int[N][N];

    // Point 객체로 나이트의 위치를 저장
    static class Point {
        int x, y, moveToward;

        Point(int x, int y, int moveToward) {
            this.x = x;
            this.y = y;
            this.moveToward = moveToward;
        }
    }

    // 체스판을 초기화 (-1로 설정)
    private static void initializeBoard() {
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			board[i][j] = -1;
    		}
    	}
    }

    // 체스판의 범위 내에서 유효한 움직임인지 확인
    private static boolean isSafe(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    // 나이트 투어 알고리즘 (비재귀적으로 스택 사용)
    private static boolean solveKnightTracking(int startX, int startY) {
    	for (int ia = 0; ia < 8; ia++)
    	moves[ia] = new Offsets4(0, 0);//배열에 Offsets4 객체를 치환해야 한다.
    	moves[0].a = -2;	moves[0].b = -1;//NW으로 이동
    	moves[1].a = -2;	moves[1].b = 1;//NE
    	moves[2].a = -1;	moves[2].b = 2;//EN
    	moves[3].a = 1;		moves[3].b = 2;//ES
    	moves[4].a = 2;		moves[4].b = 1;//SE
    	moves[5].a = 2;		moves[5].b = -1;//SW
    	moves[6].a = -1;	moves[6].b = -2;//WS
    	moves[7].a = 1;		moves[7].b = -2;//WN
        // 나이트가 이동할 수 있는 8가지 방향
        
        Stack<Point> stack = new Stack<>();		// 백트래킹을 위해 나이트의 위치를 저장할 스택

        // 시작 위치를 스택에 푸시
        stack.push(new Point(startX, startY, 0));
        board[startX][startY] = 0; // 시작 위치는 첫 번째 이동
        
        int moveCount = 0;	// 나이트가 몇 번째로 이동했는지를 추적
        

        while (!stack.isEmpty()) {	// 스택이 비어있지 않는 동안 반복
            
            // 8가지 방향으로 나이트 이동 시도
        	int x = stack.peek().x;
        	int y = stack.peek().y;
        	int d = stack.peek().moveToward;
        	boolean moved = false;	// 나이트가 이번에 이동했는지 여부를 저장
        	
        	while(d < 8) {	// 현재 위치에서 8방향 중 남은 방향을 시도   		
        	    // d번째 방향으로 이동한 좌표를 계산
        		int nextX = x + moves[d].a;
        	    int nextY = y + moves[d].b;
        	   
        	   
        	   if (isSafe(nextX, nextY)) {
                   // 방문 표시: 몇 번째로 이동한 칸인지 기록
        		   moveCount++;
                   board[nextX][nextY] = moveCount;

                   // 현재 위치의 다음 방향 저장
                   stack.peek().moveToward = d + 1;
                   // 새로운 위치를 스택에 push
                   stack.push(new Point(nextX, nextY, 0));
                   // 이동 성공하면 break, 아니면 다음 방향 시도
                   moved = true;
                   break;
               }
        	   d++;
           }

            // 더 이상 이동할 곳이 없을 경우
        	if (!moved) {
                // 백트래킹: 현재 위치 방문 취소
                board[x][y] = -1;
                moveCount--;
                stack.pop();
            }
        	// 모든 칸을 방문했으면 성공
            if (moveCount == N * N - 1) {
                return true;
            }
        }
        return false; // 해결하지 못함
    }

    // 결과 출력
    private static void showTracking() {
    	System.out.println("나이트의 이동 경로:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%2d ", board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {


        initializeBoard();

        // 나이트가 (0, 0)에서 시작
        if (solveKnightTracking(0, 0)) {
            showTracking();
        } else {
            System.out.println("해결할 수 없습니다.");
        }
    }
}
