package com.hotfive.workbook.b2178_미로탐색;

import jdk.nashorn.internal.ir.Symbol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static int [][] map;
    static boolean [][] visited;
    static int [] dr = {0,-1,0,1};
    static int [] dc = {1,0,-1,0};
    static int count = 0;
    static ArrayList<Integer> cntList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
        // (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램
        //서로 인접한 칸으로만 이동 가능
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R+1][C+1];
        for (int r = 1; r <= R; r++) {
            String str = br.readLine();
            for (int c = 1; c <= C; c++) {
                map[r][c] =  str.charAt(c-1)-'0';
            }
        }
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                System.out.print(map[r][c]);
            }
            System.out.println();
        }

        visited = new boolean[R+1][C+1];
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if(visited[r][c] || map[r][c]==0) continue;
                dfs(new int [] {r,c});

                count = 0;
            }
        }
        Collections.sort(cntList);
        System.out.println(cntList.get(0));
        br.close();
    }

    private static void dfs(int[] v) {
        visited[v[0]][v[1]] = true;
        count++;

        for (int d = 0; d < 4; d++) {
            int nr = v[0] + dr[d];
            int nc = v[1] + dc[d];

            if(nr<=0 || nc<=0 || nr > R || nc > C || visited[nr][nc] || map[nr][nc] == 0) continue;
            if(nr==R && nc == C){
                cntList.add(count);
                return;
            }
            System.out.println(nr+" "+nc);
            dfs(new int[]{nr,nc});
        }
    }
}
