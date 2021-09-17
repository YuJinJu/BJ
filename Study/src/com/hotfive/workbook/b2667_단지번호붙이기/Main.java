package com.hotfive.workbook.b2667_단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int [][] map;
    static ArrayList<Integer> apart = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int n = 0; n < N; n++) {
            int c = 0;
            map[n][c] = br.readLine().charAt(c++)-'0';

        }

        boolean [][] visited = new boolean[N][N];

        // 총 단지 수
        int total=0;

        // 지도 전체 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]==1 && !visited[i][j]){

                    bfs(new int[] {i,j},visited);
                    visited[i][j] =true;
                    total++;
                }
            }
        }

        System.out.println(total);
        Collections.sort(apart);
        for ( int a=0; a<apart.size(); a++) {
            System.out.print(apart.get(a));
        }

        br.close();
    }

    static int [] dr = {0,-1,0,1};
    static int [] dc = {1,0,-1,0};
    private static void bfs(int[] v, boolean[][] visited) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(v);
        int count = 1;
        while (!queue.isEmpty()){
            v = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = v[0] + dr[d];
                int nc = v[1] + dc[d];
                if(nr<0 || nc <0 || nr>=N || nc>=N || visited[nr][nc]) continue;

                queue.add(new int[] {nr,nc});
                visited[nr][nc] = true;
                count++;
            }
        }
        apart.add(count);
    }
}
