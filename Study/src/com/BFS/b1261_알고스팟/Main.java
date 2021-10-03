package com.BFS.b1261_알고스팟;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//(1, 1)에 있는 알고스팟 운영진이 (N, M)으로 이동하려면 벽을 최소 몇 개 부수어야 하는지
public class Main {
    static int N;
    static int M;
    // 우 하 좌 상
    static int [] dr = {0,1,0,-1};
    static int [] dc = {1,0,-1,0};
    static int [][] map;
    static int [][] min;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());   // 가로 열
        N = Integer.parseInt(st.nextToken());   //  세로 행
        map = new int[N+1][M+1];
        min = new int[N+1][M+1];
        count = 0;
        for (int r = 1; r <= N; r++) {
            String str = br.readLine();
            for (int c = 1; c <= M; c++) {
                map[r][c] = str.charAt(c-1)-'0';    // 0 빈방, 1 벽
                if(r+c!=2) min[r][c] = Integer.MAX_VALUE;
            }
        }
        System.out.println(bfs());
        br.close();
    }

    private static void print() {
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                System.out.print(min[r][c]+" ");
            }
            System.out.println();
        }
    }

    private static int bfs() {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{1,1});

        while (!queue.isEmpty()){
            int [] v = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = v[0] + dr[d];
                int nc = v[1] + dc[d];

                if(nr<1||nc<1||nr>N||nc>M)  continue;

                if(min[nr][nc] > min[v[0]][v[1]] + map[nr][nc]) {
                    min[nr][nc] = min[v[0]][v[1]] + map[nr][nc];
                    queue.add(new int[]{nr,nc});
                }
               // print();
            }
        }
        return min[N][M];
    }
}
