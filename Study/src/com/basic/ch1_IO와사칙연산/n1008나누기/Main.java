package com.basic.ch1_IO와사칙연산.n1008나누기;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		
		System.out.printf("%.12f",a/b);

		sc.close();
	}

}
