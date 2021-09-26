package com.DFS_BFS.b2667_단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_DFS {
    static int N;
    static int [][] map;
    static boolean [][] visisted;
    static ArrayList<Integer> dangi = new ArrayList<>();
    static int homeCnt;
    // 우 하 좌 상
    static int [] dr = {0,-1,0,1};
    static int [] dc = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }

        visisted = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visisted[i][j]||map[i][j]==0) continue;
                // 집을 발견할 때..
                homeCnt = 0;
                dfs(new int []{i,j});   // dfs 탐색 시작
                dangi.add(homeCnt);
            }
        }

        System.out.println(dangi.size());
        Collections.sort(dangi);
        for (int i: dangi) {
            System.out.println(i);
        }
        br.close();
        //첫 번째 줄에는 총 단지수를 출력하시오.
        // 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오
    }

    private static void dfs(int[] v) {
        visisted[v[0]][v[1]] = true;
        homeCnt++;

        for (int d = 0; d < 4; d++) {
            int nr = v[0] + dr[d];
            int nc = v[1] + dc[d];

            if(nr<0||nc<0||nr>=N||nc>=N||visisted[nr][nc]||map[nr][nc]==0) continue;
            dfs(new int[]{nr,nc});
        }


    }
}
