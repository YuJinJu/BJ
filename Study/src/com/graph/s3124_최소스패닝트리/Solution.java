package com.graph.s3124_최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://taxol1203.github.io/codingtest/SWEA-%EC%B5%9C%EC%86%8C-%EC%8A%A4%ED%8C%A8%EB%8B%9D-%ED%8A%B8%EB%A6%AC/
public class Solution {

    static int n, m;
    static int[] parents;
    static Edge[] edgeList;
    // 간선
    static class Edge implements Comparable<Edge>{
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            super();
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[").append(from).append(", ").append(to).append(", ").append(weight)
                    .append("]");
            return builder.toString();
        }

    }
    //------------ 서로소 집합-------------//
    // 각 사람들을 초기화 해준다.
    // 처음은 다 자기 자신이 부모
    static void make() {
        for(int i = 1; i <= n; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int num) {
        // 자신이 root이면 반환
        if(parents[num] == num)
            return num;
        // path compression을 하여 해당 노드를 최상위 노드 바로 밑에 붙게 한다.
        return parents[num] = findSet(parents[num]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot)		// a와 b의 root가 같으면, 같은 집합이므로 종료
            return false;
        int Min_Parent = Math.min(aRoot, bRoot);	// 최대한 한쪽으로 몰아 넣는다.
        parents[aRoot] = Min_Parent;
        parents[bRoot] = Min_Parent;
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());   // 정점개수
            m = Integer.parseInt(st.nextToken());   // 간선개수
            edgeList = new Edge[m];
            parents = new int[n+1];

            for (int e = 0; e < m; e++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());   //연결된 정점 AB
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());   //가중치 // |C| < 1000000

                edgeList[e] = new Edge(A,B,C);
            }

            Arrays.sort(edgeList);
            make();
            long result = 0;
            int count = 0; // 선택한 간선 수

            for(Edge edge : edgeList) {
                if(union(edge.from, edge.to)) {		// 만약 사이클이 존재하게 되면 root가 같으므로, 해당 간선은 넘긴다.
                    result += edge.weight;
                    if(++count == n - 1) {
                        break;
                    }
                }
            }
            System.out.print("#"+t +" "+ result);
        }

        br.close();
    }

}
