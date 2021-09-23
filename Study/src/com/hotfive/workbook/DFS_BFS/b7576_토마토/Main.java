package com.hotfive.workbook.DFS_BFS.b7576_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static int [][] box;
    static Queue<int []> queue = new LinkedList<>();
    static int makeTmt; //익어야할 토마토 개수
    static int date[][];    // 날짜
    //우하좌상
    static int [] dr = {0,-1,0,1};
    static int [] dc = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken()); // 2 ≤ R,C ≤ 1,000 //박스 2칸이상,,
        R = Integer.parseInt(st.nextToken());

        box = new int[R][C];
        makeTmt = 0;
        date = new int[R][C];   // 날짜 지날 때마다 저장
        ArrayList<int[]> tomato = new ArrayList<>();
        //정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                box[r][c] = Integer.parseInt(st.nextToken());
                if(box[r][c]==0) makeTmt++; // 익어야할 토마토 개수
                if(box[r][c]==1) {
                    queue.add(new int[]{r,c});    //미리 익어있는 토마토를 큐에 넣어 bfs 하기 위한 준비
                }
            }
        }

        //익을 토마토가 없으면 종료
        if(makeTmt == 0) {
            System.out.println(0);
        }

        bfs();

        // bfs 해서 토마토를 익혔지만 전부 익게 만들 수 없을 때
        if(makeTmt > 0) {
            System.out.println(-1);
        }

        br.close();
    }

    private static void bfs() {

        while (!queue.isEmpty()){
            int v [] = queue.poll();

            // 4방탐색으로 인접한 토마토 찾기
            for (int d = 0; d < 4; d++) {
                int nr = v[0] + dr[d];
                int nc = v[1] + dc[d];

                if(nr<0||nc<0||nr>=R||nc>=C||box[nr][nc]!=0) continue;

                // 인접한 곳에 안 익은 토마토가 있을 때, 익게하기
                queue.add(new int[] {nr,nc});
                box[nr][nc] = 1;
                date[nr][nc] = date[v[0]][v[1]] + 1;

                if(--makeTmt == 0){
                    System.out.println(date[nr][nc]);
                    return;
                }

//                // box print test
//                for (int r = 0; r < R; r++) {
//                    for (int c = 0; c < C; c++) {
//                        System.out.print(date[r][c]+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println("-----------");

            }
        }
    }
}
