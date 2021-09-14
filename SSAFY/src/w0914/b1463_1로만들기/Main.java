package w0914.b1463_1로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
2. X가 2로 나누어 떨어지면, 2로 나눈다.
3. 1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 */

/*
min[1] = 1;
min[2] = 1;
min[3] = 1;

min[4]
-> 4 -= 1 -> min[3] = 1 => 2;
-> 4 /= 2 -> min[2] = 1 => 2;
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] min = new int[1000001]; // 1 <= N <= 1000000
        min[2] = 1;
        min[3] = 1;

        for (int i = 4; i <= N; i++) {
            int cnt1 = Integer.MAX_VALUE, cnt2 = Integer.MAX_VALUE, cnt3 = Integer.MAX_VALUE;

            for (int j = 1; j <= 3; j++) {

                if(i % 3 == 0 && j==3) {
                    cnt3 = min[i/3] + 1;
                }
                else if(i % 2 == 0 && j==2){
                    cnt2 = min[i/2] + 1;
                }else if(j==1){
                    cnt1 = min[i-1] + 1;
                }

            }
            min[i] = Math.min(cnt1,cnt2);
            min[i] = Math.min(cnt3,min[i]);
        }
        System.out.println(min[N]);

    }
}
