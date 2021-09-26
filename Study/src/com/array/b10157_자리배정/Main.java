package com.array.b10157_자리배정;

import java.io.*;
import java.util.StringTokenizer;

//(1,1)위치 좌석부터 시작하여 시계방향
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        //하 우 상 좌
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        int[][] map = new int[R][C];
        int num = 1;
        int r = -1;
        int c = 0;

        if (K > R * C) {
            bw.append(0 + " ");
            bw.close();
            System.exit(0);
        }

        int d = 0;
        while (num <= K) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] != 0) {
                d = (d + 1) % 4;
                continue;
            }
            r = nr;
            c = nc;
            if (num == K) {
                bw.append((c+1) + " " + (r+1));
                bw.close();
                System.exit(0);
            }

            map[nr][nc] = num++;
        }

    }
}
