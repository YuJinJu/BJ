package com.simulation.b17143_낚시왕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pos {
    int r;
    int c;
    int s;
    int d;
    int z;

    public void setRC(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public void setD(int d) {
        this.d = d;
    }

    public Pos(int r, int c, int s, int d, int z) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public int getS() {
        return s;
    }

    public int getD() {
        return d;
    }

    public int getZ() {
        return z;
    }
}

public class Main {
    static int R;
    static int C;
    static Pos[][] map;
    static int [] dr = {0, -1, 1, 0, 0};
    static int [] dc = {0, 0, 0, 1, -1};
    static ArrayList<Pos> sharkList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());   // 상어수
        map = new Pos[R + 1][C + 1];

        for (int m = 0; m < M; m++) {   // 상어정보
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());   // 상어위치 r,c
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());   // 속력
            int d = Integer.parseInt(st.nextToken());   // 방향
            int z = Integer.parseInt(st.nextToken());   // 크기

            Pos shark = new Pos(r, c, s, d, z);
            sharkList.add(shark);
        }

        int hunt = 0;
        // 낚시왕이 오른쪽끝까지 이동할때까지 반복, 한칸이동시 1초
        for (int m = 1; m <= C; m++) {  //step1. 낚시왕 이동
            // 상어를 행 기준으로 정렬
            Collections.sort(sharkList, new Comparator<Pos>() {
                @Override
                public int compare(Pos o1, Pos o2) {
                    return o1.getR() - o2.getR();
                }
            });

            //step2:  // 낚시왕과 같은 열인 상어 중 땅과 가까운 상어 잡기
            for (Pos s : sharkList) {
                if (m == s.getC()) {
                    hunt += s.getZ();
                    sharkList.remove(s);
                    break;
                }
            }
            // step3
            move();
        }

        System.out.println(hunt);
        br.close();
    }

    private static void move() {
        Queue<Pos> rm = new LinkedList<>();
        map = new Pos[R + 1][C + 1];
        for (Pos s : sharkList) {
            //경계를 넘는 경우에는 방향을 반대로 바꿔서 속력을 유지한채로 이동
            int m = 0;
            int distance = s.getS();
            if (s.getD() == 1 || s.getD() == 2) distance = distance % ((R - 1) * 2);
            else distance = distance % ((C - 1) * 2);
            while (m < distance) { //이동할 거리만큼 반복
                int d = s.getD();  // 범위 넘어가면 방향 바꾸기    // 위 아래 오른 왼
                int nr = s.getR() + dr[d];
                int nc = s.getC() + dc[d];

                if (nr <= 0 || nc <= 0 || nr > R || nc > C) {
                    if (d == 2) d = 1;
                    else if (d == 1) d = 2;
                    else if (d == 3) d = 4;
                    else if (d == 4) d = 3;

                    s.setD(d);
                    continue;
                }

                m++;
                s.setRC(nr, nc);
                s.setD(d);
            }

            // 상어가 둘 이상 같은 위치에 있으면 작은상어 없애기
            if (map[s.getR()][s.getC()] != null) {
                if (map[s.getR()][s.getC()].getZ() < s.getZ()) {// 이미 담겨있는애가 큰지 내가 큰지
                    rm.add(map[s.getR()][s.getC()]);
                    map[s.getR()][s.getC()] = s;    // 맵에 있는것도 바꿔주기
                } else {
                    rm.add(s);
                }
            } else {
                map[s.getR()][s.getC()] = s;
            }
        }
        // 전부이동후 중복되는 위치 삭제
        while (!rm.isEmpty()) {
            sharkList.remove(rm.poll());
        }
    }

}
