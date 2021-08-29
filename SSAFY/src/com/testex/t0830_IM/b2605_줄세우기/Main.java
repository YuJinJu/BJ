package com.testex.t0830_IM.b2605_줄세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] students = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> order = new ArrayList<>();
        order.add(0);   //학생번호는 1부터시작하니까 헷갈리지 않게 1부터 시작하기
        for (int i = 1; i <= N; i++) {
            students[i] = Integer.parseInt(st.nextToken());

            order.add(i - students[i],i);   // 번호표를 뽑은 만큼 앞으로 가기 때문에 i - students[i]인 인덱스에 뽑은학생의 순서 값을 add
        }

        for (int i = 1; i <=N; i++) {
            System.out.print(order.get(i)+" ");
        }

        br.close();
    }
}
