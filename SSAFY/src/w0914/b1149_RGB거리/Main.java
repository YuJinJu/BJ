package w0914.b1149_RGB거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//26 57 13
//i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //2 ≤ N ≤ 1,000
        int rgb [][] = new int[N+1][3]; // 입력값
        int h [][]= new int[N+1][3];     // 고른 집 색깔
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rgb[i][0] = Integer.parseInt(st.nextToken());  //R
            rgb[i][1] = Integer.parseInt(st.nextToken());  //G
            rgb[i][2] = Integer.parseInt(st.nextToken());  //B
        }

        h[1][0] = rgb[1][0];
        h[1][1] = rgb[1][1];
        h[1][2] = rgb[1][2];

        // 첫번째부터 정하기 // 세가지 다 해보기
        for (int i = 2; i <=N; i++) {
            // 빨1 초2 파3
            for (int j = 0; j < 3; j++) {   // 현재 rgb
                h[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {   // 이전 rgb
                    if(j != k){ // 이전과 현재의 rgb가 달라야한다
                        h[i][j] = Math.min(h[i][j], rgb[i][j] + h[i-1][k]); // 현재집까지의 가격을 합하여 넣어주고 최소값을 찾는다
                    }
                }

            }
        }
        int min = Math.min(h[N][0],h[N][1]);    // 마지막 집에 저장된 가격 비교: 첨부터 지금까지의 가격의 합이 저장
        min = Math.min(min,h[N][2]);
        System.out.println(min);
        br.close();
    }
}
