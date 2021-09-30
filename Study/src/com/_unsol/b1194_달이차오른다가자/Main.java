package com._unsol.b1194_달이차오른다가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//미로를 탈출하는데 걸리는 이동 횟수의 최솟값
public class Main {
    static int R;
    static int C;
    static char [][] map;
    // 우 하 좌 상
    static int [] dr = {0,1,0,-1};
    static int [] dc = {1,0,-1,0};
    static Queue<int[]> queue = new LinkedList<>();
    private static int count=0;
    private static int min = Integer.MAX_VALUE;
    static ArrayList<Character> key = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];


        int startR =0;
        int startC =0;
        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
                if(map[r][c]=='0') {    // 출발지
                    startR = r;
                    startC = c;
                    //System.out.println(r+","+c);
                }
            }
        }


        System.out.println(bfs(new int[]{startR,startC}) ? min : -1);

        for (char k :
                key) {
            System.out.println(k);
        }
        //print();
        //System.out.println(min);

        br.close();
    }

    private static void print() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                System.out.print(map[r][c]);
            }
            System.out.println();
        }
    }

    private static boolean bfs(int[] v) {
        int r = v[0];
        int c = v[1];
        queue.add(new int[]{r,c});
        count = 0;

        while (!queue.isEmpty()){
            v = queue.poll();
            r = v[0];
            c = v[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr<0||nc<0||nr>=R||nc>=C) continue;

                //언제 초기화를 해주는 지 모르겠다
                reset();

                char ch = map[nr][nc];
                if (ch=='0'){
                    move(nr,nc);          //언제나 이동 가능
                }
                else if (ch =='.') move(nr,nc);
                else if (ch =='#') continue;        // 이동 불가
                else if (ch >= 'a' && ch <= 'z') {
                    key.add(getKey(ch));                        // 열쇠 습득
                    move(nr,nc);
                }else if (ch >= 'A' && ch <= 'Z') {
                    if(open(ch)) move(nr,nc);       // 열쇠가 있어야지만 열 수 있다
                }
                else if (ch =='1'){
                    if(min>count) min = count;
                    return true;      // 도착지, 탈출.. 적어도 1개이상
                }
            }

        }
        return false;
    }

    private static void reset() {
        count=0;
        key = new ArrayList<>();
        min = Integer.MAX_VALUE;
    }

    private static void move(int nr, int nc) {
        queue.add(new int[]{nr,nc});
        count++;
    }

    private static char getKey(char ch) {
        //대문자로 바꿔주는 역할
        return (char)(ch - 32);
    }

    // 키가 존재하면 true
    private static boolean open(char ch) {
        return key.contains(ch);
    }

}
