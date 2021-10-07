package com.BFS.b2206_벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1,1 ~ N,M 까지 가는길의 총합이 1이거나 0일때 "최단거리"
public class Main {
    static int N;
    static int M;
    // 우 하 좌 상
    static int [] dr = {0,1,0,-1};
    static int [] dc = {1,0,-1,0};
    static int [][] map;
    static int [][] min;
    static boolean [][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   //  행
        M = Integer.parseInt(st.nextToken());   // 열
        map = new int[N+1][M+1];
        min = new int[N+1][M+1];    // 해당 좌표까지 가기 위해 이동한 거리를 저장
        visited = new boolean[N+1][M+1][2]; // r,c,0 : 벽없을때 / r,c,1 : 벽있을때

        // 입력
        String str;
        for (int r = 1; r <= N; r++) {
            str = br.readLine();
            for (int c = 1; c <= M; c++) {
                map[r][c] = str.charAt(c-1)-'0';    // 0 빈방, 1 벽
            }
        }

        System.out.println(bfs(new int[]{1,1}));

        //print();
        br.close();
    }


    private static int bfs(int [] v) {

        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{v[0],v[1],0,1});    // {r,c,지금까지 벽을 부셨던적이 있는지 없는지 정보를 담기 위함(부셨으면 1 안부셨으면 0)}
                                        // 벽부신적있는지의유무를 매번 갖고 다녀야함!!! 그래야 다음 경로를 갈수있는지 없는지 판단할수있기때문
        min[v[0]][v[1]]=1;
        visited[v[0]][v[1]][0] = true;

        int nr;
        int nc;
        while (!queue.isEmpty()){
            v = queue.poll();
            int crash = v[2];

            // 제일 처음에 N,M에 도착한경우가 최단거리이므로 N,M에 도착했을때 리턴해주기
            if(v[0]==N && v[1]==M)  return min[N][M];

            for (int d = 0; d < 4; d++) {
                nr = v[0] + dr[d];
                nc = v[1] + dc[d];
                if(nr<1||nc<1||nr>N||nc>M)  continue;

                // 벽인데 방문안한곳 (부신적 없는 벽)...... 을 방문하기 위해서는 이전에 벽을 부신적 있으면 안됨
                // visited -> r,c,0 : 벽없을때 방문 확인 / r,c,1 : 벽있을때 방문 확인
                // crash : 벽을 부신 전적유무(이전에 벽을 부신적이 있다면 실행 x)
                if(map[nr][nc]==1 && !visited[nr][nc][1] && crash==0) {
                    visited[nr][nc][1] = true;      // 무조건 벽을 부신경우의 방문이니까 1
                    min[nr][nc] = min[v[0]][v[1]] + 1;    // 이동수 증가
                    queue.add(new int[]{nr, nc, 1});  // 부신걸 체크(1표시)하고 다음 경로 탐색하기위해 큐에 넣어줌.  이때 crash 자체를 1로바꾸면 안된다.
                    // 왜냐면 추후에 여기서 넣은 큐의 탐색이 종료되고 다음 큐를 탐색할때!! 부신걸 다시원래대로(안부셨다고)해야하기 때문에 crash를 1로 바꾸지 않는다
                }

                // 벽을 부셨는지 안부셨는지 상관없이 방문여부만 확인하고 실행
                if(map[nr][nc]==0 && !visited[nr][nc][crash] ){
                    visited[nr][nc][crash]= true; // crash : 벽을 부셨는지 안부셨는지 상관없이 실행되기때문에, 이전에 부셨는지 안부셨는지에 따라 방문표시
                    min[nr][nc] = min[v[0]][v[1]] + 1;
                    queue.add(new int[]{nr,nc,crash});  // 큐에 넣는것도 방문표시와 마찬가지로, 부숨유무를 넣어준다
                }

                //print();
            }
        }

        return -1;  // 위에서 리턴하지 못하는 경우는 N,M에 도착하지 못하는 경우
    }

    private static void print() {
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                System.out.print(min[r][c]+" ");
            }
            System.out.println();
        }
        System.out.println("----------");
    }

}
/*
5 5
00000
11101
00001
01111
00010
 */

