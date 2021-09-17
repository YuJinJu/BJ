package com.hotfive.workbook.b2606_바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_DFS {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 컴퓨터 수 <= 100
        int M = Integer.parseInt(br.readLine());    //간선 수

        boolean [] visited = new boolean[N+1];

        StringTokenizer st = null;
        LinkedList<Integer>[] adjlist = new LinkedList[N+1];

        for (int n = 1; n <= N; n++) {
            adjlist[n] = new LinkedList<>();
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            adjlist[v1].add(v2);
            adjlist[v2].add(v1);
        }

        int V = 1; // 1번부터시작
        count = 0;
        dfs(V,adjlist,visited);

        System.out.println(count-1);
        br.close();
    }

    private static void dfs(int v, LinkedList<Integer>[] adjlist, boolean[] visited) {
       visited[v] = true;
       count++;

        for (int n : adjlist[v]) {
            if(visited[n]) continue;
            visited[n] = true;
            dfs(n,adjlist,visited);
        }
    }
}
