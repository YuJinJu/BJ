package com.순조부.b10819_차이를최대로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 순열, 절대값, 최대값
public class Main {
    static int N;
    static int [] arr;
    static int [] num;
    static boolean [] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //3 ≤ N ≤ 8

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];   // 주어진 배열
        selected = new boolean[N];  // 중복체크
        num = new int[N]; // N개의 숫자를 고르고 저장할 배열
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken()); // -100 ~ 100
        }

        System.out.println(permu(0));

        br.close();
    }

    static int max = Integer.MIN_VALUE;
    private static int permu(int cnt) {
        if(cnt==N){ // 고른 숫자의 개수가 N가 되면,, 문제에 나온 식대로 합을 구해준다
            int sum = 0;
            for (int i = 1; i < N; i++) {
                sum += Math.abs(num[i]-num[i-1]);
            }
            max = Math.max(sum,max); //  그 합 중에서 최대를 고르기

        }

        for (int i = 0; i < N; i++) {
            if(selected[i]) continue;   // 중복불가,,, (모두선택한숫자면 포문종료후 리턴하여 재귀 탈출)

            num[cnt] = arr[i];  // 고른숫자담기
            selected[i] = true; // 선택체크

            permu(cnt+1);   // 고른숫자가 하나 증가하였으므로,, 남은 순열 자리 찾아주기
            selected[i] = false;    // N개의 숫자를 다 고르면(=재귀 탈출하면) 다시 선택체크해지해주고,,,,, 다음숫자고르기
        }

        return max;
    }
}
