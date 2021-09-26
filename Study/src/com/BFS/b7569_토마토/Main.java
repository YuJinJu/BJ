package com.BFS.b7569_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] box;
    static int[][][] date;
    static int C;
    static int R;
    static int H;
    static Queue<int[]> queue = new LinkedList<>();
    static int tomato;
    // 우하좌상위아래
    static int[] dr = {0, -1, 0, 1, 0, 0};
    static int[] dc = {1, 0, -1, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken()); //5
        R = Integer.parseInt(st.nextToken()); //3*H=6
        H = Integer.parseInt(st.nextToken()); //2

        box = new int[R][C][H];
        date = new int[R][C][H];
        tomato = 0;
        for (int h = 0; h < H; h++) {
            for (int r = 0; r < R; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < C; c++) {
                    box[r][c][h] = Integer.parseInt(st.nextToken());
                    if (box[r][c][h] == 0) tomato++;    // 익어야할 토마토 갯수
                    else if(box[r][c][h]==1) queue.add(new int[]{r, c, h}); // 익어져있는 토마토부터 BFS 돌면 되기 때문에 큐에 넣어준다
                }
            }
        }
        if (tomato==0) System.out.println(0);

        bfs();
        if (tomato != 0) System.out.println(-1);

        br.close();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] v = queue.poll();

            for (int d = 0; d < 6; d++) {
                int nr = v[0] + dr[d];
                int nc = v[1] + dc[d];
                int nh = v[2] + dh[d];

                if (nr < 0 || nc < 0 || nh < 0 || nr >= R || nc >= C || nh >= H || box[nr][nc][nh] != 0) continue;

                box[nr][nc][nh] = 1;
                date[nr][nc][nh] = date[v[0]][v[1]][v[2]] + 1;
                queue.add(new int[]{nr,nc,nh});
                tomato--;
                if(tomato==0){
                    System.out.println(date[nr][nc][nh]);
                    return;
                }

                // print test
//                for (int h = 0; h < H; h++) {
//                    for (int r = 0; r < R; r++) {
//                        for (int c = 0; c < C; c++) {
//                            System.out.print(date[r][c][h] + " ");
//                        }
//                        System.out.println();
//                    }
//                }
//                System.out.println("-----------------");

            }


        }
    }
}
/*
출력
-1
4
0
 */