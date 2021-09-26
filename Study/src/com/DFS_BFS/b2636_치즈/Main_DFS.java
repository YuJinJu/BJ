package com.DFS_BFS.b2636_치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_DFS {

    static int R,C;
    static int[][] cheese;//입력값: 0(공기,구멍),1(치즈)  개발자정의:  2(가장자리 녹을치즈), -1(방문체크)
    static int last=0;
    static int[]dy = {-1,1,0,0};
    static int[]dx = {0,0,-1,1};//상하좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());//행
        C = Integer.parseInt(st.nextToken());//열

        cheese = new int[R][C];
        for (int i =0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j =0; j<C; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }//치즈 정보 입력

        int hour = 0;//녹는 시간

        do {//한시간 사이클
            hour++;
            airPlus(0,0);//dfs
        }while(cheeseCheck());//1. 녹을 수 있는 치즈체크  2. 다음 사이클을 위한 녹은 체크(2-->0)와 시작점(-1 --> 0)을 초기화

        System.out.println(hour-1);
        System.out.println(last);
    }

    public static void airPlus(int r, int c) {
        int nr, nc;
        cheese[r][c] = -1; //공기에서 dfs시작점, 방문체크

        for (int d =0; d<4; d++) {//사방탐색
            nr = r + dy[d];
            nc = c + dx[d];

            if (nr>=0 &&nr<R && nc>=0 && nc<C) {//배열 범위 체크
                if (cheese[nr][nc] == 1) {//치즈를 만났다면
                    cheese[nr][nc] = 2; //가장자리의 치즈 체크
                }else if (cheese[nr][nc]==0) {//(바깥)공기를 만났다면
                    System.out.println(nr+","+nc);
                    airPlus(nr, nc);
                }
            }
        }
    }//airPlus

    public static boolean cheeseCheck() {
        int count = 0;
        for (int i=0; i<R; i++) {
            for (int j =0; j<C; j++) {
                if (cheese[i][j] ==-1) cheese[i][j] = 0; //공기면 공기 초기화
                else if (cheese[i][j] ==2) { //녹을 치즈면
                    cheese[i][j] = 0;   //녹이자 (초기화)
                    count++;
                }
            }
        }//for end
        if (count ==0) return false;// 녹을 치즈 없음
        else {
            last = count; //녹은 치즈 카운트
            return true;
        }
    }//cheeseCheck
}
/*
13 12
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 1 0 0 0
0 1 1 1 0 0 0 1 1 0 0 0
0 1 1 1 1 1 1 0 0 0 0 0
0 1 1 1 1 1 0 1 1 0 0 0
0 1 1 1 1 0 0 1 1 0 0 0
0 0 1 1 0 0 0 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0

*/