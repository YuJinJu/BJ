package com._unsol.b18115_카드놓기;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] skill = new int[N];
        Deque<Integer> card = new LinkedList<>();
        Deque<Integer> result = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            card.add(i);
            skill[i-1] = Integer.parseInt(st.nextToken());
        }

        for (int n = N-1; n >= 0; n--) { // 다음 스킬들을 사용했을 때 앞에부터 1,2,3,,,N이 나와야한다.
            switch (skill[n]){ // 전부 스킬을 반대로 사용하기~~
                case 1 : // 해당카드를 젤위에 둔다.
                    result.push(card.pollFirst());
                    break;

                case 2 : // 해당 카드를 앞에서 두번째에 둔다.
                    int first = 0;
                    if(!result.isEmpty()) first = result.pollFirst(); // 두번재에 넣기위해 제일 앞에있는카드 잠깐 빼고 넣기
                    result.addFirst(card.pollFirst());
                    if(first!=0) result.addFirst(first);
                    break;

                case 3 :    // 제일 뒤에 넣는다
                    result.addLast(card.pollFirst());
                    break;

            }
        }
        while (!result.isEmpty()){
            System.out.print(result.pollFirst()+" ");
        }

        br.close();
    }
}
