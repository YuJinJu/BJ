package com.Implement.b13300_방배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1. 같은성별
2. 같은학년
3. 한명만 방 사용 가능
4. 한 방에 배정할 수 있는 최대 인원 수 K가 주어졌을 때, 조건에 맞게 모든 학생 N을 배정하기 위해 필요한 방의 최소 개수
 */
public class Main {
    static int S;
    static int Y;
    static int[][] student;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        student = new int[7][2];  // 학년, 성별
        for (int n = 0; n < N; n++) {   // 성별 S- 0여,1남, 학년 Y
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            student[Y][S] += 1;
        }
        //print();

        int room = 0;
        for (int y = 1; y <= 6; y++) {
            for (int s = 0; s < 2; s++) {
                room += student[y][s] / K;  // 제한된 인원수대로 방에 담았는데
                if(student[y][s]%K!=0) room++;  // 인원이 남았을때 방추가로 주기
            }
        }
        System.out.println(room);

        br.close();
    }

    private static void print() {
        for (int y = 1; y <= Y; y++) {
            System.out.println(student[y][0] + " " + student[y][1]);
        }
    }


}
