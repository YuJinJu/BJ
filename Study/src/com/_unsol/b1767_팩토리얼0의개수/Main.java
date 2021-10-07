package com._unsol.b1767_팩토리얼0의개수;

import java.util.Scanner;

public class Main {
    static int cnt=0;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        long n = sc.nextLong();

        //fac(n);
        System.out.println(fac(n));
        System.out.println(cnt);

        sc.close();
    }

    private static long fac(long n) {
        long fac = 1;
        int k=1;
        if(n==0||n==1) return 1;
        else{
            while (k<=n){
                if(k%10==0) {
                    cnt = cnt + k/10;
                    k++;
                    continue;
                }
                fac = fac*k;
                if(fac%10!=0)fac %=10;
                else {
                    fac /=10;
                    cnt++;
                }
                k++;

            }
        }
        return fac;
    }
}
