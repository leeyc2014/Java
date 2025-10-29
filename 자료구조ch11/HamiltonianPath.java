package 자료구조ch11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HamiltonianPath {
	static int N, M;
	static List<List<Integer>> graph;
	static List<Integer> path;
	static boolean[] visited;	
	static boolean found;
	
	static void solve(int n, int[][] edges) {
		N = n;
		M = edges.length;
		
		// 입력 검증
		if(N < 1 || N > 20) {
			System.out.println("no");
			return;
		}
		
		// 그래프 초기화
		graph = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}
		
		// 간선 입력
		for(int i = 0; i < M; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			
			if(u < 0 || u >= N || v < 0 || v >= N) {
				System.out.println("no");
				return;
			}
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		// 인접 리스트 정렬(사전순 최소 경로 우선)
		for(int i = 0; i < N; i++) {
			Collections.sort(graph.get(i));
		}
		
		// 각 정점을 시작으로 DFS
		visited = new boolean[N];
		path = new ArrayList<>();
		found = false;
		
		for(int i = 0; i < N && !found; i++) {
			Arrays.fill(visited, false);
			path.clear();
			
			visited[i] = true;
			path.add(i);
			dfs(i, 1);
		}
		
		if(found) {
			System.out.println("yes");
			for(int i = 0; i < path.size(); i++) {
				if(i > 0) {
					System.out.print(" ");
				}
				System.out.print(path.get(i));
			}
			System.out.println();
		}
		else {
			System.out.println("no");
		}
	}
	
	static void dfs(int current, int depth) {
		// 이미 경로를 찾았음
		if(found) {
			return;
		}
		
		// 모든 정점을 방문했으면 해밀턴 경로를 발견
		if(depth == N) {
			found = true;
			return;
		}
		
		for(int next : graph.get(current)) {
			if(!visited[next]) {
				visited[next] = true;
				path.add(next);
				dfs(next, depth + 1);
				
				// 백트래킹
				if(!found) {
					visited[next] = false;
					path.remove(path.size() - 1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("해밀턴 경로");
		// 1. 입력 데이터를 출력
		// 2a. 해밀턴 경로가 있으면 yes / 경로를 출력하고 / 종료
		// 2b. 없으면 no / 종료
		// N, int[][] edges
		
		solve(5, new int[][] { {0, 1}, {1, 2}, {2, 3}, {3, 4} });
		solve(4, new int[][] { {0, 1}, {2, 3} });
	}
}
