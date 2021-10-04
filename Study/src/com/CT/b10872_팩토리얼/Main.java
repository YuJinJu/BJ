package com.CT.b10872_팩토리얼;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(fac(sc.nextInt()));
        sc.close();
    }

    private static long fac(long x) {
        long fac = 1;
        if(x==0 || x==1) return fac;
        else {
            while (x>1){
                fac = fac * x;
                x--;
            }
        }
        return fac;
    }


}
