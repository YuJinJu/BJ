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
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int minDepth = Integer.MAX_VALUE;
        boolean [] visit = new boolean[100001];
        Queue<int[]> queue = new LinkedList<>();
        if (N != K) {
            int depth = 0;
            queue.add(new int[]{N, depth});
        } else {
            cnt++;
            minDepth = 0;
        }
        while (!queue.isEmpty()) {
            int[] v = queue.poll();
            visit[v[0]] = true;     // 방문할때(평소처럼 큐에넣을때) 방문처리하면 최소시간의 다른방법을 구하지 못하므로 poll할때 방문처리 ,,
                                    // 방문처리 안하면 메모리초과
            if (minDepth < v[1]) continue;
            if (v[0] == K) {
                cnt++;
                if (cnt == 1) minDepth = v[1];
                continue;
            }

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
