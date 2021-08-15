package ch2_math.n1929_소수구하기;

import java.util.Scanner;

public class prac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean [] check = new boolean[m+1];
        check[0]=check[1] = true;

        for (int i=2;i*i<=m;i++){
            if(check[i]) continue;

            for (int j=i*i;j<=m;j+=i){ //초기값 곱해줌 i*i
                check[j] = true;
            }
        }

        for (int i=n;i<=m;i++){
            if(!check[i]) System.out.println(i);
        }
    }
}
