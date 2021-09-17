package com.hotfive.workbook.basic.ch5_array1.n8958OX퀴즈;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//BufferedWriter
public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
			bw.write(sum +"\n");	//저장
			
		}
		bw.flush();	//출력
		bw.close();
	}

}
