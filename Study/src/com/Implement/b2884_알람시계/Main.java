package com.Implement.b2884_ěëěęł;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();

        if(M<45){
            M+=60-45;
            if(H==0){
                H=23;
            }else H--;
        }else {
            M = M-45;
        }


        System.out.println(H+" "+M);
        sc.close();
    }
}
