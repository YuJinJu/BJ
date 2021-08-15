package com.personal.n2960에라토스테네스의체;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		
		int arrN [] = new int [N+1];
		
		
		for(int i=0;i<=N;i++) {	//1. 2부터 N까지 모든 정수를 적는다.
			arrN[i] = i;
		}
		
		int count = 0;
		int temp = 0;
		for(int j=2;j<=N;j++) { //2. 아직 지우지 않은 수 중 가장 작은 수를 찾는다.
			if(arrN[j] != 0) { //이를 P라고 하고, 이는 소수이다.
				for(int k=1;j*k<=N;k++) {	//3. P를 지우고 아직 지우지 않은 P의 배수를 순서대로 지운다.
					if(arrN[j*k] !=0) {
						arrN[j*k]=0;
						count++;
						if(count==K) temp = j*k;
					}
				}
			}								//4. 아직 모든수를 지우지 않았으면 다시 2번으로 간다
			if(temp != 0) break;
		}
		System.out.println(temp);
		
		
	}

}
