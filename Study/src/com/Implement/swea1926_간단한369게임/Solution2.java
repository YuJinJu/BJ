package com.Implement.swea1926_간단한369게임;

import java.io.*;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int n = 1; n <= N; n++) {
            boolean clap = false;
            // 해당 숫자마다 char로 변환해서 3,6,9 개수세서 박수치기
            String str = String.valueOf(n);
            char [] c = new char[str.length()];
            for (int s = 0; s < str.length(); s++) {
                c[s] = str.charAt(s);
                if(c[s]=='3'||c[s]=='6'||c[s]=='9'){
                    sb.append("-");
                    clap = true;
                }
            }
            if(!clap){
                sb.append(str);
            }
            //숫자나 박수를 한번 출력하면 띄어쓰기
            sb.append(" ");
        }

        bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
    }

}
