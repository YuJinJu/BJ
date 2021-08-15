package ch2_math.n1037_약수;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int [] num = new int[count];

        for (int i=0;i<count;i++){
            num[i] = sc.nextInt();
        }
        int max = num[0];
        int min = num[0];
        for (int i=1;i<count;i++){
            max = Math.max(max,num[i]);
            min = Math.min(min,num[i]);
        }
        System.out.println(max*min);
    }
}
//test1