package com.CT.b11050_이항계수1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 파스칼의 삼각형 규칙 이용
        // nCk = n-1 C k + n-1 C k-1
        int [][] pascal = new int[N+1][K+1];
        //pascal[0][0] = 1; // 안뽑는것도 하나의 경우의 수
        for (int n = 0; n <= N ; n++) {
            for (int k = 0; k <= K; k++) {
                if(k==n||k==0) pascal[n][k] = 1;  // nC0 nCn 은 경우의 수 한개
                else if(n-1>=0) pascal[n][k] = pascal[n-1][k-1] + pascal[n-1][k];
            }
        }
        System.out.print(pascal[N][K]+" ");

        br.close();
    }
}
