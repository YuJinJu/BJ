package com.구현.b3009_네번째점;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ax = sc.nextInt();
        int ay = sc.nextInt();
        int bx = sc.nextInt();
        int by = sc.nextInt();
        int cx = sc.nextInt();
        int cy = sc.nextInt();

        int x = 0;
        int y = 0;
        if(ax!=bx){
            if(cx==ax) x=bx;
            else x=ax;
        }else{
            x=cx;
        }
        if(ay!=by){
            if(cy==ay) y=by;
            else y=ay;
        }else{
            y=cy;
        }
        System.out.println(x+" "+y);
        sc.close();
    }
}
