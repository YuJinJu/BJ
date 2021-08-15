package com.personal.n9613GCD합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static long gcd(long a, long b) {
		long result = 0;
		
		while(true) {
			long c =a%b;
			if(c==0) {
				result = b;
				break;
			}
			a = b;
			b = c;
		}
		
		return result;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			String [] tc = br.readLine().split(" ");
			int n = Integer.parseInt(tc[0]);
			
			long GCD [] = new long[n];
			for(int j=0;j<n;j++) GCD[j] = (long)Integer.parseInt(tc[j+1]);
			
			long a,b=0;
			long sum = 0;
			
			for(int x=0;x<n-1;x++) {
				for(int y=x+1;y<n;y++)	{
					a = GCD[x];
					b = GCD[y];
					if(a>b) {
						sum+=gcd(a,b);
					}else sum+=gcd(b,a);
				}
			}
			
			System.out.println(sum);
		}
		
		
	}
}
