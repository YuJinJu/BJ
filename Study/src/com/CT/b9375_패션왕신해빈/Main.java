package com.CT.b9375_패션왕신해빈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());    // 의상 수
            HashMap<String,Integer> clothes = new HashMap<>();

            for (int n = 0; n < N; n++) { //0인경우는 안됨.. h,t, h+s, s+t,s
            // (2+1)*(1+1)-1=5
            // (3+1)-1 = 3
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kinds = st.nextToken();
                if(clothes.containsKey(kinds)){
                    clothes.put(kinds,clothes.get(kinds)+1);
                }else{
                    clothes.put(kinds,1);
                }
            }
            Object [] set = clothes.keySet().toArray();

            int result = 1;
            for (int i = 0; i < set.length; i++) {
               result *= (clothes.get(set[i])+1);
            }

            System.out.println(result-1);
        }

        br.close();
    }
}
