package com.hotfive.workbook.ch7_문자열.n2941크로아티아알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [] str = br.readLine().toCharArray(); 
		int sum =0;
		
			for(int j=0;j<str.length;j++) {
				switch(str[j]) {
				case '-' :break;
				case '=' :{
					if(j>1) {
						if(str[j-1]=='z' && str[j-2]=='d') sum--;
						break;
					} else break;
				}
				case 'j' :{
					if(j>0) {
						if(str[j-1]=='l'||str[j-1]=='n') break;
						else sum++; break;
					}else sum++; break;
						
				}
				default : 
					if(str[j]>='a' && str[j]<='z') 
						sum++;
				}
			}
			
		System.out.println(sum);
	}

}
