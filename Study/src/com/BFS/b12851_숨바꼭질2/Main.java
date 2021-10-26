package com.BFS.b12851_숨바꼭질2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수빈위치 0 ≤ N ≤ 100,000
        int K = Integer.parseInt(st.nextToken()); // 동생위치 0 ≤ K ≤ 100,000
        int minDepth = Integer.MAX_VALUE;   // 최소로 동생 잡는 시간(최소깊이)
        int cnt = 0;    // 동생을 찾는방법갯수
        boolean [] visit = new boolean[100001];
        Queue<int[]> queue = new LinkedList<>();    // 수빈이위치, 시간(깊이)

        if (N != K) {
            queue.add(new int[]{N, 0}); // 수빈이위치,시간 큐에 담기
        } else {    // 처음에 수빈이와 동생이 같은 위치일 때는 큐에 안담고 바로 종료
            cnt++;
            minDepth = 0;
        }

        while (!queue.isEmpty()) {
            int[] v = queue.poll();

            visit[v[0]] = true;     // 방문할때(평소처럼 큐에넣을때) 방문처리하면 최소시간의 다른방법을 구하지 못하므로 poll할때 방문처리 ,,
                                    // 방문처리 안하면 메모리초과
            if (minDepth < v[1]) break;  // 최소시간보다 클경우 다음으로 넘어가기
            if (v[0] == K) {    // 수빈이가 동생을 잡았을때

                cnt++;
                if (cnt == 1) minDepth = v[1];  // 처음 잡았으면 이게 최소시간
                continue;
            }

            // 수빈이가 이동하는 위치와 시간을 저장.. 매번 시간을 저장하는 이유는 수빈이가 동생을 잡았을 때, 최소시간인지 확인해야하기 때문
            if (v[0] - 1 >= 0 && !visit[v[0]-1]) queue.add(new int[]{v[0] - 1, v[1] + 1});
            if (v[0] + 1 <= 100000 && !visit[v[0]+1]) queue.add(new int[]{v[0] + 1, v[1] + 1});
            if (v[0] * 2 <= 100000 && !visit[v[0]*2]) queue.add(new int[]{v[0] * 2, v[1] + 1});
        }
        // 가장 빠른 도착 시간과 그 방법이 몇가지인지 출력
        sb.append(minDepth).append("\n").append(cnt);
        System.out.println(sb);
        br.close();
    }
}
