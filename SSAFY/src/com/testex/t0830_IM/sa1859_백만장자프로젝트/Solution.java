package com.testex.t0830_IM.sa1859_백만장자프로젝트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(br.readLine());

            int[] day = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int n = 0; n <N ; n++) {
                day[n] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            int max = day[N-1]; // 마지막날
            for(int i = day.length - 2; i >= 0; i--){
                if(day[i] < max) sum += max-day[i];
                else max = day[i];
            }

           sb.append(sum).append("\n"); //alt+shift+enter누르니까 바꿔줬어
        }
        System.out.println(sb);
    br.close();
    }
}
