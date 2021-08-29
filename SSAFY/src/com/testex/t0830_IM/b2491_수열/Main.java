package com.testex.t0830_IM.b2491_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//0에서부터 9까지의 숫자로 이루어진 N개의 숫자가 나열된 수열이 있다. 그 수열 안에서 연속해서 커지거나(같은 것 포함),
// 혹은 연속해서 작아지는(같은 것 포함) 수열 중 가장 길이가 긴 것을 찾아내어 그 길이를 출력

//수열 1, 2, 2, 4, 4, 5, 7, 7, 2 의 경우에는 1 ≤ 2 ≤ 2 ≤ 4 ≤ 4 ≤ 5 ≤ 7 ≤ 7 이 가장 긴 구간이 되므로 그 길이 8을 출력
//수열 4, 1, 3, 3, 2, 2, 9, 2, 3 의 경우에는 3 ≥ 3 ≥ 2 ≥ 2 가 가장 긴 구간이 되므로 그 길이 4를 출력
// 1, 5, 3, 6, 4, 7, 1, 3, 2, 9, 5 의 경우에는 연속해서 커지거나 작아지는 수열의 길이가 3 이상인 경우가 없으므로 2를 출력
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //N은 1 이상 100,000 이하
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int upCnt = 1;
        int downCnt = 1;
        int max = 1;

        for(int i=1; i<N; i++){

            //오름차순
            if(arr[i-1] <= arr[i] ){
                if(arr[i-1] != arr[i]) {
                    downCnt = 1;
                }
                upCnt++;
            }
            //내림차순
            if(arr[i-1] >= arr[i]){
                if(arr[i-1] != arr[i]){
                    upCnt = 1;
                }
                downCnt++;
            }

            if(max < upCnt) max = upCnt;
            else if(max < downCnt) max = downCnt;

        }

        System.out.println(max);

        br.close();
    }
}
