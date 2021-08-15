package com.hotfive.workbook.ch7_문자열.n11720숫자의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int [] num = new int[N]; 
		
		int sum = 0;
		for(int i=0;i<num.length;i++) {
			num[i] = str.charAt(i)-'0';
			sum+=num[i];
		}
		System.out.println(sum); 
	}

}
