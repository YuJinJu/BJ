package com.testex.t0817_basicalgo.w0813.array.로봇;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    //우 하 좌 상
    private static int dr [] = {0,1,0,-1};
    private static int dc [] = {1,0,-1,0};
    static int N;
    static char map[][];
    static int cnt=0;

    static void right(int i, int j){
        int nr = i + dr[0];
        int nc = j + dc[0];
        while(nc<N && map[nr][nc]=='S'){    //오른쪽으로만 이동
            nc++;
            cnt++;  //이동할 수 있는 수
        }
        return;
    }

    static void left(int i, int j){
        int nr = i + dr[2];
        int nc = j + dc[2];
        while(nc>=0 && map[nr][nc]=='S'){
            nc--;
            cnt++;  //이동할 수 있는 수
        }
        return;
    }

    static void up(int i, int j){
        int nr = i + dr[3];
        int nc = j + dc[3];
        while(nr>=0 && map[nr][nc]=='S'){
            nr--;
            cnt++;  //이동할 수 있는 수
        }
        return;
    }

    static void down(int i, int j){
        int nr = i + dr[1];
        int nc = j + dc[1];
        while(nr<N && map[nr][nc]=='S'){
            nr++;
            cnt++;  //이동할 수 있는 수
        }
        return;
    }



    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("SSAFY/src/com/testex/t0817_basicalgo/w0813/array/로봇/Solution1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T= Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            N= Integer.parseInt(br.readLine());

            map= new char[N][N];
            for(int i=0; i<N; i++){
                StringTokenizer st= new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                   map[i][j] = st.nextToken().charAt(0);
                }
            }

            cnt = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){

                    char robot = map[i][j];
                    switch (robot){
                        case 'A' :
                            right(i,j);
                            //System.out.println("A:"+cnt);
                            break;
                        case 'B' :
                            right(i,j);
                            left(i,j);
                            //System.out.println("B:"+cnt);

                            break;

                        case 'C' :
                            //우 하 좌 상
                            right(i,j);
                            down(i,j);
                            left(i,j);
                            up(i,j);
                            //System.out.println("C:"+cnt);

                            break;
                        default:
                            break;
                    }
                }
            }

            bw.append(t+":"+cnt+" ");
        }
        bw.flush();

        bw.close();
    }
}
