package com.b2458_키순서;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 인접행렬
/*
1->5->2
    ->4->2
       ->6
3->4->2
     ->6

 */
public class BFS {
    static int N,M,adj[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());    // 학생 수
            M = Integer.parseInt(br.readLine());    // 두 학생의 키를 비교한 횟수
            adj = new int[N+1][N+1];

            int a = Integer.parseInt(br.readLine());    //a인 학생이 번호가 b인 학생보다 키가 작다
            int b = Integer.parseInt(br.readLine());

        }
        br.close();
    }
}
