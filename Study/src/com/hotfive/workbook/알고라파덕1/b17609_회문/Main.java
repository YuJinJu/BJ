package com.hotfive.workbook.알고라파덕1.b17609_회문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) { // T개의 문자열을 회문 0/ 유사회문 1/ 그 외 2 인지 판단
            String str = br.readLine();
            int cnt = str.length();
//            sb.append("cnt:"+cnt+"\n");
            ArrayList<String> list = new ArrayList<>(); //유사회문 검사할때 쓰려고
            ArrayList<Character> strings = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                strings.add(str.charAt(i));
            }

            if (cnt % 2 == 0) {
                check(str, cnt,0);
            }
            // 회문 아닐 때.. 홀수이면 유사회문일 가능성 있음. 짝수이면 없음!
            else {
                list.add(str.charAt(0) + "");    //유사회문 검사할때 쓰려고

                for (int i = 1; i < cnt; i++) {
                    boolean yyy = false;
                    for (int j = 0; j < list.size(); j++) {
                        char c = list.get(j).charAt(0);
                        StringBuilder sb = new StringBuilder();

                        if (c == str.charAt(i)) {
                            yyy = true;
                            sb.append(list.get(j)).append(str.charAt(i));

                            list.set(j, sb.toString());
                            break;
                        }
                    }

                    if (!yyy)
                        list.add(str.charAt(i) + "");
                }


                boolean cc = true;
                char tmp = ' ';
                for (int i = 0; i < list.size(); i++) { // 리스트에 넣은 홀수개인 문자는 하나만 다른 문자이므로 유사회문
                    if (list.get(i).length() % 2 != 0) { // 리스트에 담긴 문자들 중 홀수인 곳 있으면 유사회문일 가능성 있음
                        cc = false;
                        tmp = list.get(i).charAt(0);
                        break;
                    }   // 리스트에 담긴 문자들이 모두 짝수이면 유사회문 가능성 없음

                }

                if (cc) sb.append(2);
                else {
                    strings.remove(new Character(tmp));
//                        strings.remove(tmp);  // 홀수개인 문자 빼고
                    String strr =  String.valueOf(strings);
                    //strr = strr.split(",");
                    check(strr, strings.size(), 1);  // 유사회문인지 체크하는 메소드로 확인
                }
            }

            sb.append('\n');

        }
        System.out.println(sb);
        br.close();
    }

    static void check(String str, int cnt, int c) {
        boolean palindrome = true;  // palindrome = 회문
        for (int i = 0; i < cnt / 2; i++) {

            if (str.charAt(i) != str.charAt(cnt - i - 1)) {
                palindrome = false;
            }
        }
        if (palindrome) {
            if (c==0) sb.append(0);    // 회문 일 때
            else sb.append(1);
        }
        else sb.append(2);

    }
}
