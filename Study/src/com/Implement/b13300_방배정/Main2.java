package com.Implement.b13300_방배정;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //학생수
        int K = sc.nextInt();   //방에 있는 사람 최대 수

        int [][] room = new int[7][2];
        for (int i = 0; i < N; i++) {
            int S = sc.nextInt(); //성별
            int Y = sc.nextInt(); //학년

            room[Y][S]++;
        }

        int cnt = 0;
        for (int i = 1; i <= 6 ; i++) {
            for (int j = 0; j < 2; j++) {
                if(room[i][j] > 0 && room[i][j] <= K) cnt++;
                else {
                    cnt += room[i][j]/K;
                    if(room[i][j]%K != 0) cnt++;
                }
            }
        }
        System.out.println(cnt);
        sc.close();
    }
}
