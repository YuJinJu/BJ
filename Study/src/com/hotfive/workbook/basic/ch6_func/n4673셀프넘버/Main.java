package com.hotfive.workbook.basic.ch6_func.n4673셀프넘버;

public class Main {
	static int d(int num){
		int sum = num;
		while(num != 0) {
			sum += num % 10;
			num /= 10;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		int arr [] = new int [11111];
		int num=0;
		for(int i=1;i<=10000;i++) {
			num = i;
			
			while(d(num)<=10000){
				arr[d(num)]++;
				num = d(num);
			}
		}

		for(int i=1;i<=10000;i++) 
			if(arr[i] == 0) sb.append(i+"\n");
		
		System.out.println(sb);
	}

}
