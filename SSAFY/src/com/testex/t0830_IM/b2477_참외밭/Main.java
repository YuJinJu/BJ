package com.testex.t0830_IM.b2477_참외밭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pair {
    int dir;
    int dis;

    public Pair(int dir, int dis) {
        this.dir = dir;
        this.dis = dis;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());    //참외 개수
        final int N = 6;    // 참외밭은 육각형 (꼭짓점 6개)

        int maxR = -999;
        int maxC = -999;
        ArrayList<Pair> list = new ArrayList<>();

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken()); //1 동, 2 서, 3 남, 4 북
            int dis = Integer.parseInt(st.nextToken());

            Pair p = new Pair(dir, dis);
            list.add(p);

            //최대 행, 최대 열 찾기
            if (dir == 1 || dir == 2) { //열
                maxC = Math.max(maxC, dis);
            } else if (dir == 3 || dir == 4) {  //행
                maxR = Math.max(maxR, dis);
            }
        }

        int find[] = new int[2];
        for (int i = 0; i < list.size(); i++) {

            //연속된 수(시작점과 끝점 연결되게)로 표현하고 싶으면 총 길이인 6을 나누어 주면 된다
            //작은 네모 앞 뒤 길이
            int x = list.get((i + 5) % N).dis; // 이전 길이
            int y = list.get((i + 1) % N).dis; // 다음 길이


            if(list.get(i).dir == 1 || list.get(i).dir == 2){   // 열

                if( x + y == maxR) //   행끼리 합
                    find[0] = list.get(i).dis;
            }
            else if(list.get(i).dir == 3 || list.get(i).dir == 4){  //행

                if (x + y == maxC)    //열끼리 합
                    find[1] = list.get(i).dis;
            }
        }

        int sum = maxR * maxC - (find[0] * find[1]);

        System.out.println(sum * K);
    }
}
