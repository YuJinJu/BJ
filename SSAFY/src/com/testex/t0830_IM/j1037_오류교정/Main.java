package com.testex.t0830_IM.j1037_오류교정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //행렬의 각각의 열과 각각의 행이 짝수 합을 가질 때 패리티 성질을 가지고 있다고 하자.
        // 다시 말하자면 한 집합에 짝수개의 1이 있다는 이야기 이다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int [][] arr = new int[N+1][N+1];
        StringTokenizer st = null;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0의 행과 0의 열에 합을 저장
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                //열의 합
                arr[i][0] += arr[i][j];

                //행의 합
                arr[0][i] += arr[j][i];
            }
        }

        int r = 0;
        int c = 0;

        int cntR = 0;
        int cntC = 0;

        //행과 열의 합이 홀수일 때 카운팅
        //패리티 change 될 수 있을 때를 생각해서 홀수인 좌표 저장
        for (int i = 1; i <= N; i++) {
            if(arr[i][0] %2 != 0) {
                r = i;
                cntR++;
            }
            if(arr[0][i] %2 != 0) {
                c = i;
                cntC++;
            }
        }
        //행과열 둘 다 홀수 일 때는 중복되는 부분 한 곳을 바꾸면 패리티체인지 성공
        if(cntR%2!=0 && cntC%2!=0) sb.append("Change bit (").append(r).append(",").append(c).append(")");

        //행과열 둘 다 홀수가 없을 때는 패리티 완성
        else if(r==0 && c==0) sb.append("OK");

        //부호를 하나만 바꿀 수 있기 때문에 각각의 행이나 열에서 두개 이상 홀수이면 체인지 불가
        else if(cntC >=2 || cntR >= 2) sb.append("Corrupt");

        System.out.println(sb);

        br.close();
    }
}
