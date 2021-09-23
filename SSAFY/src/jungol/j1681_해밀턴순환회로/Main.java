package jungol.j1681_해밀턴순환회로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 방문 최소 비용
public class Main {
    static int N;
    static int [][] map;
    static boolean [] visited;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 배달할 장소 수 1≤N≤12 // 출발지(회사)는 1번
        map = new int[N+1][N+1];   // 단방향
        visited = new boolean[N+1];

        //(1,2)비용은 1번 장소에서 2번 장소로 이동하기 위한 비용을 의미하며,
        //2번 장소에서 1번 장소로 이동하기 위한 비용은 (2,1)에 주어진다.
        //장소 사이에 이동할 수 있는 방법이 없다면 비용 0
        StringTokenizer st = null;
        for (int r = 1; r <= N ; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        // (1,a) (a,b) (b,c)
        min = Integer.MAX_VALUE;

        visited[1] = true;
        dfs(1, 0, 1);
        System.out.println(min);
        //회사에서 출발하여 모든 장소를 한 번씩 들러 회사에 돌아오기 위한 최소의 비용을 출력한다.

        br.close();
    }

    private static void dfs(int r, int sum, int cnt) {
        if(cnt == N){ // 마지막은 회사로 가야한다
            if(map[r][1] == 0) return;
            sum += map[r][1];
            min = Math.min(min,sum);
//            System.out.println("now:"+map[r][1]);
//            System.out.println("sum:"+sum);
//            System.out.println("min:"+min);
//            System.out.println("--------");
            return;
        }

        for (int c = 2; c <= N ;c++) {

            if(visited[c] || map[r][c]==0 || sum + map[r][c] >= min) continue;
            visited[c] = true;

            dfs(c,sum + map[r][c],cnt+1);  // sum += map[r][c] 하지 않고 재귀에 넣어줘야한다!
            visited[c] = false; //
        }

    }

}
/*
5
0 14 4 10 20
14 0 7 8 7
4 5 0 7 16
11 7 9 0 2
18 7 17 4 0
 */