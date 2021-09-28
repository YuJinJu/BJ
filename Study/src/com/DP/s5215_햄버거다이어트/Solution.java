package com.DP.s5215_햄버거다이어트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT&

// 0/1Knapsack 으로 풀 수 있는 문제
//민기의 햄버거 재료에 대한 점수와 가게에서 제공하는 재료에 대한 칼로리가 주어졌을 때,
// 정해진 칼로리 이하의 조합 중에서 민기가 가장 선호하는 햄버거를 조합
//햄버거의 선호도는 조합된 재료들의 맛에 대한 점수의 합으로 결정되고, 같은 재료를 여러 번 사용할 수 없으며, 제한된 칼로리만 사용 가능
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   // 음식 개수
            int L = Integer.parseInt(st.nextToken());   // 제한된 칼로리

            // 음식을 index로 구분하고 점수와 칼로리 저장
            int [] score = new int[N+1];
            int [] kcal = new int[N+1];

            for (int n = 1; n <= N; n++) {
                st = new StringTokenizer(br.readLine());
                score[n] = Integer.parseInt(st.nextToken());
                kcal[n] = Integer.parseInt(st.nextToken());
            }

            int [][] burger = new int[N+1][L+1];
            for (int n = 1; n <= N ; n++) {
                for (int l = 1; l <= L; l++) {
                    if(kcal[n] <= l){   // 해당 음식이 남은 칼로리 이내일 때
                        burger[n][l] = Math.max(burger[n-1][l],score[n]+burger[n-1][l-kcal[n]]);
                    }else{
                        burger[n][l] = burger[n-1][l];
                    }
                }
            }

            System.out.println("#"+t+" "+burger[N][L]);
        }
        br.close();
    }
}
/*
1
5 1000
100 200
300 500
250 300
500 1000
400 400
 */ //750