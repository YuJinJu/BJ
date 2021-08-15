package com.hotfive.workbook.ch6_func.n1065한수;

//어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. 
//N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하시오
/*

1  : 초항이 1인 공차가 0인 등차수열   

2 1 0 : 초항이 2이고 공차가 -1인 등차수열

7 : 초항이 7이고 공차가 0인 등차수열

9 8 : 초항이 9이고 공차가 -1인 등차수열 

8 9 : 초항이 8이고 공차가 1인 등차수열

--> 즉, 1~99까지는 모두 한수
 */


//한수인지 판별하는 메소드
//존재할 수 있는 공차는 1, 2, 3, 4 밖에 없음

import java.util.Scanner;

public class Main {
	static boolean hansu(int n) {
		boolean result = false;
		int a,b,c = 0;
		
		a = n/100;
		n%=100;
		b= n/10;
		n%=10;
		c= n;
		
		if(a>=b && b>=c) {	// 111도 포함
			if(a-b == b-c) result = true;
		}else if(a<b && b<c) {
			if(c-b == b-a)	result = true;
		}else result = false;
		
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//1~1000
		int count = 0;
		
		if(N>0 && N<100) count = N;	
		else if(N > 99) {
			count = 99;
			
			for(int i=111;i<=N;i++) {
				if(hansu(i)==true) count++;
			}
		}
		
		System.out.println(count);
		
		sc.close();
	}

}
