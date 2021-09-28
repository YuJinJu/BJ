package com.자료구조.hashmap.b1302_베스트셀러;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//오늘 하루 동안 팔린 책의 제목이 입력으로 들어왔을 때, 가장 많이 팔린 책의 제목을 출력
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String book = sc.next();
            if(hashMap.containsKey(book)) hashMap.put(book,hashMap.get(book)+1);   // 덮어쓰기
            else hashMap.put(book,1);
        }
        int max = 0;
        for (String s : hashMap.keySet()) {
                max = Math.max(max, hashMap.get(s));
        }
// hmap.containskey(key) --> boolean
        // putIfAbsent 있으면 넣고 없으면 안넣는거
// 우선순위큐,  compareto, 자료구조, 라이브러리 메소드 사용방법..
        Object [] bookmap = hashMap.keySet().toArray();
        Arrays.sort(bookmap);
        for (Object o :
                hashMap.keySet()) {
            System.out.println(o);
        }

        for (Object key : bookmap) {
            if(hashMap.get(key) == max) {
                System.out.println(key);
                break;
            }
        }

        sc.close();
    }
}
