package com._unsol.b3085_사탕게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char map [][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < N; c++) {
                map[r][c] = str.charAt(c);
            }
        }
        //처음꺼 숫자세기
        for (int i = 0; i <N ; i++) {
            rowMax(i);
            columnMax(i);
        }

        // 행.. 인접하지만 서로 다른 색
        for (int c = 0; c < N; c++) {
            for (int r = 1; r < N; r++) {
                if(map[r-1][c] != map[r][c]){   // 다른 색이면 교환하기
                    char tmp = map[r-1][c];
                    map[r-1][c] = map[r][c];
                    map[r][c] = tmp;
                    // 바뀐 행과 열에서 상근이가 먹을수 있는 사탕의 최대 갯수 세기
                    rowMax(r-1);
                    rowMax(r);
                    columnMax(c);

                    //print();

                    // 다시 사탕원래대로 돌려놓기
                    char tmp2 = map[r-1][c];
                    map[r-1][c] = map[r][c];
                    map[r][c] = tmp2;
                }
            }
        }
        // 열.. 인접하지만 서로 다른 색
        for (int r = 0; r < N; r++) {
            for (int c = 1; c < N; c++) {

                if(map[r][c-1] != map[r][c]){   // 다른 색이면 교환하기
                    char tmp = map[r][c-1];
                    map[r][c-1] = map[r][c];
                    map[r][c] = tmp;
                    // 바뀐 행과 열에서 상근이가 먹을수 있는 사탕의 최대 갯수 세기
                    rowMax(r);
                    columnMax(c-1);
                    columnMax(c);

                    //print();

                    // 다시 사탕원래대로 돌려놓기
                    char tmp2 = map[r][c-1];
                    map[r][c-1] = map[r][c];
                    map[r][c] = tmp2;
                }
            }
        }

        System.out.println(max);
        br.close();
    }

    private static void print() {
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map.length; c++) {
                System.out.print(map[r][c]);
            }
            System.out.println();
        }
        System.out.println("----------");
    }

    static int max = 0;
    private static void rowMax(int r) {
        int cnt = 1;
        for (int c = 1; c < map.length; c++) {
            if(map[r][c-1] == map[r][c]) {
                cnt++;
                max = Math.max(cnt,max);
            }
            else cnt = 1;
        }

    }
    private static void columnMax(int c) {
        int cnt = 1;
        for (int r = 1; r < map.length; r++) {
            if(map[r-1][c] == map[r][c]) {
                cnt++;
                max = Math.max(cnt,max);
            }
            else cnt = 1;
        }

    }
}
