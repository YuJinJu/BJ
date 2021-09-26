package com.array.b2628_종이자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int cut = Integer.parseInt(br.readLine());

        //자르는 행, 열을 모두 저장하고 정렬한 후 각각의 행,열 길이를 비교하며 최대 길이를 찾는 방법
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> column = new ArrayList<>();
        row.add(0);
        column.add(0);
        row.add(R);
        column.add(C);
        for (int cc = 0; cc < cut; cc++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken()); // 0이면 가로, 1이면 세로로 자르기
            int index = Integer.parseInt(st.nextToken());

            if (dir == 0) row.add(index);   //행 저장
            else column.add(index);     //열 저장
        }
        //정렬
        Collections.sort(row);
        Collections.sort(column);

        //가장 긴 행, 열 찾기
        int maxR = 0;
        int maxC = 0;
        for (int i=1; i<row.size(); i++) {
            int r = row.get(i)-row.get(i-1);
            if (maxR < r) maxR = r;
        }
        for (int i=1; i<column.size(); i++) {
            int c = column.get(i) - column.get(i-1);
            if (maxC < c) maxC = c;
        }

        System.out.println(maxR * maxC);
    }

}
