package com.DP.b2579_계단오르기;

//계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다.
// 즉, 한 계단을 밟으면서 !! 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다. -> 다다음계단이 한계단 건너 뛸 수 있다
//연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
//마지막 도착 계단은 반드시 밟아야 한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//최댓값을 구하는 프로그램
public class Main {
    static int stairs [];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 계단 수 : 1 <= N <= 300
        stairs = new int[N+1];
        for (int n = 1; n <= N; n++) {
            stairs[n] = Integer.parseInt(br.readLine()); // 계단점수 : 10,000이하의 자연수
        }
        int max = Integer.MIN_VALUE;

        // 이전 계단을 밟으면 이전이전은 못밟아

        int [][] DP = new int[N+1][2];
        DP[1][0] = 0;
        DP[1][1] = stairs[1];
//        DP[2][0] = DP[1][1]; // 0, 10 중에서
//        DP[2][1] = 30;

        for (int i = 2; i <= N; i++) {  // step
            DP[i][0] = DP[i-1][1]; // 현재를 밟지 않으면 이전의 계단을 밟아야함
            int case1 = DP[i-2][1] + stairs[i]; // 현재를 밟을때, 경우1: 이전을 밟지 않고 이전이전은 밟아 // 경우2: 이전을 밟고 이전이전은 밟지 않을 때
            int case2 = DP[i-2][0] + stairs[i-1] + stairs[i];
            DP[i][1] = Math.max(case1,case2);
        }

        System.out.println(DP[N][1]);
        br.close();
    }
}
