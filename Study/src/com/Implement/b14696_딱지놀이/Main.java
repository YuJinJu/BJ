package com.Implement.b14696_딱지놀이;

import java.util.Scanner;

// 별4 동그라미3 네모2 세모1
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        for (int n = 0; n < N; n++) {
            int [] A = new int[5];
            int [] B = new int[5];

            int aCnt = sc.nextInt();
            for (int a = 0; a < aCnt; a++) {
                A[sc.nextInt()]++;
            }
            int bCnt = sc.nextInt();
            for (int b = 0; b < bCnt; b++) {
                B[sc.nextInt()]++;
            }

            char win = ' ';

            for (int i = 4; i >= 1; i--) {
                if(A[i]>B[i]) win='A';
                else if (A[i]<B[i]) win='B';

                if(win !=' ') break;
            }

            if(win ==' ') win='D';
           sb.append(win).append("\n");
        }
        System.out.println(sb);

        sc.close();
    }
}
