package ch2_math.n6588_골드바흐의추측;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final int MAX = 1000000;
    public static void main(String[] args) {

        //100만 이하의 소수판별배열 check
        boolean [] check = new boolean[MAX+1];
        ArrayList<Integer> prime = new ArrayList<>();
        check[0] = check[1] = true;

        for (int i=2;i*i<=MAX;i++){
            if(check[i]) continue;

            for (int j=i*i;j<=MAX;j+=i){
                check[j] = true;
            }
        }

        //소수리스트 prime
        for (int i=0;i<=MAX;i++)
        if(!check[i]) prime.add(i);

        //골드바흐의 추측 검증
        Scanner sc = new Scanner(System.in);

        while (true){
            boolean flag = false;
            int n = sc.nextInt();
            if(n==0) break;

            for (int i=0;i<prime.size();i++){
                int p = prime.get(i);
                if(check[n-p]==false){
                    System.out.println(n+" = "+prime.get(i)+" + "+(n-p));
                    flag = true;
                    break;
                }
            }
            if(!flag)
                System.out.println("Goldbach's conjecture is wrong.");
        }

    }
}
