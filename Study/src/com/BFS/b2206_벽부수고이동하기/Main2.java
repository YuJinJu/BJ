package com.BFS.b2206_벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// min 배열을 만들지 않고 큐에 같이 담아서 증가시키는 코드
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][]map = new int[N][M];

        String str;
        for (int r = 0; r < N; r++) {
            str = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = str.charAt(c)-'0';
            }
        }

        System.out.println(bfs(map,N,M));

        br.close();
    }


    private static int bfs(int [][] map,int N, int M) {
        int [] dr = {0,1,0,-1};
        int [] dc = {1,0,-1,0};
        Queue<int []> queue = new LinkedList<>();
        boolean [][][] visited = new boolean[N][M][2];

        queue.add(new int[]{0,0,0,1});
        visited[0][0][0] = true;

        int [] v;
        int nr;
        int nc;
        int crash;
        int min;
        while (!queue.isEmpty()){
            v = queue.poll();
            crash = v[2];
            min = v[3];

            if(v[0]==N-1 && v[1]==M-1)  return min;

            for (int d = 0; d < 4; d++) {
                nr = v[0] + dr[d];
                nc = v[1] + dc[d];

                if(nr<0||nc<0||nr>=N||nc>=M)  continue;

                if(map[nr][nc]==1 && !visited[nr][nc][1] && crash==0) {
                    visited[nr][nc][1] = true;
                    queue.add(new int[]{nr, nc, 1,min+1});
                }

                if(map[nr][nc]==0 && !visited[nr][nc][crash]){
                    visited[nr][nc][crash]= true;
                    queue.add(new int[]{nr,nc,crash,min+1});
                }
            }

        }

        return -1;
    }

}
/*
8 8
01000100
01010100
01010100
01010100
01010100
01010100
01010100
00010100
 */