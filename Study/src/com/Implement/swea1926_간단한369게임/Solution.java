package com.Implement.swea1926_간단한369게임;

import java.io.*;

// 나머지와 몫을 이용한 삼육구게임
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int n = 1; n <= N; n++) {  // 10으로 나눈 나머지가 마지막 뒷자리, 10으로 나눈 몫이 앞자리
            int x = n;
            boolean tsn = false;
            while (true){
                int front = x/10;
                int end = x%10;
                if(end%3==0&&end!=0) {
                    tsn = true;
                    sb.append("-");
                }
                if(front==0) break;
                else x=front;
            }
            if(!tsn) sb.append(n);
            //숫자나 박수를 한번 출력하면 띄어쓰기
            sb.append(" ");
        }
        //33 - 2번 333이면3번
        bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
    }

}
