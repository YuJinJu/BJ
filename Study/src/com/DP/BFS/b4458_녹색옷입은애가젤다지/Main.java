package com.DP.BFS.b4458_녹색옷입은애가젤다지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://namhandong.tistory.com/212
// 검정루피는 감소
// 주인공(링크) 위치 (0,0),, 오해받는 공주(젤다)
// 링크는 (n-1,n-1)까지 이동해야함.. 한번에 상하좌우 1칸씩만 이동가능
// 도둑루피를 최대한 적은금액으로 받게끔 이동해야한다. 링크가 잃을 수밖에 없는 최소금액은 얼마일까
public class Main {
    static int N;
    static int[][] map;
    static int[][] coin;
    static int[] dr = {0, 1, 0, -1}; // 우 하 좌 상
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int tc = 0;
        while (true) {   // 0입력할때까지 테케반복
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            map = new int[N][N];   //2 ≤ N ≤ 125
            coin = new int[N][N];   // 누적되는 검정루피

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());   //0 이상 9 이하인 한 자리 수
                    coin[r][c] = Integer.MAX_VALUE;
                }
            }

            bfs();
            System.out.println("Problem " + (++tc) + ": " + coin[N - 1][N - 1]);

        }

        br.close();
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        coin[0][0] = map[0][0];

        while (!queue.isEmpty()) {
            int[] v = queue.poll();
            int r = v[0];
            int c = v[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;   //..

                if (coin[nr][nc] > coin[r][c] + map[nr][nc]) {
                    coin[nr][nc] = coin[r][c] + map[nr][nc];
                    queue.add(new int[]{nr, nc});
                }
            }
            //print();
        }
    }


//    private static void print() {
//        for (int r = 0; r < N; r++) {
//            for (int c = 0; c < N; c++) {
//                System.out.print(coin[r][c] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("----------");
//    }
}
// p1 : 5 3 3 2 7
// p2 : 3 2 1 2 1 0 2 0 1 1 1 0 5