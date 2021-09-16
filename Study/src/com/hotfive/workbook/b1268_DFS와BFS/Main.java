package com.hotfive.workbook.b1268_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://minhamina.tistory.com/36
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());   //정점개수
        int M = Integer.parseInt(st.nextToken());   //간선갯수
        int V = Integer.parseInt(st.nextToken());   //탐색을 시작할 정점의 번호

        // 방문여부체크 배열
        boolean [] visisted = new boolean[N+1];

        // 인접리스트 생성
        LinkedList<Integer>[] adjlist = new LinkedList[N+1];
        for (int n = 0; n <= N; n++) {
            adjlist[n] = new LinkedList<>();
        }

        // 양방향 간선 연결
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adjlist[v1].add(v2);
            adjlist[v2].add(v1);
        }

        // 방문 순서를 위해 오름차순 정렬
        for (int n = 1; n <=N; n++) {
            Collections.sort(adjlist[n]);
        }

        // BFS 실행
        dfs(V, adjlist, visisted);
        visisted = new boolean[N+1];
        System.out.println();
        bfs(V, adjlist, visisted);

        br.close();
    }

    private static void dfs(int v, LinkedList<Integer>[] adjlist, boolean[] visisted) {
        visisted[v] = true;
        System.out.print(v + " ");

        for (int n : adjlist[v]) {
            if (visisted[n]) continue;
            dfs(n,adjlist,visisted);
        }
    }

    public static void bfs(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[v]= true;
        queue.add(v);

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