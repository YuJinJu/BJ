package com.hotfive.workbook.basic.ch7_문자열.n2941크로아티아알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [] str = br.readLine().toCharArray(); 
		int sum =0;
		
			for(int j=0;j<str.length;j++) {
				switch(str[j]) {
				case '-' :	break;
				case '=' :{
					if(j>1) {
						if(str[j-1]=='z' && str[j-2]=='d') sum--;
					}
					break;
				}
				case 'j' :{
					if(j>0) {
						if(str[j-1]=='l'||str[j-1]=='n') break;
						else sum++;
					}else sum++;

					break;
				}
				default : 
					if(str[j]>='a' && str[j]<='z') 
						sum++;
					break;
				}
			}
		System.out.println(sum);
	}

}
