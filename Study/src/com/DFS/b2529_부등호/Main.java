package com.DFS.b2529_부등호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://mygumi.tistory.com/279
public class Main {
    static int K;
    static String [] bu;    // 부등호
    static boolean [] use = new boolean[10];    // 방문처리(사용한숫자중복제거하기위함)
    static ArrayList<String> numList = new ArrayList<>();   // 부등호관계를 만족하는 숫자문자열을 담는곳

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        bu = new String[K];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int k = 0; k < K; k++) {
            bu[k] = st.nextToken(); // 부등호 입력받기
        }

        // 숫자가 들어올 수 있는지를 반복문으로 생각했을때는,,
        // 첫번째숫자는 모든 수가 들어올 수 있기 때문에 모두 해봐야한다
        // 두번째숫자부터 부등호에 의해 만족할 숫자를 넣고
        // 세번재숫자에서 가능한 경우가 없다면 다시 두번째로 돌아가 다음 숫자를 넣어야한다.. 그래서
        // 깊게 들어가다가 다시 돌아갈 수 있는 dfs를 이용해서 풀어야한다.
        // 중복되는 숫자가 없어야하므로 방문처리가 필요

        // 숫자문자열의 첫번째에 들어올 수 있는 모든경우 해보기
        for (int i = 0; i < 10; i++) { 
            use[i] = true;
            dfs(i,1,i+"");
            // dfs의 인자값
            // 1. 해당칸의 들어가는 숫자,, 즉 root
            // 2. 지금 dfs하는 부분이 숫자문자열에서 몇번째칸인지
            // 3. 지금까지 만족한 숫자문자열의 상태
        }

        // 0부터 9까지 순서대로 dfs를 하고
        // 부등호를 만족한 숫자만 리스트에 넣기 때문에
        // 정렬을 하지 않아도 마지막값이 최대값이고, 첫번째값이 최소값이다
        System.out.println(numList.get(numList.size()-1));
        System.out.println(numList.get(0));
        br.close();
    }

    private static void dfs(int v, int cnt, String num) {
        if(cnt == K+1){   // 부등호의 관계를 만족하여 K+1개의 숫자(하나의 문자열)을 완성하면 리스트에 넣는다
           numList.add(num);
        }
        else { // 숫자문자열을 완성하기 전
            
            for (int n = 0; n < 10; n++) { 
                if(!use[n]){ // 사용하지 않은 숫자일 경우.. 부등호관계맞는지 보기
                    if(bu[cnt].equals("<")){
                        if(v >= n) continue;
                    }else{
                        if(v <= n) continue;
                    }
                    use[n] = true; // 숫자를 사용하겠다고 사용처리해주고
                    dfs(n,cnt+1,num+n); // 뒤칸에 들어올수 있는 숫자 탐색하기
                }
            }
        }
        use[v] = false; //숫자문자열을 만족하는 다른경우도 탐색해야하기때문에 숫자사용처리 해지하기
    }


}
