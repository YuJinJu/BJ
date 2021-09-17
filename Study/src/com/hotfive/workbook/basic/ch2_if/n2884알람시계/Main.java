package com.hotfive.workbook.basic.ch2_if.n2884알람시계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int h = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		final int MINUS = 45;
		
		if(h>=0 && h<=23 && m>=0 && h<=59) {
			if(m-45<0) {
				m = m+60-MINUS;
				h--;
				if(h<0)	h = h+24;
			}
			else m = m-MINUS;
		}
		System.out.println(h+" "+m);

	}

}

/*
45분 앞당기기
(0 ≤ H ≤ 23, 0 ≤ M ≤ 59)
*/
