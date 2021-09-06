package com.personal.b6603_로또;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int P = 6;
    static int [] numbers;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            int K = sc.nextInt();
            if(K==0) break;
            int [] arr = new int[K]; // k 개 중에서 6개를 고르는 문제 // 오름차순

            numbers = new int[P];
            for (int k = 0; k < K; k++) {
                arr[k] = sc.nextInt();
            }
            Arrays.sort(arr);
            combi(0,0, K, arr);
            System.out.println();
        }

        sc.close();
    }

    private static void combi(int cnt, int start, int K, int[] arr) {
        if(cnt == P){

            for (int i = 0; i < P; i++) {
                System.out.print(numbers[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < K ; i++) {
            numbers[cnt] = arr[i];
            combi(cnt+1, i+1, K, arr);
        }
    }
}
