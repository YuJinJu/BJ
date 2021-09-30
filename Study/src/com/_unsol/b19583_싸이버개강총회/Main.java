package com._unsol.b19583_싸이버개강총회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();
        // _S_E_Q_ // -S E-Q
        int count = 0;

        HashMap<String,Integer> map = new HashMap<>();

        while (true){
            st = new StringTokenizer(br.readLine());
            if(!st.hasMoreTokens()) break;
            String time = st.nextToken();
            String name = st.nextToken();

            if(!map.containsKey(name))map.put(name,1);
            else map.put(name,map.get(name)+1);
        }

        Object [] list = map.keySet().toArray(new String[0]);
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println(count);

        br.close();
    }
}
//(line = br.readLine()) != null