package com.구현.b1152_단어의개수;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        while (st.hasMoreTokens()){ //토큰이 있을때까지 반복하기
           list.add(st.nextToken());   // 토큰까지 잘라서 단어를 리스트에 넣기
        }

        System.out.println(list.size());

        sc.close();
    }
}
