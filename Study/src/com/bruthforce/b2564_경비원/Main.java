package com.bruthforce.b2564_경비원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pos {
    int r;
    int c;
    int dir;

    //dir에 의해 좌표 지정
    public Pos(int r, int c, int dir, int dis) {
        this.dir = dir;

        switch (dir) {
            case 1: //북
                this.r = 0;
                this.c = dis;
                break;
            case 2: //남
                this.r = r;
                this.c = dis;
                break;
            case 3: //서
                this.r = dis;
                this.c = 0;
                break;
            case 4: //동
                this.r = dis;
                this.c = c;
                break;
            default:
                break;
        }
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        //상점
        int N = Integer.parseInt(br.readLine());    //상점 갯수
        ArrayList<Pos> storeList = new ArrayList<>();  //상점 저장리스트

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int dir = Integer.parseInt(st.nextToken()); //위치
            int dis = Integer.parseInt(st.nextToken()); //거리

            Pos p = new Pos(R, C, dir, dis);    //상점 객체생성, 좌표지정
            storeList.add(p);    //상점들 저장
        }

        //동근이
        st = new StringTokenizer(br.readLine());
        int dongDir = Integer.parseInt(st.nextToken());
        int dongDis = Integer.parseInt(st.nextToken());

        Pos dong = new Pos(R, C, dongDir, dongDis);     //동근이 객체생성, 좌표지정

/**************************************여기까지 input, 객체 생성 - 좌표 지정 ***************************/

        //동근이와 상점의 최소거리 합
        int sum = 0;
        int b = 0;

        //규칙성
        //동근이나 상점이 서로 반대편에 있을 때 거리는 두 가지 경우
        // 1. (0,0)을 지나는 방법 - 두 좌표의 합 (변수 a)
        // 2. (R,C)를 지나는 방법 - 변수 b 참고

        //동근이나 상점이 양 옆이나 같은 라인에 있을 때 거리는 두 좌표 차의 절대값의 합

        for (Pos store : storeList) {    //리스트에 담긴 모든 상점

            // 반대편일 때
            if ((dong.dir == 1 && store.dir == 2) || (dong.dir == 2 && store.dir == 1) || (dong.dir == 3 && store.dir == 4) || (dong.dir == 4 && store.dir == 3)) {

                // 1. (0,0)을 지나는 방법
                int a = store.r + dong.r + store.c + dong.c;

                //2. (R,C)를 지나는 방법
                if ((dong.dir == 1 && store.dir == 2) || (dong.dir == 2 && store.dir == 1)) {   //위 아래
                    b = C - store.c + C - dong.c + R;
                } else if ((dong.dir == 3 && store.dir == 4) || (dong.dir == 4 && store.dir == 3)) { //좌 우
                    b = R - store.r + R - dong.r + C;
                }

                sum += Math.min(a, b);   // 두가지 방법 중 최소 거리를 골라 더해줌

            } else
                sum += Math.abs(store.r - dong.r) + Math.abs(store.c - dong.c);//양 옆 모서리나, 같은 라인에 있을 때

        }
        System.out.println(sum);

    }
}
