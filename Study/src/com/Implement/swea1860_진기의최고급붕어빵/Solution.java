package com.Implement.swea1860_진기의최고급붕어빵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   //손님 수
            int M = Integer.parseInt(st.nextToken());   //요리하는 시간
            int K = Integer.parseInt(st.nextToken());   //만드는 붕어빵 수


            int [] people = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                people[n] = Integer.parseInt(st.nextToken());
            }

            String result = check(N,M,K,people);

            //모든 손님에 대해 기다리는 시간이 없이 붕어빵을 제공할 수 있으면 “Possible”을, 아니라면 “Impossible”을 출력한다.


            sb.append("#" + t + " " + result + "\n");
        }
        System.out.println(sb);
        br.close();
    }

    // M초 동안 K개 만들수있음
    private static String check(int N, int M, int K, int[] people) {
        for (int n = 0; n < N; n++) {
            for (int k = 1; k <= K; k++) {
                if(k*M > people[n]) return "Impossible";
            }
        }
        return "Possible";
    }
}
