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
        int sum = stairs[N];  // 마지막 계단은 필수이기 때문에 미리 넣어두기
        /*
        계단 밟았을 때 (마지막계단 필수니까 마지막부터 해보기?)
        한칸씩 / 두칸씩  - 즉 x 연속 두개는 안된다.. / 연속 3칸이동 안됨

        끝에서 시작하는 방법은 두가지,,
        6 5 x - n

        6 x 4 - x
        6 x 4 - n
        3개씩 묶어서...?

        6 5 x 3 2 x
        6 5 x 3 x 1
        6 x 4 x 3 2 x
        6 x 4 x 3 x 1
        6 x 4 3 x 2 1
        6 x 4 3 x 2 x
        */


        br.close();
    }
}
