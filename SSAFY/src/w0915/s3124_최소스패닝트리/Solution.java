package w0915.s3124_최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());   // 정점개수
            int E = Integer.parseInt(st.nextToken());   // 간선개수

            for (int e = 0; e < E; e++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());   //연결된 정점 AB
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());   //가중치 // |C| < 1000000
            }

            System.out.print("#"+t);
        }

        br.close();
    }

}
