package com.hotfive.workbook.ch7_문자열.n1316그룹단어체커;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str [] = new String[n];
		int count = 0;
		
		for(int i=0;i<str.length;i++)
		{//단어수
			str[i]=br.readLine();
			int alph [] = new int [26];
			char c [] = str[i].toCharArray();	//한글자
			boolean yes = false;
			for(int j=0;j<c.length;j++) {	//그룹단어인지 단어마다 한글자씩 판별
				//있었던 알파벳인지, 연속되면 포함x
				
				if(alph[c[j]-97] == 0) {
					yes = true;
					alph[c[j]-97]++;
				}
				else {
					if(j>0) {
						if(c[j-1]==c[j]) yes = true; 
						else {
							yes = false;
							break;
						}
					}
				}
			}
			if(yes==true) count++; 
			
		}
		System.out.println(count);
			
		
	}

}
