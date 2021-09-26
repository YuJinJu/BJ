package com.BFS.b1697_숨바꼭질;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int V;
    static int second;
    static int [] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt(); //0 ≤ N ≤ 100,000
        int K = sc.nextInt(); //0 ≤ K ≤ 100,000
        second = 0;
        visited = new int[100001]; // index가 위치, 값은 second
        if(V!=K) bfs(V,K);

        System.out.println(second);
        sc.close();
    }

    private static void bfs(int v, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v]++;
        //System.out.println(v + " "+visited[v]);
        while (!queue.isEmpty()){
            v = queue.poll();

            int next = 0;
            for (int i = 0; i < 3; i++) {
                switch (i){
                    case 0 : next = v + 1;
                        break;
                    case 1 : next = v - 1;
                        break;
                    case 2 : next = v * 2;
                        break;
                }
                if(next>=0 && next <=100000 && visited[next]==0) {
                    visited[next] = visited[v] + 1; // 이동전의 시간 + 1

                    if(next == k){
                        second = visited[next]-1;
                        return;
                    }
                    queue.add(next);
                }

                //System.out.println(next + " "+visited[next]);
            }

        }
    }
}
