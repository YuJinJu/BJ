package com.CT.b13977_이항계수와쿼리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static int MOD = 1_000_000_007;
    static long [] fac;

    // 팩토리얼 미리저장.. 시간초과안남...
    static void pre(){
        fac = new long[4000001];
        fac[0] = fac[1] = 1;
        for (int i = 2; i < fac.length; i++) {
            fac[i] = (fac[i-1]*i)%MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        pre();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());   //1 ≤ n ≤ 4,000,000
            k = Integer.parseInt(st.nextToken());   //0 ≤ k ≤ n

            System.out.println(nCk(k));

            // test
            //System.out.println(fac(5));
        }

        br.close();
    }

    // n! / (r!*(n-r)!)
    // n! * r!^(MOD-2) * (n-r)!^(MOD-2)
    private static long nCk(int r) {
        if(n==r || k==0) return 1;
        long l1 = fac[n];
        long l2 = pow(fac[r],MOD-2);
        long l3 = pow(fac[n-r],MOD-2);

        return  ((l1*l2)%MOD * l3)%MOD;
    }

    private static long pow(long a, int b) {
        if(b==1) return a;
        long half = pow(a,b/2);
        long solEven = (half * half)%MOD;
        long solOdd = ((half*half)%MOD * (a%MOD))%MOD;
        if(b%2==0){
            return solEven;
        }else return solOdd;

    }

//    private static long fac(long x) { // 얘는시간초과
//        //if(x==1) nCk메소드에서 1리턴
//        long f = 1;
//        while (x>1){
//            f = (f * x)%MOD;
//            x--;
//        }
//        return f;
//    }
}
