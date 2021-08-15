package ch2_math.n17425_약수의합;

import java.io.*;

public class Main {
    static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long [] data = new long [MAX+1];


        //모든 수가 1을 약수로 가짐
        for (int i=1;i<=MAX;i++) data[i] = 1;

        //O(NlogN)
        for (int i=2;i<=MAX;i++){ //i를 약수로 가지면 data에 넣어주기
            for (int j=1; i*j<=MAX;j++) data[i*j] += i; //index는 약수를 가지는 수를 의미
        }

        //O(N)
        long [] g = new long[MAX+1];
        for (int i=1;i<=MAX;i++){
            g[i] = g[i-1] + data[i]; //배열 초기화 디폴트 값은 0
        }

        //O(T)
        int t = Integer.parseInt(bf.readLine()); // readLine 메소드는 String 값만 받을 수 있다.
        while (t-- >0){
            int n = Integer.parseInt(bf.readLine());
            bw.write(g[n]+"\n");// ❗  write는 아스키 코드에 따른 char형 값이 출력된다.
            // 그러나 i와 개행 처리 문자열 "\n" 을 더하면 String 으로 자동 형변환 되기 때문에
            // 저장되어 있는 int 값 그대로 출력이 가능하다. "\n" 안하면 에러생겼어서 당황했었음
        }
        bw.flush();
        bw.close(); //꼭꼭 close 해주어야 함

        //총 시간 복잡도 O(NlogN+N+T) = O(NlogN+T)
    }
}
