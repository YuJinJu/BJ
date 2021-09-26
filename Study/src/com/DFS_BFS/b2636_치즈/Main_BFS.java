package com.DFS_BFS.b2636_치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS
public class Main_BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        int cnt = 0;
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken()); //치즈가 없는 칸은 0, 치즈가 있는 칸은 1
                if(map[r][c]==1) cnt++;
            }
        }

        int circle = 0; //치즈가 모두 녹아 없어지는 데 걸리는 시간
        int solCnt = 0; //모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸의 개수

        // 우 하 좌 상
        int[] dr = {0, -1, 0, 1};
        int[] dc = {1, 0, -1, 0};

        while (cnt != 0){ //치즈 개수가 0이 될때 까지 bfs를 반복
            circle++;
            solCnt = cnt;

            Queue <int[]> q = new LinkedList<>();   // BFS 사용 // 치즈가 없는 좌표를 넣어줄것임
            q.add(new int[] {0,0});     //BFS 시작

            boolean [][] visit = new boolean[R][C];
            visit[0][0] = true;         //방문 처리

            while (!q.isEmpty()){ // 자식 탐색 후 부모로
                int [] current  = q.poll(); // r, c 가져오기
                for (int d = 0; d < 4; d++) {
                    int nr = current[0] + dr[d];
                    int nc = current[1] + dc[d];
                    if(nr<0 || nc<0 || nr>=R || nc>=C || visit[nr][nc]) continue;

                    if(map[nr][nc]==1){     // 치즈가 있으면
                        map[nr][nc] = 0;    // 치즈를 없애고
                        cnt--;              // 치즈의 갯수를 감소시킨다
                    }
                    else if(map[nr][nc]==0){   //치즈가 없으면
                        q.add(new int[] {nr,nc});   // 큐에 좌표를 넣어준다
                        //map[nr][nc] = 2;
                    }

                    visit[nr][nc] = true;   //방문처리

//                    for (int i = 0; i < map.length; i++) {
//                        for (int j = 0; j < map[0].length; j++) {
//                            System.out.print(map[i][j]+" ");
//                        }
//                        System.out.println();
//                    }
//                    System.out.println("----------------------");


                }
            }
        }

        System.out.print( circle + " " + solCnt);

        br.close();
    }
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