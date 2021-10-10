package com.구현.b1546_평균;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float M = 0;
        float sum = 0;
        float[] score = new float[n];
        for (int i = 0; i < n ; i++) {
            score[i] = sc.nextFloat();
            M = Math.max(score[i],M);
        }

        for (int i = 0; i < n; i++) {
            sum += score[i]/M*100;
        }
        System.out.println(sum/n);

        sc.close();
    }
}
