package com.hotfive.workbook.ch2_if.n14681사분면고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		int Quadrant =0;
		
		if(x>0&&y>0) Quadrant = 1;
		else if(x<0&&y>0) Quadrant = 2;
		else if(x<0&&y<0) Quadrant = 3;
		else if(x>0&&y<0) Quadrant = 4;
		
		System.out.println(Quadrant);
	}

}
