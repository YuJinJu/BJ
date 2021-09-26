package com.basic.ch5_array1.n8958OX퀴즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//StringBuilder
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test = Integer.parseInt(br.readLine());
		
		for(int t=0;t<test;t++) {
			int sum = 0;
			int count = 0;
			String s = br.readLine();
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='O') count++;
				else count=0;
				sum +=count;
			}
			sb.append(sum +"\n");	//저장
			
		}System.out.println(sb);	//출력
	}

}
