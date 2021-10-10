package com.Implement.b3009_네번째점;

import java.util.HashMap;
import java.util.Scanner;

public class Main_hash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Integer> hashX = new HashMap<>();
        HashMap<Integer,Integer> hashY = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(!hashX.containsKey(x))hashX.put(x,1);
            else hashX.put(x,2);

            if(!hashY.containsKey(y))hashY.put(y,1);
            else hashY.put(y,2);
        }

        int solX = 0;
        int solY = 0;
        for (int x : hashX.keySet()) {
            if(hashX.get(x)==1) solX = x;
        }
        for (int y : hashY.keySet()) {
            if(hashY.get(y)==1) solY = y;
        }

        System.out.println(solX +" "+ solY);
        sc.close();
    }
}
