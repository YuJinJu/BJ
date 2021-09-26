package com.graph.n1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [] parents;

    static int find(int a){
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]); // 자신이 속한 집합의 대표자를 자신의 부모로 : path compression
    }

    static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot != bRoot)
            parents[bRoot] = aRoot; // b의 부모를 a로 삼다
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        for(int n = 0; n <= N; n++){
            parents[n] = n;
        }

        for(int m = 0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int union_find = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if(union_find == 0){
                union(A,B);
            }else {
                if(find(A) == find(B)) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
