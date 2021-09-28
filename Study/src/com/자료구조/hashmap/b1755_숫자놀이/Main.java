package com.자료구조.hashmap.b1755_숫자놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 7 10 을 입력하면.. 8 9 10 7 형태로 정렬되어야한다
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // M~N의 정수
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

//		79를 영어로 읽을 때 숫자 단위로 하나씩 읽는다면 ＂seven nine＂이 된다.
//		80은 마찬가지로 ＂eight zero＂라고 읽는다. 79는 80보다 작지만, 영어로 숫자
//		하나씩 읽는다면 ＂eight zero＂가 ＂seven nine＂보다 사전 순으로 먼저 온다
        // 아 문자열 정렬하라는 의미

        String[] alpha = { "zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        int[] arr = new int[N + 1];// M~N의 정수를 담을 배열

        String[][] sol = new String[N -M + 1][2]; // 문자열 정답

        int cnt=0;
        for (int i = M; i <= N; i++) {
            arr[i] = i;
            if (arr[i] >= 10) {// 정수가 10보다 이상이면 두글자
                int index1 = arr[i] / 10;// 첫번째 자리
                sol[cnt][0] = alpha[index1]; // 숫자를 문자열로 바꿔 저장

                int index2 = arr[i] % 10; // 두번째 자리
                sol[cnt][1] = alpha[index2];
            } else {// 1의 자리일 때
                sol[cnt][0] = alpha[arr[i]]; // 숫자를 문자열로 바꿔 저장
                sol[cnt][1]=""; // nullpoint 에러 방지
            }
            cnt++; // 문자열 인덱스 증가
        }

        // 정렬
        Arrays.sort(sol, new Comparator<String []>(){
            public int compare(String [] o1, String [] o2){

                if(o1[0].equals(o2[0])){    // 10의자리가 같으면
                    return o1[1].compareTo(o2[1]);  // 1의자리로 비교
                }else {
                    return o1[0].compareTo(o2[0]); // 10의자리로 비교
                }
            }
        });

        int [] solNum = new int[N+1];	// 문자열을 숫자로 바꿔서 배열에 담는 곳
        int cntt = 0;
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < alpha.length; j++) {

                if(sol[i][0].equals(alpha[j])){
                    if(!sol[i][1].equals(""))solNum[cntt] += j*10;
                    else solNum[cntt] += j;
                }
                if(!sol[i][1].equals("") && sol[i][1].equals(alpha[j])) {
                    solNum[cntt] += j;
                }
            }
            cntt++;
        }

//        for (int i = 0; i < sol.length; i++) {
//            System.out.println(sol[i][0]+" "+sol[i][1]);
//        }

        for (int i = 0; i <= N-M; i++) {
            System.out.print(solNum[i]+" ");
            if((i+1) %10 == 0) System.out.println();
        }

        br.close();
    }

}
