package com.hotfive.workbook.basic.ch2_if.n2753윤년;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		int yes = -1;	//윤년이면 1, 아니면 0
		
		if(year%4 == 0) {
			if(year%100 != 0 || year%400==0)	yes = 1;
		}

		System.out.print(yes);
		sc.close();
	}

}
/*
윤년 : 연도가 4의 배수 
	100의 배수지만 400의 배수이면 윤년
윤년 X : 100의 배수

ex
2012, 2000 - 윤년
1900 - 윤년X
 */