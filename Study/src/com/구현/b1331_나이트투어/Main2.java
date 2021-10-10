package com.구현.b1331_나이트투어;

import java.util.Scanner;

public class Main2 {
    static int[][] map = new int[6][6];
    static int beforeR = 0;
    static int beforeC = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[6][6];
        //System.out.println('B'-64);

        int startR = 0;
        int startC = 0;

        for (int n = 0; n < 36; n++) {
            String str = sc.next();
            int r = str.charAt(0) - 'A';
            int c = str.charAt(1) - '0' - 1;
            //System.out.println(r+" "+c);
            if (n == 0) {
                startR = r;
                startC = c;
                beforeR = r;
                beforeC = c;
                continue;
            }
            if (!nightTour(r, c)) result(false);

        }

        // 마지막이 시작점으로 갈수있는지
        if (!nightTour(startR, startC)) result(false);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] != 1) result(false);
            }
        }
        result(true);

        sc.close();
    }

    private static void result(boolean b) {
        System.out.println(b ? "Valid" : "Invalid");
        System.exit(0);
    }

    private static boolean nightTour(int r, int c) {
        int rowL = Math.abs(r-beforeR);
        int columnL = Math.abs(c-beforeC);
        if((rowL==1&&columnL==2)||(rowL==2&&columnL==1)) {
            map[r][c]++;
            beforeR = r;
            beforeC = c;
            return true;
        }
        return false;
    }
}
