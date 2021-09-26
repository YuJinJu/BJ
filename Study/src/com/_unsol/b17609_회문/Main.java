package com._unsol.b17609_회문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 문자열의 길이는 3 이상 100,000 이하
// 회문 0 :  앞 뒤 방향으로 볼 때 같은 순서의 문자로 구성된 문자열  ‘abba’ ‘kayak’, ‘reviver’, ‘madam’ (홀짝 둘 다 가능)
// 유사회문 1 : 한 문자를 삭제하여 회문으로 만들 수 있는 문자열
// 둘다 아니면 2
public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) { // T개의 문자열을 회문 0/ 유사회문 1/ 그 외 2 인지 판단
            String str = br.readLine();
            ArrayList<Character> chars = new ArrayList<>();
            ArrayList<Character> tmp = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                chars.add(str.charAt(i));
                tmp.add(str.charAt(i));
            }
            int [] count = new int[str.length()];

            int half = str.length()/2;
            if(!check(half,str)) { // 회문이 아니면
                //한 문자를 삭제하고 다시 회문 확인 메소드 돌리기
                // 회문이 아니면 문자의 종류의 갯수를 세서 홀수인 문자를 한번씩 전부 빼보고 다시 회문인지 검사

                for (int i = 0; i < str.length(); i++) {
                    for (int j = 0; j < chars.size(); j++) {
                        if(str.charAt(i)==chars.get(j)) {
                            count[i]++;
                            chars.set(j,' ');
                        }
                    }
                }
                for (int i=0;i<count.length; i++) {
                    if(count[i]%2!=0){
                        if(tmp.contains(str.charAt(i)))
                        tmp.remove(str.charAt(i));
                    }
                }
                System.out.println(chars);
                // 이때 회문이면 1 출력 아니면 2 출력
                //if(!check(half,str))
                //System.out.println(1);
            }else { // 회문이면
                //System.out.println(0);
            }

        }
        br.close();
    }

    // 회문이면 true, 아니면 false
    private static boolean check(int half, String str) {
        // 문자수가 짝수일때는 앞뒤만 비교하여 회문검사
        // 문자수가 홀수일때는 가운데 빼고 비교하여 회문검사
        for (int i = 0; i < half; i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i)) return false;    // 하나라도 다르면 회문이 아니다.
        }
        return true;
    }


}
