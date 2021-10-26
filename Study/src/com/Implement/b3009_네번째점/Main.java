package com.Implement.b3009_네번째점;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] x = new int[3];
        int [] y = new int[3];
        for (int n = 0; n < 3; n++) {
            x[n] = sc.nextInt();
            y[n] = sc.nextInt();
        }

        int [] tmpX = new int[1001];    // 같은숫자가 짝수이면 짝이맞는것
        int [] tmpY = new int[1001];    // 같은숫자가 짝수이면 짝이맞는것
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(x[i]==x[j]) tmpX[x[i]]++;
                if(y[i]==y[j]) tmpY[y[i]]++;
            }
        }
        int solX = 0;
        int solY = 0;
        for (int t = 0; t < tmpX.length; t++) {
            if(tmpX[t]%2!=0) solX = t;
            if(tmpY[t]%2!=0) solY = t;
        }
        System.out.println(solX+" "+solY);
        sc.close();
    }
}
