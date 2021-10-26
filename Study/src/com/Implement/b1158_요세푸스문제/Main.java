package com.Implement.b1158_요세푸스문제;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int K = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            list.add(n+1);
        }
        sb.append("<");
        Queue<Integer> rm = new LinkedList<>();
        int cnt=0;
        while (!list.isEmpty()){
            for (int num : list){
                if(++cnt%K==0) {
                     sb.append(num).append(", ");
                     rm.add(num);
//                    list.remove(num);
                     cnt=0;
                }
            }
            while (!rm.isEmpty()){
                list.remove(rm.poll());
            }
            rm = new LinkedList<>();
        }
        sb.setLength(sb.length()-2);
        sb.append(">");
        System.out.println(sb);
        sc.close();
    }
}
