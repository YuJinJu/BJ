package com.hotfive.workbook.DFS_BFS.b2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R;
    static int C;
    static int [][] map;
    static int [][] count;
    static boolean [][] visited;
    // 우 하 좌 상
    static int [] dr = {0,1,0,-1};
    static int [] dc = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
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

        count = new int[R+1][C+1];          // count 배열로만 방문여부를 확인할 수 있지만 메모리 초과 발생
        visited = new boolean[R+1][C+1];    // 방문처리해줘서 방문한곳은 탐색하지 않는 방법이 메모리 감소에 효율적
        bfs(new int [] {1,1});

        br.close();
    }

    private static void bfs(int[] v) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(v);
        count[v[0]][v[1]] = 1;    // 방문한곳에 이동수 넣어주기 (첫번째인 1,1좌표)
        visited[v[0]][v[1]] = true;

        while (!queue.isEmpty()){
            v = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = v[0] + dr[d];
                int nc = v[1] + dc[d];

                if(nr<=0 || nc<=0 || nr > R || nc > C || map[nr][nc] == 0 || visited[nr][nc]) continue;
                count[nr][nc] =  count[v[0]][v[1]] + 1; // 방문한곳에 이동 수 넣어주기

                if(nr==R && nc == C){
                    System.out.println(count[nr][nc]);
                    return;
                }

                visited[nr][nc] = true;
                queue.add(new int[] {nr,nc});
                //System.out.println(nr+" "+nc);
            }

        }

    }
}
