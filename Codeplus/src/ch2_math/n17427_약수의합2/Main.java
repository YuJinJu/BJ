package ch2_math.n17427_약수의합2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        long g = 0;

         for (int i=1;i<=a;i++) g += a/i * i;

        System.out.println(g);
    }
}
