package com.DP.b1932_정수삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [][][] triangle = new int[501][501][2];  //행별로 저장
        int N = Integer.parseInt(br.readLine());    //삼각형 길이
        triangle[1][1][0] = Integer.parseInt(br.readLine());    // root //아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.
        StringTokenizer st = null;
        // 이진 트리 --> 인접 무방향 그래프로 그려서 풀것 .. 좌우만 접근 가능 / 마지막 자식 노드까지 각각 더해서 그 값의 최대값 구하기

        br.close();
    }
}

/*
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
 */
