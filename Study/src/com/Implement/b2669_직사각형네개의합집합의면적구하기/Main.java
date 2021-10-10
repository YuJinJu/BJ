package com.Implement.b2669_직사각형네개의합집합의면적구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//오른쪽으로 돌리면 x -> 행, y-> 열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;
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

            if(minR > sr) minR = sr;
            if(minC > sc) minC = sc;
            if(maxR < er) maxR = er;
            if(maxC < ec) maxC = ec;
        }

        int result = 0;
        for(int r = minR; r<maxR; r++){
            for(int c = minC; c<maxC; c++){
                if(map[r][c] == 1) result++;
            }
        }
        System.out.println(result);
        br.close();
    }
}
