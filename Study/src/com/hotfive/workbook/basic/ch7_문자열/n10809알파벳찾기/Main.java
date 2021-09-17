package com.hotfive.workbook.basic.ch7_문자열.n10809알파벳찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char [] alph = new char[str.length()];
		
		for(int i=0;i<alph.length;i++) alph[i] = str.charAt(i);
		
		int yes = -1;	//처음등장하는 위치
		for(int i ='a';i<='z';i++) {
			yes = -1;
			for(int j=0;j<alph.length;j++)
				if(i==alph[j]) {yes = j; break;}
			
			System.out.print(yes+" ");
		}
		
	}

}
//알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서, 
//단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
// --> StringTokenizer ??


//각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.
//만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다. 
//단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.

//입력 : baekjoon
//출력 : 1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 