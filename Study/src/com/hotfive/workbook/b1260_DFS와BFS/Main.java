package com.hotfive.workbook.b1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//https://www.acmicpc.net/problem/1260

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());   //정점개수
        int M = Integer.parseInt(st.nextToken());   //간선갯수
        int V = Integer.parseInt(st.nextToken());   //탐색을 시작할 정점의 번호

        //방문체크 배열
        boolean [] visited = new boolean[N+1];

        // 정점마다 연결해 줄 인접리스트 배열생성
        LinkedList<Integer>[] adjlist = new LinkedList[N+1];
        for (int n = 1; n <= N; n++) {
            adjlist[n] = new LinkedList<>(); // 해당 정점에 연결된 정점들이 담겨있는 리스트
        }

        // 정점 연결 // 무방향 간선 연결
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());  // 연결할 정점 v1, v2
            int v2 = Integer.parseInt(st.nextToken());
            adjlist[v1].add(v2);
            adjlist[v2].add(v1);
        }

        // 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하기 위해 오름차순 정렬
        for (int n = 1; n <=N; n++) {
            Collections.sort(adjlist[n]);
        }

        // DFS, BFS 실행
        dfs(V, adjlist, visited);
        visited = new boolean[N+1];
        System.out.println();
        bfs(V, adjlist, visited);

        br.close();
    }

    private static void dfs(int v, LinkedList<Integer>[] adjlist, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int n : adjlist[v]) {
            if (visited[n]) continue;
            dfs(n,adjlist,visited);
        }
    }

    public static void bfs(int v, LinkedList<Integer>[] adjList, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v]= true;

        while (!queue.isEmpty()){
            v = queue.poll();
            System.out.print(v + " ");

            for (int n : adjList[v]) {
                if(visited[n]) continue;
                visited[n] = true;
                queue.add(n);
            }
        }
    }
}
/*
4 5 1
1 2
1 3
1 4
2 4
3 4
 */