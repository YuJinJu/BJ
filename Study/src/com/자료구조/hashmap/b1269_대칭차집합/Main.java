package com.자료구조.hashmap.b1269_대칭차집합;

import java.util.HashMap;
import java.util.Scanner;

// 차집합의 개수,, 즉 서로 없는 거 갯수 구하기
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < A+B; i++) {
            int num = sc.nextInt();
            if(!map.containsKey(num)) map.put(num,1);   // 키가 존재하지 않으면 1 넣어주기
            else map.put(num,map.get(num)+1);   // 같은 key 있으면 그 키의 값에서 카운트 1을 올려준다
        }

        Object [] list = map.keySet().toArray(); // 키로 리스트

        int count = 0;
        for (Object key : list) {
            if(map.get(key)==1) count++;    // 하나만 가지고 있으면 갯수 세기
        }

        System.out.println(count);
        sc.close();
    }
}
