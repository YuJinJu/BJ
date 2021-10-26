package com.Implement.swea2001_파리퇴치;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int [][] map = new int[N][N];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    map[r][c] = sc.nextInt();
                }
            }

            int max = Integer.MIN_VALUE;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {

                    if(r+M>N||c+M>N) continue;
                    int kill = 0;
                    for (int i = r; i < r+M; i++) {
                        for (int j = c; j < c+M; j++) {

                            kill += map[i][j];
                        }
                    }
                    max = Math.max(kill,max);

                }
            }

            System.out.println("#"+t+" "+max);


        }

        sc.close();
    }
}
