package com.testex.b2559_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 복잡도 제한 때문에 2중 for문 X
// 중복되는 합을 이용하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < K; i++) {
                sum += arr[i];
        }

        //첫번째 sum 비교하기
        max = Math.max(sum, max);
        //System.out.println(max);

        //남은 수열의 합은 미리 저장해둔 sum을 이용해 구하기
        for (int i = 0; i < N - K; i++) {
            sum = sum - arr[i] + arr[K+i];
            //System.out.println(sum);
            max = Math.max(sum,max);    // 최대 합 구하기
        }

        System.out.println(max);

        br.close();
    }
}
