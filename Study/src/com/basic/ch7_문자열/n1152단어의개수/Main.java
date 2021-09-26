package com.basic.ch7_문자열.n1152단어의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		if(str.equals(" ")) System.out.println(0);
		else {
			char[] strC = str.toCharArray();
			int count = -1;
			
			if(strC[0] != ' ' || strC[1] !=' ' ) count = 0; //맨앞공백 처리
			for(int i=1;i<strC.length-1;i++) 
				if(strC[i-1]==' '&&strC[i]==' ') count=-1;	//연속공백 처리
				else if(strC[i]==' ') {
					count++;
				}
			System.out.println(++count);
		}
	}

}
 //The Curious Case of Benjamin Button