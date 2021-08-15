package com.hotfive.workbook.ch1_IO와사칙연산.n2588곱셈;

//세자리수 x 세자리수
/*
입력
472
385

출력
2360
3776
1416
181720
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int n3 = a * (b%10);
		int n4 = a * ((b%100)/10);
		int n5 = a * (b/100);
		
		System.out.println(n3);
		System.out.println(n4);
		System.out.println(n5);
		System.out.println(a*b);
		
		sc.close();
	}

}
