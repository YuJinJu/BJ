package com.구현.b8958_OX문제;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            char [] ox = sc.next().toCharArray();
            int score = 0;
            int total = 0;
            for (char c: ox) {
                if(c=='O') score++;
                else score=0;
                total +=score;
            }
            System.out.println(total);
        }

        sc.close();
    }
}
