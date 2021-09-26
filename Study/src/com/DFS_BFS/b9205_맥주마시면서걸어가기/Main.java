package com.DFS_BFS.b9205_맥주마시면서걸어가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// https://steady-coding.tistory.com/97

//출발은 상근이네 집에서 하고, 맥주 한 박스를 들고 출발한다. 맥주 한 박스에는 맥주가 20개 들어있다.
// 50미터를 가려면 그 직전에 맥주 한 병을 마셔야 한다.
// 편의점에 들렸을 때, 빈 병은 버리고 새 맥주 병을 살 수 있다. 하지만, 박스에 들어있는 맥주는 20병을 넘을 수 없다.


//송도는 직사각형 모양으로 생긴 도시이다. 두 좌표 사이의 거리는 x 좌표의 차이 + y 좌표의 차이 이다. (맨해튼 거리)
// 페스티벌에 갈 수 있으면 "happy", 중간에 맥주가 바닥나서 더 이동할 수 없으면 "sad"

// 맨해튼 거리  |x1 - x2| + |y1 - y2|

// 정점을 나타내는 클래스
class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //t ≤ 50

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine()); //편의점 개수 //0 ≤ n ≤ 100

            ArrayList<Point> p = new ArrayList<>(); // 좌표 : 상근이네 집, 편의점, 페스티벌

            for (int n = 0; n < N + 2; n++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()); // -32768 ≤ x, y ≤ 32767
                int Y = Integer.parseInt(st.nextToken());

                p.add(new Point(X,Y));
            }

            // 인접 리스트 생성
            ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
            for (int i = 0; i < N + 2; i++) {
                adjlist.add(new ArrayList<>());
            }

            // 정점 연결
            for (int i = 0; i < N + 2; i++) {
                for (int j = 0; j < N + 2; j++) {
                    if(Math.abs(p.get(i).x - p.get(j).x) + Math.abs(p.get(i).y - p.get(j).y) <=1000){
                        adjlist.get(i).add(j);
                        adjlist.get(j).add(i);
                    }
                }
            }
            System.out.println(bfs(adjlist) ? "happy" : "sad");
        }
        br.close();
    }

    static boolean bfs(ArrayList<ArrayList<Integer>> adjlist){
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[N+2];

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()){
            int v = queue.poll();

            if(v == N+1) return true;

            for (int n : adjlist.get(v)) {
                if (visited[n]) continue;
                visited[n] = true;
                queue.add(n);
            }
        }
        return false;
    }

}
/*
2
2
0 0
1000 0
1000 1000
2000 1000
2
0 0
1000 0
2000 1000
2000 2000
 */