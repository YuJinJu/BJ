package com.DP.b1003_피보나치함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[][] fibo = new int[n + 1][2];  //[][0], [][1]개수 누적

            fibo[0][0] = 1;
            fibo[0][1] = 0;

            if (n >= 1) {
                fibo[1][0] = 0;
                fibo[1][1] = 1;
            }
            // fibo[2][0] = fibo[1][0] + fibo[0][0]
            // fibo[2][1] = fibo[1][1] + fibo[0][1]

            for (int i = 2; i <= n; i++) {
                fibo[i][0] = fibo[i - 2][0] + fibo[i - 1][0];
                fibo[i][1] = fibo[i - 2][1] + fibo[i - 1][1];
            }

            // 0, 1 의 호출횟수 출력
            System.out.println(fibo[n][0] + " " + fibo[n][1]);
        }

        br.close();
    }
}
