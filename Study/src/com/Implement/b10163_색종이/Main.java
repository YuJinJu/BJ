package com.Implement.b10163_색종이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배열이 거꾸로 되어있지만 색종이 면적만 구하기 때문에 거꾸로는 신경쓰지 않아도 된다. -- > 뒤집어서 생각!!
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int map [][] = new int [1001][1001];

        int color = 1;
        for(int n = 0; n < N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for(int i = 0; i < w; i++){
                for(int j = 0; j < h; j++){
                    map[x+i][y+j] = color;
                }
            }
            color++;
        }

        for(int k = 1; k <= N; k++){
            int cnt = 0;
            for (int [] i : map){
                for(int j : i){

                    if(j == k){
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
        br.close();
    }
}
