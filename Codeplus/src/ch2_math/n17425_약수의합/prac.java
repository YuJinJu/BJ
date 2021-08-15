package ch2_math.n17425_약수의합;

import java.io.*;

public class prac {
static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long [] data = new long[MAX+1];

        for (int i=1;i<=MAX;i++) data[i] = 1;

        //i를 약수로 가지면 data에 넣어주기
        //index는 약수를 가지는 수를 의미
        for (int i=2; i<= MAX; i++){
            for (int j=1; i*j<=MAX; j++){
                data[i*j] += i;
            }
        }
        long [] g = new long[MAX+1];
        //g(x)
        for (int i=1;i<=MAX;i++){
            g[i]=g[i-1] + data[i];
        }

        int t = Integer.parseInt(br.readLine()); // // readLine 메소드는 String 값만 받을 수 있다.
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
             bw.write(g[n]+"\n"); // ❗  아스키 코드에 따른 char형 값이 출력된다.
            // 그러나 i와 개행 처리 문자열 "\n" 을 더하면 String 으로 자동 형변환 되기 때문에
            // 저장되어 있는 int 값 그대로 출력이 가능하다.

        }

        bw.flush();
        bw.close(); //꼭꼭 close 해주어야 함
    }
}
