package com.testex.t0830_IM.b2669_직사각형네개의합집합의면적구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//min,max 안했을 때
//오른쪽으로 돌리면 x -> 행, y-> 열
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [][] map = new int[101][101];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());

            for (int r = sr; r < er ; r++) {
                for (int c = sc; c < ec; c++) {
                    if(map[r][c]!=1) map[r][c] = 1;
                }
            }
        }

        int result = 0;
        for(int r = 0; r<100; r++){
            for(int c = 0; c<100; c++){
                if(map[r][c] == 1) result++;
            }
        }
        System.out.println(result);
        br.close();
    }
}
