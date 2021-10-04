package com.CT.b11401_이항계수3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 단순 조합 공식을 모듈러의 분배법칙, 페르마의 소정리로 이용
// 조합 공식 : nCk = n! / (r! * (n-r)!)
// 모듈러의 분배법칙 적용하기 위해 페르마의 소정리 적용 : [n! * {r!*(n-r)!}^(MOD-2)] % MOD

public class Main {
    static long n;
    static long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 1<=N<=4000000
        long K = Integer.parseInt(st.nextToken());   // 0<=K<=N

        //nCr = (n-1 C k-1) + (n-1 C k)

        System.out.println(nCk(K));

        br.close();

    }


    // nCk = n! / (r! * (n-r)!)
    // = [ n! * { r!*(n-r)! }^(MOD-2) ] %MOD
    private static long nCk(long r) {
        if(n==r || r==0) return 1;

        long result = 0;
        //result = fac(n) / (fac(r) * fac(n-r));
        //= (fac(n) * ((fac(r) * fac(n-r)))^(MOD-2)) % MOD
        //= (fac(n) * ( (fac(r)^(MOD-2) * fac(n-r)^(MOD-2) ) % MOD
        long l1 = fac(n);
        long l2 = pow(fac(r),MOD-2);
        long l3 = pow(fac(n-r),MOD-2);

        result = ((l1*l2)%MOD *l3)%MOD;
        return result;
    }

    private static long pow(long a, long b) {
        if(b==1) return a;

        long half = pow(a,b/2); // 빠른제곱구하기
        if(b%2==0){
            return (half*half) %MOD;
        }else{
            return ((half*half)%MOD * (a%MOD) )%MOD;
        }
    }

    public static long fac(long x) {
        long fac = 1L;

        while(x > 1) {
            fac = (fac * x) % MOD;
            x--;
        }
        return fac;
    }

}
//4000000 2000000