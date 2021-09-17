package com.hotfive.workbook.DFS_BFS.b1012_유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int [][] map;
    static boolean [][] visited;
    static int [] dr = {0,-1,0,1};
    static int [] dc = {1,0,-1,0};
    static int C;
    static int R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());   //가로길이 1 ≤ M ≤ 50
            R = Integer.parseInt(st.nextToken());   //세로길이 1 ≤ N ≤ 50
            int K = Integer.parseInt(st.nextToken());   //배추 개수 1 ≤ K ≤ 2500

            // 밭 그리기
            map = new int[R][C];
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken()); // 0 ≤ X ≤ M-1
                int r = Integer.parseInt(st.nextToken()); // 0 ≤ Y ≤ N-1
                map[r][c] = 1;  //배추위치 x,y
            }

            int count = 0; // 에벌레 수
            visited = new boolean[R][C];
            // 상하좌우에 배추가 있으면 한 묶음
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(visited[i][j] || map[i][j]==0) continue;
                    bfs(new int [] {i,j});
                    count++;
                }
            }
            System.out.println(count);
        }
        br.close();
    }

    private static void bfs(int[] v) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(v);
        visited[v[0]][v[1]] = true;

        while (!queue.isEmpty()){
            v = queue.poll();

            // 사방탐색
            for (int d = 0; d < 4; d++) {
                int nr = v[0] + dr[d];
                int nc = v[1] + dc[d];

                if(nr<0||nc<0||nr>=R||nc>=C||visited[nr][nc]||map[nr][nc]==0) continue;

                visited[nr][nc] = true;
                queue.add(new int[] {nr,nc});
            }
        }
    }
}
