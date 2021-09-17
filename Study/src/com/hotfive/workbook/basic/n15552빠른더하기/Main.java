package com.hotfive.workbook.basic.n15552빠른더하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(br.readLine());
		
		for(int i=0;i<test_case;i++) {
			String [] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]); 
			int b = Integer.parseInt(str[1]); 
			bw.write(a+b +"\n");	//"\n"를 해줘야 int로 변환됨
		}
		bw.flush();
		bw.close();
	}
}
