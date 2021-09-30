package com.BFS.swea1953_탈주범검거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//탈주범이 위치할 수 있는 장소의 개수
public class Solution {
    static int [][] map;
    static int [][] visit;
    static int N;   //R
    static int M;   //C
    static int L;
    static int time;
    static int cnt;
    //우 하 좌 상
    static int [] dr = {0,1,0,-1};
    static int [] dc = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   // 행크기
            M = Integer.parseInt(st.nextToken());   // 열크기
            map = new int[N][M];
            visit = new int[N][M];

            int R = Integer.parseInt(st.nextToken());   //맨홀뚜껑위치 R,C    // 시작점
            int C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());   //탈출 후 소요된 시간 L

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < M; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            time=0;
            cnt =0;
            bfs(new int[]{R,C});   // L이 0이 아닐때 실행
            //print();
            //맨홀뚜껑이 위치한 지점을 포함, L시간 안에 갈수있는 장소개수
            System.out.println("#"+t+" "+cnt);
        }
        br.close();
    }

    private static void bfs(int[] v) {
        int r = v[0];
        int c = v[1];
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{r,c});
        visit[r][c] = ++time;
        cnt++;

        while (!queue.isEmpty()){

            v = queue.poll();
            r = v[0];
            c = v[1];

            for (int d = 0; d < 4; d++) {   // 0우 1하 2좌 3상
                int nr = r + dr[d];
                int nc = c + dc[d];
                // 전에가 상하일때 다음이 하가 있어야해
                // 못가는 경우들들
                if(nr<0||nc<0||nr>=N||nc>=M||map[nr][nc]==0||visit[nr][nc]!=0) continue;
                else if(map[r][c]==0) continue;
                else if(map[r][c]==2 && (d==0||d==2)) continue; // 상하 31
                else if(map[r][c]==3 && (d==3||d==1)) continue; // 좌우 20
                else if(map[r][c]==4 && (d==1||d==2)) continue; // 상우 30
                else if(map[r][c]==5 && (d==2||d==3)) continue; // 하우 10
                else if(map[r][c]==6 && (d==0||d==3)) continue; // 하좌 12
                else if(map[r][c]==7 && (d==0||d==1)) continue; // 상좌 32

                int y = map[nr][nc];
                if(d==3 && (y==3||y==4||y==7)) continue; //상이면 하가있어야지 .. 하가없는거 넘겨버리기
                else if(d==0 && (y==2||y==4||y==5)) continue;
                else if(d==1 && (y==3||y==5||y==6)) continue;
                else if(d==2 && (y==2||y==6||y==7)) continue;

                visit[nr][nc] = visit[r][c]+1;
                time = visit[nr][nc];
                queue.add(new int[]{nr,nc});
                if(L<time)  return;
                cnt++;
            }

        }

    }

    private static void print() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                System.out.print(visit[r][c]+" ");
            }
            System.out.println();
        }
    }
}
