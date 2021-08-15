package ch2_math.n1929_소수구하기;

import java.util.Scanner;

//범위 내의 소수 구하기
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        //수를 지웠는지 안지웠는지 판별하는 배열 (지우면 true)
        boolean [] arr = new boolean [n+1];

        arr[0] = arr[1] = true;

        for (int i=2;i*i<=n;i++){
            if(arr[i]) continue;

            for (int j=i+i;j<=n;j+=i){ //초기값 더해줌 i+i
                arr[j] = true;
            }
        }

        for (int i=m;i<=n;i++){
            if(!arr[i]) System.out.println(i);
        }
    }
}
