package com.DP.b12865_평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 0/1 Knapsack
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());   // 가방에 넣을 수 있는 무게

        // 물건 정보
        int [] W =new int[N+1];
        int [] V =new int[N+1];
        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            W[n] = Integer.parseInt(st.nextToken());
            V[n] = Integer.parseInt(st.nextToken());
        }

        int [][] DP = new int[N+1][K+1];
        //배낭에 넣을 수 있는 물건들의 가치합의 최댓값
        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= K ; w++) {
                if(W[n]<= w){
                    DP[n][w] = Math.max(V[n]+DP[n-1][w-W[n]], DP[n-1][w]);
                }else {
                    DP[n][w] = DP[n-1][w];
                }
            }
        }
        System.out.println(DP[N][K]);
        br.close();
    }
}
