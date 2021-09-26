package com.array.b17144_미세먼지안녕;

//공기청정기는 항상 1번 열에 설치되어 있고, 크기는 두 행을 차지한다.
//공기청정기의 바람에 의해 미세먼지가 모두 한 칸씩 이동한다.
//공기청정기로 들어간 미세먼지는 모두 정화된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static int T;
    static int map [][];
    static int mapTmp [][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());   // 시간

        map = new int[R+1][C+1];
        mapTmp = new int[R+1][C+1];

        ArrayList<Integer> airCleaner = new ArrayList<>();
        int dustAmount = 0;
        for (int r = 1; r <= R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == -1) {
                   airCleaner.add(r);    // 공기청정기 위치는 무조건 1열이니까,, r만 저장해둔다
                }
            }
        }

        int R1 = airCleaner.get(0);
        int R2 = airCleaner.get(1);
        for (int t = 1; t <= T; t++) { // t초 만큼 작동
            dustStart(R1,R2); // 미세먼지 확산
            mapTmp = new int[R+1][C+1]; // 공기청정기에서도 담아야하므로 초기화해주기
            //print();
            airCleanStart(R1,R2);  // 공기청정기 작동
            mapTmp = new int[R+1][C+1];
            //print();
        }
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if(map[r][c] != -1 && map[r][c] != 0) dustAmount += map[r][c];
            }
        }

        System.out.println(dustAmount);
        br.close();
    }

//    private static void print() {
//        for (int r = 1; r <= R; r++) {
//            for (int c = 1; c <= C; c++) {
//                System.out.print(map[r][c]+" ");
//                //if(map[r][c] != -1 && map[r][c] != 0) dustAmount += map[r][c];
//            }
//            System.out.println();
//        }
//        System.out.println("-------------------");
//    }

    // 2~n열에는 미세먼지가 있고, (r, c)에 있는 미세먼지의 양은 x이다.
    // 1초동안 4방향으로 확산.. 공기청정기 있거나 칸없으면 확산안됨
    // 확산되는 미세먼지는 x/5이고 소수점은 버린다. 기존의 미세먼지는 x - (x/5) * 확산된 방향 수

    //우상좌하
    static int [] dr = {0,-1,0,1};
    static int [] dc = {1,0,-1,0};

    // 미세먼지 확산
    private static void dustStart(int cleanR1, int cleanR2) {

        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if(map[r][c] != -1 || map[r][c] !=0){
                    int originDust = map[r][c];  // 기존 미세먼지 담아두기
                    int dir = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        // 범위 넘어갈때와 확산된 먼지가 공기청정기와 같은 위치일 때
                        if(nr<1 || nc<1 || nr>R || nc>C || map[nr][nc] == -1 ) continue;
                        mapTmp[nr][nc] += originDust / 5;   //확산되는 미세먼지
                        dir++;
                    }
                    mapTmp[r][c] += originDust - (originDust/5) * dir; // 기존 미세먼지 감소
                }
            }
        }

        mapTmp[cleanR1][1] = -1;
        mapTmp[cleanR2][1] = -1;
        map = mapTmp;  // n초일 때 똑같은 작업을 반복해야하므로 덮어씌우기

    }

    private static void airCleanStart(int cleanR1, int cleanR2) {

        for (int i = C; i > 2 ; i--) { // 우
            mapTmp[cleanR1][i] = map[cleanR1][i-1];
            mapTmp[cleanR2][i] = map[cleanR2][i-1];
        }
        for (int i = 1; i < cleanR1 ; i++) { // C열 상
            mapTmp[i][C] = map[i+1][C];
        }
        for (int i = R; i > cleanR2 ; i--) { // C열 하
            mapTmp[i][C] = map[i-1][C];
        }
        for (int i = 1; i < C ; i++) {  // 좌
            mapTmp[1][i] = map[1][i+1];
            mapTmp[R][i] = map[R][i+1];
        }
        for (int i = cleanR1-1; i >1 ; i--) { // 1열 하
            mapTmp[i][1] = map[i-1][1];
        }
        for (int i = cleanR2+1; i < R ; i++) { // 1열 상
            mapTmp[i][1] = map[i+1][1];
        }

        mapTmp[cleanR1][1] = -1;
        mapTmp[cleanR2][1] = -1;

        for (int i = 2; i <= R-1; i++) {
            for (int j = 2; j <= C-1 ; j++) {
                if(i == cleanR1 || i == cleanR2) continue;
                mapTmp[i][j] = map[i][j];
            }
        }
        map = mapTmp;  // n초일 때 똑같은 작업을 반복해야하므로 덮어씌우기
    }
}
