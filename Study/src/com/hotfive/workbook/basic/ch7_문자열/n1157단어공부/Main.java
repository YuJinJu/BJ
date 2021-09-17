package com.hotfive.workbook.basic.ch7_문자열.n1157단어공부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 
//단, 대문자와 소문자를 구분하지 않는다.

//가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int arr[] = new int[26];
		int max = 0; 
		char result = ' ';
		
		for(int i=0;i<str.length();i++) {
			for(char j='A';j<='Z';j++) {//대문자
				char s= (char) (j+32); //소문자	//대문자 + 32 = 소문자, 소문자 - 32 = 대문자
				if(str.charAt(i) == j || str.charAt(i) == s) {	// i번째 문자가 대문자, 소문자 있으면
					arr[j-65]++;	//배열 0부터 넣어주기 //A --> 65
					
					if(max < arr[j-65]) {
						max = arr[j-65];
						result = j;
					}
					
					if(max==arr[j-65] && result != j) result = '?';
					break;
				}
			}
		}

		System.out.println(result);
	}

}
