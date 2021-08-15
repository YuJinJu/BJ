package ch2_math.n1978_소수찾기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        for (int i=0;i<n;i++) {
            int x = sc.nextInt();
            boolean flag = true;

            if(x==1) continue;
            for (int j=2;j*j<=x;j++){
                if(x%j==0) {
                    flag = false;
                    break;
                }
            }
            if(flag==true) count++;
        }

        System.out.println(count);

    }
}
