package com.DP.BFS.swea1249_보급로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// BFS는 전부해보는게 아니라 최단인 것만 가기때문에 빠르다,,!
// 가중치가 있으니까 다익스트라!!
public class Solution {
    static int N;
    static int [][] map;
    static int [][] time;   // 누적시간
    static int [] dr = {0,1,0,-1};
    static int [] dc = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            time = new int[N][N];
            for (int r = 0; r < N; r++) {
                String str = br.readLine();
                for (int c = 0; c < N; c++) {
                    map[r][c] = str.charAt(c)-'0';
                    time[r][c] = Integer.MAX_VALUE;
                }
            }
            bfs(new int[]{0,0});

            System.out.println("#"+t+" "+time[N-1][N-1]);
            //print();
        }

        br.close();
    }

    private static void bfs(int[] v) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        time[0][0] = map[0][0];

        while (!queue.isEmpty()){
            v = queue.poll();
            int r = v[0];
            int c = v[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr<0||nc<0||nr>=N||nc>=N) continue;

                if(time[nr][nc] > time[r][c]+map[nr][nc]){
                    time[nr][nc] = time[r][c]+map[nr][nc];
                    queue.add(new int[]{nr,nc});
                }
            }
        }
    }

    private static void print() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(time[r][c]+" ");
            }
            System.out.println();
        }
    }
}
/*
1
4
0100
1110
1011
1010
 */