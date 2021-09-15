package com.hotfive.workbook.b16439_치킨치킨치킨;

/*
N명의 고리 회원들은 치킨을 주문하고자 합니다.
치킨은 총 M가지 종류가 있고 회원마다 특정 치킨의 선호도가 있습니다.
한 사람의 만족도는 시킨 치킨 중에서 선호도가 가장 큰 값으로 결정됩니다.
진수는 회원들의 만족도의 합이 최대가 되도록 치킨을 주문하고자 합니다.
시키는 치킨의 종류가 많아질수록 치킨을 튀기는 데에 걸리는 시간도 길어지기 때문에 최대 세 가지 종류의 치킨만 시키고자 합니다.
진수를 도와 가능한 만족도의 합의 최댓값을 구해주세요.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [] chicken;
    static int [] pick;
    static int N;
    static int M;
    static int [][] ck ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 회원 수 // 회원마다 치킨 선호도가 다름 // 만족도의 합이 최대가 되도록 하기
        M = Integer.parseInt(st.nextToken());   //치킨 종류 // 3개만 뽑음

        chicken = new int [M];
        for (int i = 0; i < M; i++) {
            chicken [i] = i;
        }
        ck = new int[N][M];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                ck[n][m]= Integer.parseInt(st.nextToken());
            }
        }

        pick= new int[3];
        combi(0,0);

        System.out.println(sumMax);
    }

    static int sumMax = Integer.MIN_VALUE;
    private static void combi(int cnt, int start) {

        if(cnt == 3){
            int sum = 0;
            for (int n = 0; n < N; n++) { // 사람
                int max = -1;

                for (int i : pick) { // 고른 치킨 // 조합.. 3가지를 뽑을 수 있는 경우.. 에서 최대값을 모두 더한 값들 중 최대값 구하기
//                    System.out.print(i + " ");

                    if(max < ck[n][i]) {
                        max = ck[n][i];

                    }
                }
                sum += max;
                // 다음 경우의 수
//                System.out.println();

                sumMax = Math.max(sum, sumMax);
            }
            return;
        }
        for (int i = start; i < M; i++) {
            pick[cnt] = chicken[i];
            combi(cnt+1, i+1);
        }
    }

}
