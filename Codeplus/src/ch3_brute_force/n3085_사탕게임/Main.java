package ch3_brute_force.n3085_사탕게임;

import java.util.*;

//시간복잡도 O(N^4)
public class Main {

    //가장 긴 연속부분을 찾는 메소드 O(N^2)
    static int check(char[][] a) {
        int n = a.length;
        int ans = 1;

        for (int i=0; i<n; i++) {

            int cnt = 1; //인접한 사탕의 개수
            for (int j=1; j<n; j++) { //열
                if (a[i][j] == a[i][j-1]) { //i행에서 1열씩 증가하며 인접한 사탕 있는지 검사
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (ans < cnt) ans = cnt; //최대의 인접함 찾기
            }

            cnt = 1;
            for (int j=1; j<n; j++) { //행
                if (a[j][i] == a[j-1][i]) { //i열에서 1행씩 증가하며 인접한 사탕 있는지 검사
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (ans < cnt) ans = cnt;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] a = new char[n][n];
        for (int i=0; i<n; i++) {
            a[i] = sc.next().toCharArray();
        }

        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) { //i행에서 1열씩 증가
                if (j+1 < n) { //오른쪽
                    char t = a[i][j]; a[i][j] = a[i][j+1]; a[i][j+1] = t; //교환
                    int temp = check(a); //가장 긴 사탕 찾기
                    if (ans < temp) {
                        ans = temp;
                        for (char [] k: a){
                            for (char l :k) System.out.print(l);
                            System.out.println();
                        }
                        System.out.println(ans);
                    }
                    t = a[i][j]; a[i][j] = a[i][j+1]; a[i][j+1] = t; //모든 경우를 검사해야 하기 때문에 교환한것 다시 원래대로
                }
                if (i+1 < n) { //아래
                    char t = a[i][j]; a[i][j] = a[i+1][j]; a[i+1][j] = t;
                    int temp = check(a);
                    if (ans < temp) ans = temp;
                    t = a[i][j]; a[i][j] = a[i+1][j]; a[i+1][j] = t;
                }
            }
        }

        System.out.println("ans : "+ans);
    }
}
