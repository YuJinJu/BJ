package com.Implement.b1173_운동;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 운동
        int m = sc.nextInt();   // 초기맥박, 최소맥박
        int M = sc.nextInt();   // 최대맥박
        int T = sc.nextInt();   // 운동시 맥박증가
        int R = sc.nextInt();   // 휴식시 맥박감소

        int b = 0;  // 휴식시간
        int x = m;  // 현재맥박
        for (int n = 1; n <= N; n++) {
            x +=T;
            System.out.println(x);
            if(x+T>M) {
                int r = 0;
                while (M > T+x){
                    r+=R;
                    b++;
                }
                x -= r;
                System.out.println(x);
            }
        }
        System.out.println(b+N);

        sc.close();
    }
}
