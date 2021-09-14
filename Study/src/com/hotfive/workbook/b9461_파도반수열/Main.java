package com.hotfive.workbook.b9461_파도반수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    // 삼각형 갯수가 N개일 때 변의 길이는?

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            long [] p = new long[101];
            p[1] = 1;
            p[2] = 1;
            p[3] = 1;

            for (int i = 4; i <= 100; i++) {
                p[i] = p[i - 3] + p[i - 2];
//                System.out.println("p"+i+":"+p[i]);
            }
            System.out.println(p[N]);
        }
    }
}
