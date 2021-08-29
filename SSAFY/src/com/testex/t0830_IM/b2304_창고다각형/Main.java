package com.testex.t0830_IM.b2304_창고다각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//파인 부분 있으면 X
//첫번째 높이, 마지막 높이, 제일 큰 높이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int maxH = 0;
        int maxHL = 0;
        int minL = 1111;
        int maxL = 0;
        ArrayList<Integer> height = new ArrayList<>();
        ArrayList<Integer> store = new ArrayList<>();

        //초기화
        for (int i = 0; i <= 1000; i++) {
            store.add(0);
        }

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            store.set(L, H);    // 위치 L인 index에 높이 바꿔주기

            //최대 높이의 기둥 찾기
            if (maxH < H) {
                maxH = H;   // 10
                maxHL = L;  // 8 // 가장 높은 지붕의 index 저장
            }

            //기둥 위치 범위 구하기
            if (maxL < L) maxL = L; // 2
            if (minL > L) minL = L; // 15
        }
        // 0 <= L <= 999
        //왕관 모양 X, 세모 모양 O
        for (int l = minL; l < maxHL; l++) {
            if ( l-1 >= minL && store.get(l - 1) > store.get(l))
                store.set(l, store.get(l - 1));  //현재 높이가 이전 높이보다 작을 경우 움푹 파이기 때문에 이전 높이로 바꿔주기
        }
        for (int l = maxL; l > maxHL; l--) {
            if (l + 1 <= maxL && store.get(l) < store.get(l + 1))
                store.set(l, store.get(l + 1)); ////현재 높이가 뒤의 높이보다 작을 경우 움푹 파이기 때문에 이후 높이로 바꿔주기
        }
        
        // 넓이구하기
        int result = 0;
        for (int c = minL; c <= maxL; c++) {
            result += store.get(c);
        }

        System.out.println(result);
        br.close();
    }
}
