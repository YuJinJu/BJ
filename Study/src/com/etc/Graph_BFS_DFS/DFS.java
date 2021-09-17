package com.etc.Graph_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Graph {
    class Node {
        int data;
        LinkedList<Node> adj;   //인접한 노드 (자식노드)
        boolean visit;

        Node(int data) {
            this.data = data;
            this.visit = false;
            adj = new LinkedList<>();
        }
    }

    Node[] nodes;

    Graph(int size) {
        nodes = new Node[size+1];
        for (int i = 0; i <= size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        // 인접한 두 노드가 연결되어있는지 확인하고 연결 안되어있으면 연결해주기
        if (!n1.adj.contains(n2)) {
            n1.adj.add(n2);
        }
        if (!n2.adj.contains(n1)) {
            n2.adj.add(n1);
        }
    }

    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        root.visit = true;
        while (!q.isEmpty()) {
            Node r = q.poll();
            for (Node n : r.adj) {  // 큐에서 꺼낸 자식노드를 넣어주기
                if (n.visit == false) { //방문하지 않은 자식노드만
                    n.visit = true;
                    q.add(n);
                }
            }
            System.out.print(r.data+" ");
        }
    }

    void dfsR(Node r){  //링크드리스트가 노드의 주소를 가지고 있기 때문에 파라미터로 Node를 받아야한다.
        if(r == null) return;  // 기저조건

        r.visit = true;
        System.out.print(r.data+" ");

        for (Node n : r.adj) {
            if (n.visit == false){
                dfsR(n);
            }
        }
    }

    void dfsR(int index){
        Node r = nodes[index];
        dfsR(r);
    }
}

    public class DFS {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   //정점의 개수 N(1 ≤ N ≤ 1,000)
            int M = Integer.parseInt(st.nextToken());   //간선의 개수 M(1 ≤ M ≤ 10,000)
            int V = Integer.parseInt(st.nextToken());   //탐색을 시작할 정점의 번호

            Graph dfs = new Graph(N);
            Graph bfs = new Graph(N);
            for (int m = 0; m < M; m++) {   //간선이 연결하는 두 정점의 번호의 쌍
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                dfs.addEdge(a,b);
                bfs.addEdge(a,b);
            }
            dfs.dfsR(V);
            System.out.println();
            bfs.bfs(V);

        }
    }

