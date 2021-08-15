package ch2_math.n4375_1;

import java.util.Scanner;

public class Main {
    public static int One(int n){
        int num = 0;
        for(int i=1;;i++){
            num = num*10 + 1;
            num = num % n;
            if(num==0)
                return i;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int n = sc.nextInt();
            System.out.println(One(n));
        }

    }
}

