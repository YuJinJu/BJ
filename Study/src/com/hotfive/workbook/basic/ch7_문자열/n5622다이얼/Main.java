package com.hotfive.workbook.basic.ch7_문자열.n5622다이얼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int time = 2;
		int sum =0;
		char [] str = br.readLine().toCharArray(); 

		for(int i=0;i<str.length;i++) {
			switch(str[i]) {
			case 'A':
			case 'B':
			case 'C': sum +=time+1;
					break;
			case 'D':
			case 'E':
			case 'F': sum +=time+2;
					break;
			case 'G':
			case 'H':
			case 'I': sum +=time+3;
					break;
			case 'J':
			case 'K':
			case 'L': sum +=time+4;
					break;
			case 'M':
			case 'N':
			case 'O': sum +=time+5;
					break;
			case 'P':
			case 'Q':
			case 'R':
			case 'S': sum +=time+6;
					break;
			case 'T':
			case 'U':
			case 'V': sum +=time+7;
					break;
			case 'X':
			case 'W':
			case 'Y':
			case 'Z': sum +=time+8;
					break;

			}
		}
		
		System.out.println(sum);
	}

}
