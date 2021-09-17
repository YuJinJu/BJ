package com.hotfive.workbook.basic.ch7_문자열.n2675문자열반복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testc = Integer.parseInt(br.readLine());
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<testc;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int R = Integer.parseInt(st.nextToken());	//반복되는수_문자열 (띄어쓰기)
			
			String S = st.nextToken();	//문자열
			
			char c [] = new char [S.length()];
			for(int j=0;j<S.length();j++) {
				c[j] = S.charAt(j);		//문자하나씩 
				
				for(int k=0;k<R;k++) {
					sb.append(c[j]);
				}
			}
			
			System.out.println(sb);
			sb.delete(0, sb.length());
		}
	}

}
